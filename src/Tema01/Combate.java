package Tema01;

import Tema01.Classes.*;
import Tema01.TiposAtaque.*;

public class Combate {

    public static void main(String[] args) {
        //Declaração personagens
        Barbaro barbaro1 = new Barbaro("Teodorico", 2000, 30, 30);
        Barbaro barbaro2 = new Barbaro("Odoacro", 2000, 30, 30);
        Clerigo clerigo1 = new Clerigo("James Anderson", 2000, 30, 30, 30);
        Clerigo clerigo2 = new Clerigo("Frei Caneca", 2000, 30, 30, 30);
        Druida druida1 = new Druida("Taliesin", 200, 30, 30, 30);
        Druida druida2 = new Druida("Allanon", 200, 30, 30, 30);
        Feiticeiro feiticeiro1 = new Feiticeiro("Ravena", 2000, 20, 30, 30);
        Feiticeiro feiticeiro2 = new Feiticeiro("Circe", 2000, 20, 30, 30);
        Guerreiro guerreiro1 = new Guerreiro("Rei Arthur", 2000, 30, 30);
        Guerreiro guerreiro2 = new Guerreiro("Paolo Guerrero", 2000, 30, 30);
        Mago mago1 = new Mago("Maga patológica", 2000, 30, 30, 30);
        Mago mago2 = new Mago("Jafar", 2000, 30, 30, 30);

        //Declaração dos tipos de Ataque (armas, magias e poderes divinos)
        Armas armaMachado = new Armas("Machado Leviatã", 38);
        Armas armaEspadaLonga = new Armas("Espada longa", 38);
        Magias magiaFogo = new Magias("Bola de fogo", 50, 10);
        Magias magiaAgua = new Magias("Turbilhão de água", 48, 10);
        PoderDivino poderBanimento = new PoderDivino("Banimento divino", 30, 10);
        PoderDivino poderOnipotencia = new PoderDivino("Onipotência Ilusória", 40, 10);


        barbaro1.ataque(barbaro2, armaMachado);
        barbaro1.ataque(clerigo1, armaMachado);
        barbaro1.ataque(druida1, armaMachado);
        barbaro1.ataque(feiticeiro1, armaMachado);
        barbaro1.ataque(guerreiro1, armaMachado);
        barbaro1.ataque(mago1, armaMachado);


    }
}
