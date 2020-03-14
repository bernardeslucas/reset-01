package aula02;

import java.util.Scanner;

public class AppTeclado {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        System.out.print("Nome heroi");
        String input = teclado.nextLine();
        System.out.println("vida heroi");
        double vida = teclado.nextDouble();

        System.out.println("vida heroi");
        double valor = teclado.nextDouble();

        System.out.println(input);
        System.out.println(valor);


    }
}
