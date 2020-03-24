package consoleApp;

import java.util.Scanner;

public class App {



    public static void main(String[] args) {

        MusicMenu musicMenu = new MusicMenu();

        Scanner teclado = new Scanner(System.in);
        int option = 0;

        while(option!=7){
            System.out.println("Escolha uma opção: ");
            System.out.println("[1] Músicas");
            System.out.println("[7] Encerrar");
            option = teclado.nextInt();

            switch(option){
                case 1:
                    musicMenu.opcoes();
                    break;
                case 7:
                    System.out.println("Encerrando..");
                    break;
                default:
                    System.out.println("Opção inválida.");
                    break;

            }
        }
    }
}
