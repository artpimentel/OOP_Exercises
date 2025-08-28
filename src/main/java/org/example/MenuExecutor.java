package org.example;

import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MenuExecutor {

    public void runMenuForPackage(Scanner scanner, String packageName) {
        try {
            List<Class<?>> executableClasses = findExecutableClasses(packageName);

            if (executableClasses.isEmpty()) {
                System.out.println("\nNenhuma classe executável encontrada em '" + packageName + "'.\n");
                return;
            }

            while (true) {
                System.out.println("\nQual item de '" + packageName + "' você quer executar?");
                int index = 1;
                for (Class<?> cls : executableClasses) {
                    System.out.println(index + " - " + cls.getSimpleName());
                    index++;
                }
                System.out.println("0 - Voltar ao menu principal");
                System.out.print("\nSua opção: ");

                int option = scanner.nextInt();

                if (option == 0) {
                    break;
                }

                if (option > 0 && option <= executableClasses.size()) {
                    Class<?> chosenClass = executableClasses.get(option - 1);

                    Executable instance = (Executable) chosenClass.getConstructor().newInstance();
                    instance.run();
                } else {
                    System.out.println("Opção inválida, tente novamente.");
                }
            }

        } catch (Exception e) {
            System.err.println("Ocorreu um erro ao carregar/executar as classes do pacote: " + packageName);
            e.printStackTrace();
        }
    }

    private List<Class<?>> findExecutableClasses(String packageName) throws Exception {
        List<Class<?>> classes = new ArrayList<>();

        String path = packageName.replace('.', '/');
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL resource = classLoader.getResource(path);

        File directory = new File(resource.toURI());

        for (File file : directory.listFiles()) {
            if (file.getName().endsWith(".class")) {
                String className = packageName + "." + file.getName().substring(0, file.getName().length() - 6);
                Class<?> cls = Class.forName(className);

                if (Executable.class.isAssignableFrom(cls) && !cls.isInterface()) {
                    classes.add(cls);
                }
            }
        }
        return classes;
    }
}