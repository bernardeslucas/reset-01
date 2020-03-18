import java.util.List;

public abstract class Sacerdote extends Personagem {

    private int fe;

    public Sacerdote(TiposDeClasses tipoClasse, String nome, int vida, int ataque, int defesa, int fe) {
        super(tipoClasse, nome, vida, ataque, defesa);
        this.fe = fe;
    }

    public int getFe() {
        return fe;
    }

    public void setFe(int custoFe) {
        this.fe -= fe;
    }

    void imprimirEstado() {
        System.out.println("Nome: " + this.getNome() + " | Vida: " + this.getVida() + " | Fé: " + this.getFe());
    }

    void atacarIndividual(Personagem alvo, PoderDivino poderDivino) {
        int dano = calcularDano(alvo.getDefesa(), poderDivino.getPoderAtaque());
        alvo.setVida(dano);
        this.setFe(poderDivino.getCustoFe());
        registrar(alvo.getNome(), poderDivino.getNome(), dano);
    }

    void atacarArea(List<Personagem> listaAtacados, PoderDivino poderDivino) {
        int dano;
        for (int i = 0; i < listaAtacados.size(); i++) {
            dano = calcularDano(listaAtacados.get(i).getDefesa(), poderDivino.getPoderAtaque());
            listaAtacados.get(i).setVida(dano);
            registrar(listaAtacados.get(i).getNome(), poderDivino.getNome(), dano);
        }
        this.setFe(poderDivino.getCustoFe());
    }

}
