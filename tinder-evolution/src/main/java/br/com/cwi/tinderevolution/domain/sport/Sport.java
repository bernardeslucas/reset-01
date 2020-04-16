package br.com.cwi.tinderevolution.domain.sport;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

@JsonPropertyOrder({"id", "name"})
public class Sport {
    private int id;
    private String name;

    @JsonCreator
    public Sport(@JsonProperty("name") String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Esporte: [" +
                "id: '" + id +
                "'," + name + "']";
    }
}
