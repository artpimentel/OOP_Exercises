package org.example.list1;

import org.example.Executable;

import java.util.Scanner;

public class Exercise1 implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exercise1...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        double a, b, c, d, x1, x2;

        do {
            System.out.print("Informe o valor de a (Não 0): ");
            a = teclado.nextInt();
        } while (a == 0);
        System.out.print("Informe o valor de b: ");
        b = teclado.nextInt();
        System.out.print("Informe o valor de c: ");
        c = teclado.nextInt();
        System.out.println("");

        d = b * b - 4 * a * c;

        if (d < 0) {
            System.out.println("Δ = 0. A equação NÃO tem raízes!");
        } else {
            double dsqr = Math.sqrt(d);

            x1 = ((-b) + dsqr) / (2 * a);
            x2 = ((-b) - dsqr) / (2 * a);

            System.out.println("x1 = " + x1);
            System.out.println("x2 = " + x2);
        }
    }
}
