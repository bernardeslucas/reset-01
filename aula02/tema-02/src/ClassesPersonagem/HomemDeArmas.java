package ClassesPersonagem;
import Combate.Registros;
import TiposAtaque.*;
public abstract class HomemDeArmas extends Personagem {

    Arma armaEquipada;

    public HomemDeArmas(TiposDeClasses tipoClasse, String nome, int vida, int ataque, int defesa, Arma armaEquipada) {
        super(tipoClasse, nome, vida, ataque, defesa);
        this.armaEquipada = armaEquipada;
    }

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }




    public void atacar(Personagem alvo, Arma arma) {
        String status;
        int dano = calcularDano(alvo.getDefesa(), arma.getPoderAtaque());
        alvo.setVida(dano);
        if (alvo.getVida() == 0) {
            status = " e matou o personagem alvo.";
        } else {
            status = ".";
        }
        registrar(alvo.getNome(), arma.getNome(), dano, status);
        Registros.numeroAtaques();
    }


}
