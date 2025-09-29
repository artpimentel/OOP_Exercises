package org.example.list1;

import org.example.Executable;

import java.util.Scanner;

public class Exercise8 implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exercise8...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        int n1 = 0, n2 = 1, temp;

        System.out.print("Quantos números de Fibonacci quer ver? ");
        int n = teclado.nextInt();

        System.out.print(n1 + " " + n2 + " ");
        for (int i = 0; i < n; i++) {
            temp = n1 + n2;
            System.out.print(temp + " ");
            n1 = n2;
            n2 = temp;
        }
    }
}
