package Tema01;

import Tema01.Classes.*;
import Tema01.TiposAtaque.*;

public class Combate {

    public static void main(String[] args) {
        //Declaração personagens
        Barbaro barbaro1 = new Barbaro("Teodorico", 500, 30, 30);
        Clerigo clerigo1 = new Clerigo("Frei Caneca", 400, 30, 30, 30);
        Druida druida1 = new Druida("Taliesin", 400, 30, 30, 30);
        Feiticeiro feiticeiro1 = new Feiticeiro("Ravena", 350, 50, 30, 30);
        Feiticeiro feiticeiro2 = new Feiticeiro("Circe", 350, 50, 30, 30);
        Guerreiro guerreiro1 = new Guerreiro("Paolo Guerrero", 500, 50, 30);
        Mago mago1 = new Mago("Maga patológica", 350, 30, 30, 30);

        //Declaração dos tipos de Ataque (armas, magias e poderes divinos)
        Armas armaMachado = new Armas("Machado Leviatã", 4);
        Armas armaEspadaLonga = new Armas("Espada longa", 3);
        Magias magiaFogo = new Magias("Bola de fogo", 8, 10);
        Magias magiaAgua = new Magias("Turbilhão de água", 9, 20);
        PoderDivino poderBanimento = new PoderDivino("Banimento divino", 7, 10);
        PoderDivino poderOnipotencia = new PoderDivino("Onipotência Ilusória", 6, 10);

        //Declaração ataques
        barbaro1.ataque(mago1, armaEspadaLonga);
        barbaro1.ataque(mago1, armaMachado);
        clerigo1.ataque(feiticeiro1, poderBanimento);
        clerigo1.ataque(barbaro1, poderOnipotencia);
        druida1.ataque(barbaro1, poderBanimento);
        druida1.ataque(clerigo1, poderOnipotencia);
        feiticeiro1.ataque(feiticeiro2, magiaFogo);
        feiticeiro1.ataque(barbaro1, magiaAgua);
        feiticeiro2.ataque(feiticeiro1, magiaAgua);
        feiticeiro2.ataque(guerreiro1, magiaFogo);
        guerreiro1.ataque(clerigo1, armaMachado);
        guerreiro1.ataque(druida1, armaEspadaLonga);
        mago1.ataque(druida1, magiaAgua);
        mago1.ataque(guerreiro1, magiaAgua);




        //Resultado final stats personagens
        System.out.println("");
        System.out.println("Resultado Final");
        System.out.println("Bárbaro | Nome: " + barbaro1.nome + " | Vida: " + barbaro1.vida);
        System.out.println("Clérigo | Nome: " + clerigo1.nome + " | Vida: " + clerigo1.vida + " | Fé: " + clerigo1.fe);
        System.out.println("Guerreiro | Nome: " + guerreiro1.nome + " | Vida: " + guerreiro1.vida);
        System.out.println("Druida | Nome: " + druida1.nome + " | Vida: " + druida1.vida + " | Fé: " + druida1.fe);
        System.out.println("Feiticeiro | Nome: " + feiticeiro1.nome + " | Vida: " + feiticeiro1.vida + " | Mana: " + feiticeiro1.mana);
        System.out.println("Feiticeiro | Nome: " + feiticeiro2.nome + " | Vida: " + feiticeiro2.vida + " | Mana: " + feiticeiro2.mana);
        System.out.println("Mago | Nome: " + mago1.nome + " | Vida: " + mago1.vida + " | Mana: " + mago1.mana);


    }
}
