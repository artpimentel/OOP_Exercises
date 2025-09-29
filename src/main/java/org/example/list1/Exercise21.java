package org.example.list1;

import org.example.Executable;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;

class Person {
    String name;
}

class Book {
    String name;
}

class Loan {
    Person client;
    Book book;
    LocalDate loanDate;
    LocalDate returnDate;
}

public class Exercise21 implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exercise21...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        ArrayList<Person> clients = new ArrayList<>();
        ArrayList<Book> books = new ArrayList<>();
        ArrayList<Loan> loans = new ArrayList<>();

        int option;

        do {
            System.out.println("\n------- MENU -------");
            System.out.println("[1] Ver Empréstimos");
            System.out.println("[2] Registrar Cliente");
            System.out.println("[3] Registrar Livro");
            System.out.println("[4] Registrar Empréstimo");
            System.out.println("[5] Registrar Devolução");
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
                    if (loans.isEmpty()) {
                        System.out.println("\nNão há empréstimos ativos no momento.");
                        break;
                    }

                    System.out.println("\n--- LISTA DE EMPRÉSTIMOS ATIVOS ---");

                    for (int i = 0; i < loans.size(); i++) {
                        Loan loan = loans.get(i);

                        System.out.println("["+i+"] --------- "+loan.returnDate+" ---------");
                        System.out.println("  Cliente: " + loan.client.name);
                        System.out.println("  Livro: " + loan.book.name);
                        System.out.println("  Data Empréstimo: " + loan.loanDate);
                        System.out.println("  Data Devolução: " + loan.returnDate);
                    }
                    System.out.println("----------------------------------");
                    break;
                case 2:
                    Person newClient = new Person();
                    System.out.print("Nome do Novo Cliente: ");
                    newClient.name = teclado.nextLine();
                    clients.add(newClient);
                    System.out.println("Cliente " + newClient.name + " registrado com sucesso!");
                    break;
                case 3:
                    Book newBook = new Book();
                    System.out.print("Nome do Novo Livro: ");
                    newBook.name = teclado.nextLine();
                    books.add(newBook);
                    System.out.println("Livro " + newBook.name + " registrado com sucesso!");
                    break;
                case 4:
                    if (clients.isEmpty() || books.isEmpty()) {
                        System.out.println("É necessário registrar Clientes e Livros (Opções 2 e 3) antes de fazer um empréstimo.");
                        break;
                    }

                    int clientIndex = -1;
                    int bookIndex = -1;

                    System.out.println("\n--- CLIENTES DISPONÍVEIS ---");
                    for (int i = 0; i < clients.size(); i++) {
                        System.out.println("[" + i + "] " + clients.get(i).name);
                    }
                    System.out.print("Digite o NÚMERO (índice) do Cliente para o empréstimo: ");

                    if (teclado.hasNextInt()) {
                        clientIndex = teclado.nextInt();
                    } else {
                        System.out.println("Opção inválida para o cliente.");
                        teclado.nextLine();
                        break;
                    }

                    if (clientIndex < 0 || clientIndex >= clients.size()) {
                        System.out.println("Índice de cliente inválido.");
                        teclado.nextLine();
                        break;
                    }
                    teclado.nextLine();

                    System.out.println("\n--- LIVROS DISPONÍVEIS ---");
                    for (int i = 0; i < books.size(); i++) {
                        System.out.println("[" + i + "] " + books.get(i).name);
                    }
                    System.out.print("Digite o NÚMERO (índice) do Livro para o empréstimo: ");

                    if (teclado.hasNextInt()) {
                        bookIndex = teclado.nextInt();
                    } else {
                        System.out.println("Opção inválida para o livro.");
                        teclado.nextLine();
                        break;
                    }

                    if (bookIndex < 0 || bookIndex >= books.size()) {
                        System.out.println("Índice de livro inválido.");
                        teclado.nextLine();
                        break;
                    }
                    teclado.nextLine();

                    Person clientToLoan = clients.get(clientIndex);
                    Book bookToLoan = books.get(bookIndex);

                    Loan newLoan = new Loan();
                    newLoan.client = clientToLoan;
                    newLoan.book = bookToLoan;
                    newLoan.loanDate = LocalDate.now();
                    newLoan.returnDate = newLoan.loanDate.plusDays(7);

                    loans.add(newLoan);

                    System.out.println("\n--- Empréstimo de Livro Realizado ---");
                    System.out.println("Cliente: " + newLoan.client.name);
                    System.out.println("Livro: " + newLoan.book.name);
                    System.out.println("Devolução Prevista: " + newLoan.returnDate);
                    break;

                case 5:
                    if (loans.isEmpty()) {
                        System.out.println("Não há empréstimos ativos para registrar devolução.");
                        break;
                    }

                    System.out.print("Digite o NÚMERO (índice) do empréstimo a ser devolvido: ");
                    if (teclado.hasNextInt()) {
                        int index = teclado.nextInt();
                        teclado.nextLine();

                        if (index >= 0 && index < loans.size()) {
                            Loan returnedLoan = loans.remove(index);
                            System.out.println("Devolução registrada com sucesso!");
                            System.out.println("Livro: '" + returnedLoan.book.name + "' do cliente " + returnedLoan.client.name + " retornado.");
                        } else {
                            System.out.println("Índice inválido.");
                        }
                    } else {
                        System.out.println("Entrada inválida.");
                        teclado.nextLine();
                    }
                    break;
            }
        } while (option != 0);
    }
}