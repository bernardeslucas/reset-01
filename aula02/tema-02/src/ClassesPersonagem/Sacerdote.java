package ClassesPersonagem;
import TiposAtaque.*;
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
        //pra não negativar a fe
        if (this.fe < 0) {
            this.fe = 0;
        }
    }

    void imprimirEstado() {
        System.out.println("Nome: " + this.getNome() + " | Vida: " + this.getVida() + " | Fé: " + this.getFe());
    }

    public void atacarIndividual(Personagem alvo, PoderDivino poderDivino) {
        int dano = calcularDano(alvo.getDefesa(), poderDivino.getPoderAtaque());
        String status;
        alvo.setVida(dano);
        this.setFe(poderDivino.getCustoFe());
        if (alvo.getVida() == 0) {
            status = " e matou o personagem alvo.";
        } else {
            status = ".";
        }
        registrar(alvo.getNome(), poderDivino.getNome(), dano, status);
    }

    public void atacarArea(List<Personagem> listaAtacados, PoderDivino poderDivino) {
        int dano;
        String status;
        for (int i = 0; i < listaAtacados.size(); i++) {
            dano = calcularDano(listaAtacados.get(i).getDefesa(), poderDivino.getPoderAtaque());
            listaAtacados.get(i).setVida(dano);

            if (listaAtacados.get(i).getVida() == 0) {
                status = " e matou o personagem alvo.";
            } else {
                status = ".";
            }
            registrar(listaAtacados.get(i).getNome(), poderDivino.getNome(), dano, status);
        }

        this.setFe(poderDivino.getCustoFe());
    }

}
