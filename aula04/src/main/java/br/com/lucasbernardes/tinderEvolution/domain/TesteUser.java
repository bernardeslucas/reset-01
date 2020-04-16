package br.com.lucasbernardes.tinderEvolution.domain;

import java.util.*;

public class TesteUser {
    public static void main(String[] args) {

        List<Usuario> userList = new ArrayList<>();

//        userList.add(new Usuario("Lucas", 1));
//        userList.add(new Usuario("Lucas", 2));
//        userList.add(new Usuario("Lucas", 7));
//        userList.add(new Usuario("Lucas", 5));


        Collections.sort(userList, Comparator.comparingInt(Usuario::getIdade));

//        for (Usuario u : userList){
//            System.out.println(u);
//        }

//        System.out.println(userList.get(0).getIdade());
        System.out.println("-----");
//            for (int i = 0; i < userList.size(); i++) {
////                System.out.println("teste");
//                if (userList.get(i).getIdade() != i+1) {
//                    System.out.println(i+1);
//
//                }
//            }
            for( int i =0; i<0;i++){
                System.out.println("teste");
            }


    }
}
