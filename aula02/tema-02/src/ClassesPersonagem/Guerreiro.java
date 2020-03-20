package ClassesPersonagem;

import TiposAtaque.Arma;

public class Guerreiro extends HomemDeArmas {

    public Guerreiro(TiposDeClasses tipoClasse, String nome, int vida, int ataque, int defesa, Arma armaEquipada) {
        super(tipoClasse, nome, vida, ataque, defesa, armaEquipada);
    }
}
