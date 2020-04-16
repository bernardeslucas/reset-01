package br.com.cwi.tinderevolution.domain.curiosity;

public class Curiosity {

    private int id;
    private String description;
    private CuriosityCategories category;

    public Curiosity(String description, CuriosityCategories category) {
        this.description = description;
        this.category = category;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public CuriosityCategories getCategory() {
        return category;
    }

    public void setCategory(CuriosityCategories category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Curiosidade ['"+
                "id: '"+id+
                "', Descrição: '"+description+
                "', Categoria: '"+category+"']";
    }
}
