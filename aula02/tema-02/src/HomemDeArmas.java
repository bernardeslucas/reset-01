public abstract class HomemDeArmas extends Personagem {

    Arma armaEquipada;

    public Arma getArmaEquipada() {
        return armaEquipada;
    }

    public void setArmaEquipada(Arma armaEquipada) {
        this.armaEquipada = armaEquipada;
    }

    public HomemDeArmas(TiposDeClasses tipoClasse, String nome, int vida, int ataque, int defesa, Arma armaEquipada) {
        super(tipoClasse, nome, vida, ataque, defesa);
        this.armaEquipada = armaEquipada;
    }

    void imprimirEstado() {
        System.out.println(this.getTipoClasse() + " - " + this.getNome() + " | Vida: " + this.getVida());
    }


    void atacar(Personagem alvo, Arma arma) {
        int dano = calcularDano(alvo.getDefesa(), arma.getPoderAtaque());
        alvo.setVida(dano);
        registrar(alvo.getNome(), arma.getNome(), dano);
    }


}
