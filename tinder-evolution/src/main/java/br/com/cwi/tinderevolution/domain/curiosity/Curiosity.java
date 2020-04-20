package br.com.cwi.tinderevolution.domain.curiosity;

import br.com.cwi.tinderevolution.domain.user.User;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.List;

public class Curiosity {

    private int id;
    private String description;
    private CuriosityCategories category;
    private List<User> users = new ArrayList<>();

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

    @JsonIgnore
    public List<User> getUsers() {
        return users;
    }

    public void addUser(User user) {
        users.add(user);
    }

    public void removeUser(User user) {
        users.remove(user);
    }

    @Override
    public String toString() {
        return "Curiosidade ['"+
                "id: '"+id+
                "', Descrição: '"+description+
                "', Categoria: '"+category+"']";
    }
}
