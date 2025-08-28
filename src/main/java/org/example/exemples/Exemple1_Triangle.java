package org.example.exemples;

import org.example.Executable;

import java.util.Scanner;

public class Exemple1_Triangle implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exemple1...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        int h, b;
        float area;

        System.out.print("Informe a altura do triângulo: ");
        h = teclado.nextInt();
        System.out.print("Informe a base do triângulo: ");
        b = teclado.nextInt();
        area = 0.5f * h * b;
        System.out.println("Área do triângulo: " + area);
    }
}