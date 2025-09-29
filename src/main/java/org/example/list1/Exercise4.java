package org.example.list1;

import org.example.Executable;

import java.util.Scanner;

class Product {
    String name;
    double value;
    int quantity;
}

public class Exercise4 implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exercise4...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        String name;
        double value;
        int quantity;
        double taxaDesconto = 0.0;

        System.out.print("Qual produto quer comprar?");
        name = teclado.next();;
        System.out.print("Qual o valor desse produto?");
        value = teclado.nextDouble();
        System.out.print("Quantos quer comprar?");
        quantity = teclado.nextInt();

        Product product = new Product();
        product.name = name;
        product.value = value;
        product.quantity = quantity;

        if (quantity > 50) {
            taxaDesconto = 0.25;
        } else if (quantity > 20) {
            taxaDesconto = 0.20;
        } else if (quantity > 10) {
            taxaDesconto = 0.10;
        } else {
            taxaDesconto = 0.0;
        }

        double total = value * quantity;
        double subtotal = total * (1 - taxaDesconto);

        System.out.println("------------------------------------");
        System.out.printf("Produto: %s\n", product.name);
        System.out.printf("Quantidade: %d\n", product.quantity);
        System.out.printf("Valor Total: R$ %.2f\n", total);
        System.out.printf("Desconto Aplicado: %.0f%%\n", taxaDesconto * 100);
        System.out.printf("TOTAL A PAGAR: R$ %.2f\n", subtotal);
        System.out.println("------------------------------------");
    }
}
