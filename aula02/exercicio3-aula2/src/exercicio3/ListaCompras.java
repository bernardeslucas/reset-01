package exercicio3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//[Segmento] - Nome (quantidade) - Valor Unitário | Valor Total
//Ex: [Higiene] - Sabonete (2) - 2,25 | 4,50


public class ListaCompras {
    public static void main(String[] args) {

        Scanner teclado = new Scanner(System.in);
        Item item1 = new Item("Escova de dente", 9.99, Segmento.HIGIENE);
        item1.setQuantidade(4);
        Item item2 = new Item("Polenta", 19.99, Segmento.ALIMENTACAO);
        item2.setQuantidade(3);
        Item item3 = new Item("Agua Sanitária", 1.99, Segmento.LIMPEZA);
        item3.setQuantidade(2);
        Item item4 = new Item("Farinha", 4.99, Segmento.ALIMENTACAO);
        item4.setQuantidade(8);



        List<Item> listaCompras = new ArrayList<>();
        listaCompras.add(item1);
        listaCompras.add(item2);
        listaCompras.add(item3);
        listaCompras.add(item4);

        imprimeLista(listaCompras);

    }

    public static void imprimeLista(List<Item> listaCompras) {
        for (Item item : listaCompras) {
            System.out.println(listaCompras.listIterator());
            System.out.println(item.getSegmento().getDescricao() + " - " + item.getNome() +
                    " (" + item.getQuantidade() + ") - " + item.getValor() + " | " + item.getValor() * item.getQuantidade());
        }


    }


}
