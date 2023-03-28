package org.example;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements Serializable {

    private String name;
    private List<Document> docs = new ArrayList<>();

    @JsonCreator
    public Catalog(@JsonProperty("documents") List<Document> documents) {
        this.docs = documents;
    }
    public Catalog(String name)
    {
        this.name = name;
    }
    public void addDocument(Document doc)
    {
        docs.add(doc);
    }
    public Document findById(String id) {
        return docs.stream()
                   .filter(d -> d.getId().equals(id))
                   .findFirst()
                   .orElse(null);

    }
    public String getName() {
        return name;
    }
    public List<Document> getDocs() {
        return docs;
    }
    @Override
    public String toString() {
        return "Catalog{" +
                "name='" + name + '\'' +
                ", docs=" + docs +
                '}';
    }

}
