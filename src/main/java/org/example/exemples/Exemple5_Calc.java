package org.example.exemples;

import org.example.Executable;

import java.util.Scanner;

public class Exemple5_Calc implements Executable {

    public static int menu(float mem) {
        System.out.println("Estado da Memória: " + mem);
        System.out.println("===================");
        System.out.println("[1] Somar");
        System.out.println("[2] Subtrair");
        System.out.println("[3] Múltiplicar");
        System.out.println("[4] Dividir");
        System.out.println("[5] Limpar Memória");
        System.out.println("[0] Sair da Calculadora");
        System.out.println("===================");
        System.out.println("O que desejas: ");
        int op = lerInt();

        return op;
    }

    public static int lerInt() {
        Scanner teclado = new Scanner(System.in);

        int var = teclado.nextInt();
        teclado.nextLine();

        return var;
    }

    public static float lerFloat() {
        Scanner teclado = new Scanner(System.in);

        float var = teclado.nextFloat();
        teclado.nextLine();

        return var;
    }

    @Override
    public void run() {
        System.out.println("Executando o Exemple4...");
        System.out.println("");

        float memoria = 0;
        while (true) {
            int opcao = menu(memoria);

            float n;
            switch (opcao) {
                default:
                    System.out.print("Opção inválida, tente novamente: ");
                case 1:
                    System.out.print("O que deseja somar? ");
                    n = lerFloat();
                    memoria = memoria+n;
                    break;
                case 2:
                    System.out.print("O que deseja subtrair? ");
                    n = lerFloat();
                    memoria = memoria-n;
                    break;
                case 3:
                    System.out.print("O que deseja múltiplicar? ");
                    n = lerFloat();
                    memoria = memoria*n;
                    break;
                case 4:
                    System.out.print("O que deseja dividir? ");
                    n = lerFloat();
                    memoria = memoria/n;
                    break;
                case 5:
                    memoria = 0;
                    break;
                case 0:
                    return;
            }
        }
    }
}
