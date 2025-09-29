package org.example.list1;

import org.example.Executable;

import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    String name;
    String ddd;
    String number;
}

class Agenda {
    ArrayList<Contact> contacts = new ArrayList<>();
}

public class Exercise20 implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exercise20...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        Agenda agenda = new Agenda();
        int option;

        do {
            System.out.println("\n------- MENU -------");
            System.out.println("[1] Ver Contatos");
            System.out.println("[2] Registrar Contato");
            System.out.println("[3] Excluir Contato");
            System.out.println("[0] Finalizar Programa");
            System.out.println("----------------------");
            System.out.print("O que desejas? ");

            if (teclado.hasNextInt()) {
                option = teclado.nextInt();
            } else {
                System.out.println("Opção inválida. Por favor, digite um número.");
                teclado.next();
                option = -1;
                continue;
            }
            teclado.nextLine();

            switch (option) {
                case 1:
                    if (agenda.contacts.isEmpty()) {
                        System.out.println("\nA agenda está vazia.");
                    } else {
                        System.out.println("\n--- LISTA DE CONTATOS ---");
                        for (int i = 0; i < agenda.contacts.size(); i++) {
                            Contact c = agenda.contacts.get(i);
                            System.out.println("[" + i + "] " + c.name + " (" + c.ddd + ")" + c.number);
                        }
                    }
                    break;

                case 2:
                    Contact novoContato = new Contact();
                    System.out.print("Nome: ");
                    novoContato.name = teclado.nextLine();
                    System.out.print("DDD: ");
                    novoContato.ddd = teclado.nextLine();
                    System.out.print("Número: ");
                    novoContato.number = teclado.nextLine();

                    agenda.contacts.add(novoContato);
                    System.out.println("Contato de " + novoContato.name + " registrado com sucesso!");
                    break;

                case 3:
                    if (agenda.contacts.isEmpty()) {
                        System.out.println("Não há contatos para excluir.");
                        break;
                    }
                    System.out.print("Digite o NÚMERO (índice) do contato a ser excluído (veja a lista na Opção 1): ");
                    if (teclado.hasNextInt()) {
                        int index = teclado.nextInt();
                        if (index >= 0 && index < agenda.contacts.size()) {
                            Contact excluido = agenda.contacts.remove(index);
                            System.out.println("Contato de " + excluido.name + " excluído.");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    } else {
                        System.out.println("Entrada inválida.");
                    }
                    teclado.nextLine();
                    break;

                case 0:
                    System.out.println("Programa finalizado. Até mais!");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }
        } while (option != 0);
    }
}