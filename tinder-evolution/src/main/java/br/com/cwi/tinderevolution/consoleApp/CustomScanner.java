package br.com.cwi.tinderevolution.consoleApp;

import java.util.Scanner;

public class CustomScanner {

    protected int nextInt(String label){
        Scanner teclado = new Scanner(System.in);
        System.out.print(label);
        int valor = teclado.nextInt(); teclado.nextLine();
        return valor;
    }

    protected double nextDouble(String label){
        Scanner teclado = new Scanner(System.in);
        System.out.print(label);
        double valor = teclado.nextDouble(); teclado.nextLine();
        return valor;
    }

    protected String nextLine(String label){
        Scanner teclado = new Scanner(System.in);
        System.out.print(label);
        String valor = teclado.nextLine();
        return valor;
    }




}
