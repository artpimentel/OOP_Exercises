package org.example.exemples;

import org.example.Executable;

import java.util.Scanner;

class Pessoa {
    private String nome;
    private int idade;

    public Pessoa(String nome, int idade) {
        this.nome = nome;
        this.idade = idade;
    }

    public String getNome() {
        return nome;
    }
    public int getIdade() {
        return idade;
    }
}

public class Exemple4_Comp implements Executable {
    @Override
    public void run() {
        System.out.println("Executando o Exemple4...");
        System.out.println("");

        Scanner teclado = new Scanner(System.in);

        Pessoa[] pessoas = new Pessoa[10];

        for (int i = 0; i < pessoas.length; i++) {
            System.out.print("Digite o nome da pessoa " + (i + 1) + ": ");
            String nomeDigitado = teclado.nextLine();

            System.out.print("Digite a idade da pessoa " + (i + 1) + ": ");
            int idadeDigitada = teclado.nextInt();
            teclado.nextLine();

            pessoas[i] = new Pessoa(nomeDigitado, idadeDigitada);
        }

        Pessoa[] pessoasAlfabetico = pessoas;
        Pessoa[] pessoasCrescente = pessoas;

        for (int i = 0; i < (pessoasAlfabetico.length - 1); i++) {
            for (int j = (i + 1); j < pessoasAlfabetico.length; j++) {
                Pessoa temp;
                if (pessoasAlfabetico[j].getNome().charAt(0) < pessoasAlfabetico[i].getNome().charAt(0)) {
                    temp = pessoasAlfabetico[i];
                    pessoasAlfabetico[i] = pessoasAlfabetico[j];
                    pessoasAlfabetico[j] = temp;
                }
            }
        }

        System.out.println("Ordem Alfabética:");
        for (int i = 0; i < pessoasAlfabetico.length; i++) {
            System.out.println(pessoasAlfabetico[i].getNome() + " : " + pessoasAlfabetico[i].getIdade());
        }

        System.out.println("");

        for (int i = 0; i < (pessoasCrescente.length - 1); i++) {
            for (int j = (i + 1); j < pessoasCrescente.length; j++) {
                Pessoa temp;
                if (pessoasCrescente[j].getIdade() < pessoasCrescente[i].getIdade()) {
                    temp = pessoasCrescente[i];
                    pessoasCrescente[i] = pessoasCrescente[j];
                    pessoasCrescente[j] = temp;
                }
            }
        }

        System.out.println("Ordem Crescente:");
        for (int i = 0; i < pessoasCrescente.length; i++) {
            System.out.println(pessoasCrescente[i].getNome() + " : " + pessoasCrescente[i].getIdade());
        }

        System.out.println("");
    }
}
