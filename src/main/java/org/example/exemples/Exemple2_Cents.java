package org.example.exemples;

import org.example.Executable;

import java.util.Scanner;

public class Exemple2_Cents implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exemple2...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        int amount;
        System.out.println("Quantos centavos tens?");
        amount = teclado.nextInt();

        int money1, cents50, cents25, cents10, cents5, cents1, rest;

        money1 = amount / 100;
        rest = amount % 100;

        cents50 = rest / 50;
        rest = rest % 50;

        cents25 = rest / 25;
        rest = rest % 25;

        cents10 = rest / 10;
        rest = rest % 10;

        cents5 = rest / 5;
        rest = rest % 5;

        cents1 = rest / 1;

        System.out.println("Moedas de 1 real: " + money1);
        System.out.println("Moedas de 50 centavos: " + cents50);
        System.out.println("Moedas de 25 centavos: " + cents25);
        System.out.println("Moedas de 10 centavos: " + cents10);
        System.out.println("Moedas de 5 centavos: " + cents5);
        System.out.println("Moedas de 1 centavo: " + cents1);
    }

}
