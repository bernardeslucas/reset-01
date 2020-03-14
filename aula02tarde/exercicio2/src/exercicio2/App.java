package exercicio2;

public class App {
    public static void main(String[] args) {

        Livro livro1 = new Livro("Birdbox", "Josh Malerman", Categoria.SUSPENSE, Status.DISPONIVEL);
        Livro livro2 = new Livro("O Hobbit", "J. R. R. Tolkien", Categoria.FANTASIA, Status.EM_USO);
        Livro livro3 = new Livro("O Visconde que me Amava", "Julia Quinn", Categoria.ROMANCE, Status.EMPRESTADO);
        Livro livro4 = new Livro("Drácula", "Bram Stoker", Categoria.TERROR, Status.DISPONIVEL);

        livro1.imprimeEstado();
        livro2.imprimeEstado();
        livro3.imprimeEstado();
        livro4.imprimeEstado();





    }
}
