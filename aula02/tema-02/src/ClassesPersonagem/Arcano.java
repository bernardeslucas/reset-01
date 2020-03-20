package ClassesPersonagem;
import TiposAtaque.*;
import java.util.List;

public abstract class Arcano extends Personagem {


    private int mana;

    public Arcano(TiposDeClasses tipoClasse, String nome, int vida, int ataque, int defesa, int mana) {
        super(tipoClasse, nome, vida, ataque, defesa);
        this.mana = mana;
    }

    void imprimirEstado() {
        System.out.println("Nome: " + this.getNome() + " | Vida: " + this.getVida() + " | Mana: " + this.getMana());
    }

    public void atacarIndividual(Personagem alvo, Magia magia) {
        String status;
        int dano = calcularDano(alvo.getDefesa(), magia.getPoderAtaque());
        alvo.setVida(dano);
        this.setMana(magia.getCustoMana());
        if (alvo.getVida() == 0) {
            status = " e matou o personagem alvo.";
        } else {
            status = ".";
        }
        registrar(alvo.getNome(), magia.getNome(), dano, status);
    }

    public void atacarArea(List<Personagem> listaAtacados, Magia magia) {

        for (int i = 0; i < listaAtacados.size(); i++) {
            String status;
            int dano = calcularDano(listaAtacados.get(i).getDefesa(), magia.getPoderAtaque());
            listaAtacados.get(i).setVida(dano);
            if (listaAtacados.get(i).getVida() == 0) {
                status = " e matou o personagem alvo.";
            } else {
                status = ".";
            }
            registrar(listaAtacados.get(i).getNome(), magia.getNome(), dano, status);
        }
        this.setMana(magia.getCustoMana());
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int custoMana) {
        this.mana -= custoMana;
        //pra não negativar a mana
        if (this.mana < 0) {
            this.mana = 0;
        }
    }

}
