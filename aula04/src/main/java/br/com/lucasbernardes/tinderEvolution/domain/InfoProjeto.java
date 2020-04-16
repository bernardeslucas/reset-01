package br.com.lucasbernardes.tinderEvolution.domain;

import java.time.LocalDate;

public class InfoProjeto {

    private int id;
    private String nome;
    private String descricao;
    private LocalDate data;

    public InfoProjeto(String nome, String descricao, LocalDate data) {
        this.nome = nome;
        this.descricao = descricao;
        this.data = data;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "nome: "+nome+
                ", descricao: "+descricao+
                ", data: "+data;
    }


}
