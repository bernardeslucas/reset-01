package TiposAtaque;

public class PoderDivino extends Habilidade {

    private final int custoFe;
    private final boolean area;

    public PoderDivino(String nome, int poderAtaque, int custoFe, boolean area) {
        super(nome, poderAtaque);
        this.custoFe = custoFe;
        this.area = area;
    }

    public int getCustoFe() {
        return custoFe;
    }

    public boolean isArea() {
        return area;
    }
}
