package ClassesPersonagem;

import Combate.Registros;

public abstract class Personagem {

    private final String nome;
    private final int ataque;
    private final int defesa;
    private int vida;
    private TiposDeClasses tipoClasse;


    public Personagem(TiposDeClasses tipoClasse, String nome, int vida, final int ataque, final int defesa) {
        this.tipoClasse = tipoClasse;
        this.nome = nome;
        this.vida = vida;
        this.ataque = ataque;
        this.defesa = defesa;
    }

    int calcularDano(int defesa, int poder) {
        return ataque * poder - defesa;
    }

    public TiposDeClasses getTipoClasse() {
        return tipoClasse;
    }

    public String getNome() {
        return nome;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int dano) {
        this.vida -= dano;
        //pra não negativar a vida
        if (this.vida < 0) {
            this.vida = 0;
        }

    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    void registrar(String nomeAlvo, String habilidade, int dano, String status) {

        Registros.listaRegistros.add(new Registros(nome, nomeAlvo, habilidade, dano, status));


    }
}
