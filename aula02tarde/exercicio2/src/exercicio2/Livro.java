package exercicio2;

public class Livro {


    private final Categoria categoria;
    private final Status status;
    private String titulo, autor;


    public Livro(String titulo, String autor, Categoria categoria, Status status) {
        this.categoria = categoria;
        this.status = status;
        this.titulo = titulo;
        this.autor = autor;
    }

    void imprimeEstado() {
        System.out.println(this.getCategoria().getDescricao() + " - " + this.getTitulo() + " (" + this.getAutor() + "): " + this.getStatus().getDescricao());

    }

    String getTitulo() {
        return titulo;
    }

    String getAutor() {
        return autor;
    }

    Categoria getCategoria() {
        return categoria;
    }

    Status getStatus() {
        return status;
    }
}
