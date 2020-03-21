package TiposAtaque;

public class Magia extends Habilidade{

    private final int custoMana;
    private final boolean area;

    public Magia(String nome, int poderAtaque, int custoMana, boolean area) {
        super(nome, poderAtaque);
        this.custoMana = custoMana;
        this.area = area;
    }

    public int getCustoMana() {
        return custoMana;
    }

    public boolean isArea() {
        return area;
    }


}
