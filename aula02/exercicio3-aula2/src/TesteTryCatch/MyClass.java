package TesteTryCatch;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class MyClass {
    public static void main(String[ ] args) {


        List<Integer> listaAuxiliar = new ArrayList<>();

        listaAuxiliar.add(3);

        listaAuxiliar.add(6);
        Integer escolhaAtacante;


        Scanner teclado = new Scanner(System.in);
        try {
            int[] myNumbers = {1, 2, 3};
            System.out.println(myNumbers[10]);
        } catch (Exception e) {
            System.out.println("Something went wrong.");
        }
//        System.out.println("dgite");
//    escolhaAtacante = teclado.nextInt();
//        if(escolhaAtacante.equals(listaAuxiliar)){
//            System.out.println("true");
//    } else {
//            System.out.println("numero n encontrado");
//        }
//
//
//
//        boolean isValid = false;
//        do {
//            escolhaAlvo = teclado.nextInt() - 1;
//            isValid = listaAuxiliar.contains(escolhaAlvo);
//            if (isValid) {
//                break;
//            }
//            System.out.println("Número inválido, não há personagem alvo disponível nesse número.");
//        } while (!isValid);
    }












}