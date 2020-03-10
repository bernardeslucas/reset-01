package Tema01.Classes;

import Tema01.TiposAtaque.*;
import Tema01.Classes.*;



public class Barbaro {
    String nome;
    int vida, ataque, defesa, poderFinal, dano;


    public Barbaro(String nome, int vida, int ataque, int defesa) {
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    public boolean status(){
        boolean morreu = this.vida<=0;
        return morreu;
    }


    public void ataque(Barbaro barbaro, Armas arma) {
        poderFinal = (arma.ataquePoder * this.ataque);
        dano = poderFinal - barbaro.defesa;
        barbaro.vida -= dano;

        System.out.println(this.nome + " atacou " + barbaro.nome + " com " + arma.nome + " causando " + dano + " de dano.");

    }

    public void ataque(Clerigo clerigo, Armas arma) {
        poderFinal = (arma.ataquePoder * this.ataque);
        dano = poderFinal - clerigo.defesa;
        clerigo.vida -= dano;
        System.out.println(this.nome + " atacou " + clerigo.nome + " com " + arma.nome + " causando " + dano + " de dano.");

    }

    public void ataque(Druida druida, Armas arma) {
        poderFinal = (arma.ataquePoder * this.ataque);
        dano = poderFinal - druida.defesa;
        druida.vida -= dano;
        System.out.println(this.nome + " atacou " + druida.nome + " com " + arma.nome + " causando " + dano + " de dano.");
    }

    public void ataque(Feiticeiro feiticeiro, Armas arma) {
        poderFinal = (arma.ataquePoder * this.ataque);
        dano = poderFinal - feiticeiro.defesa;
        feiticeiro.vida -= dano;
        System.out.println(this.nome + " atacou " + feiticeiro.nome + " com " + arma.nome + " causando " + dano + " de dano.");
    }

    public void ataque(Guerreiro guerreiro, Armas arma) {
        poderFinal = (arma.ataquePoder * this.ataque);
        dano = poderFinal - guerreiro.defesa;
        guerreiro.vida -= dano;
        System.out.println(this.nome + " atacou " + guerreiro.nome + " com " + arma.nome + " causando " + dano + " de dano.");

    }

    public void ataque(Mago mago, Armas arma) {
        poderFinal = (arma.ataquePoder * this.ataque);
        dano = poderFinal - mago.defesa;
        mago.vida -= dano;
        System.out.println(this.nome + " atacou " + mago.nome + " com " + arma.nome + " causando " + dano + " de dano.");
    }


}
