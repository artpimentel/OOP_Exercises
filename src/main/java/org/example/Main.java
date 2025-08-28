package org.example;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello User!");

        Scanner teclado = new Scanner(System.in);
        MenuExecutor menuExecutor = new MenuExecutor();

        while (true) {
            System.out.println("\n===== MENU PRINCIPAL =====");
            System.out.println("O que deseja?");
            System.out.println("1 - Ver Exemplos de Sala");
            System.out.println("2 - Ver Exercícios da Lista 1");
            System.out.println("3 - Ver Exercícios da Lista 2");
            System.out.println("0 - Sair");
            System.out.println("==========================");
            System.out.print("Sua opção: ");

            int option = teclado.nextInt();

            switch (option) {
                case 1:
                    menuExecutor.runMenuForPackage(teclado, "org.example.exemples");
                    break;
                case 2:
                    menuExecutor.runMenuForPackage(teclado, "org.example.list1");
                    break;
                case 3:
                    menuExecutor.runMenuForPackage(teclado, "org.example.list2");
                    break;
                case 0:
                    System.out.println("Até logo!");
                    return;
                default:
                    System.out.println("Opção inválida, tente novamente.");
                    break;
            }
        }
    }
}