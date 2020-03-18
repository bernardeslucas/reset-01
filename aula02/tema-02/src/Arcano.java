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

    void atacarIndividual(Personagem alvo, Magia magia) {
        int dano = calcularDano(alvo.getDefesa(), magia.getPoderAtaque());
        alvo.setVida(dano);
        this.setMana(magia.getCustoMana());
        registrar(alvo.getNome(), magia.getNome(), dano);
    }
    void atacarArea(List<Personagem> listaAtacados, Magia magia) {
        int dano;
        for (int i = 0; i < listaAtacados.size(); i++) {
            dano = calcularDano(listaAtacados.get(i).getDefesa(), magia.getPoderAtaque());
            listaAtacados.get(i).setVida(dano);
            registrar(listaAtacados.get(i).getNome(), magia.getNome(), dano);
        }
        this.setMana(magia.getCustoMana());
    }

    public int getMana() {
        return mana;
    }

    public void setMana(int custoMana) {
        this.mana -= custoMana;
    }

}
