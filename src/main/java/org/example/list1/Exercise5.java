package org.example.list1;

import org.example.Executable;

import java.util.Scanner;

public class Exercise5 implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exercise5...");
        System.out.println("");

        for (int i = 1; i < 11; i++){
            for (int j = 1; j < 11; j++) {
                System.out.println(i + "x" + j + "=" + (i*j) );
            }
        }


    }
}