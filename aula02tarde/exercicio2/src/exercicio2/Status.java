package exercicio2;

public enum Status {
    DISPONIVEL("Disponível"),
    EM_USO("Em uso"),
    EMPRESTADO("Emprestado");


    private final String descricao;

    Status(String descricao) {
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }
}
