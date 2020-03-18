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
    }

    public int getAtaque() {
        return ataque;
    }

    public int getDefesa() {
        return defesa;
    }

    void registrar(String nomeAlvo, String habilidade, int dano) {

        //   DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        // LocalDateTime now = LocalDateTime.now();
        //System.out.println(dtf.format(now)); //2016/11/16 12:08:43
        System.out.println(this.nome + " atacou " + nomeAlvo + " com " + habilidade + " causando " + dano + " de dano");
    }


}
