package org.example.exemples;

import org.example.Executable;

import java.util.Scanner;
import java.lang.Math;

public class Exemple3_Plan implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exemple3...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        double a1, a2, b1, b2, c1, c2;

        System.out.println("Digite as coordenadas do Ponto 1 (x1 y1):");
        a1 = teclado.nextDouble();
        a2 = teclado.nextDouble();

        System.out.println("Digite as coordenadas do Ponto 2 (x2 y2):");
        b1 = teclado.nextDouble();
        b2 = teclado.nextDouble();

        System.out.println("Digite as coordenadas do Ponto 3 (x3 y3):");
        c1 = teclado.nextDouble();
        c2 = teclado.nextDouble();

        double determinante = a1 * (b2 - c2) + b1 * (c2 - a2) + c1 * (a2 - b2);

        if (determinante != 0) {
            System.out.print("\nOs seus pontos FORMAM um ");

            double ladoA = Math.sqrt(Math.pow(c1 - b1, 2) + Math.pow(c2 - b2, 2));
            double ladoB = Math.sqrt(Math.pow(c1 - a1, 2) + Math.pow(c2 - a2, 2));
            double ladoC = Math.sqrt(Math.pow(b1 - a1, 2) + Math.pow(b2 - a2, 2));

            if (ladoA == ladoB && ladoB == ladoC) {
                System.out.println("Triângulo Equilátero.");
            } else if (ladoA == ladoB || ladoB == ladoC || ladoA == ladoC) {
                System.out.println("Triângulo Isósceles.");
            } else {
                System.out.println("Triângulo Escaleno.");
            }

            System.out.print("\nDe lados: A = "+ladoA+" B = "+ladoB+" C = "+ladoC);

        } else {
            System.out.println("\nOs seus pontos NÃO formam um triângulo.");
        }

        System.out.println("");
    }
}