package org.example.list1;

import org.example.Executable;

import java.util.Scanner;

class Product19 {
    String name;
    double value;
    int quantity;
}

class Request {
    Product19 products[];
}

public class Exercise19 implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exercise19...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        System.out.println("O que desejas?");
        System.out.println("[1] Registrar produtos");
        System.out.println("[2] Realizar pedido");
        System.out.println("");
        int option = teclado.nextInt();

        switch (option) {
            case 1:

                break;
            case 2:
                break;
        }
    }
}