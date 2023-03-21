package org.example;

import java.io.IOException;

public class Main {

    private void testCreateSave() throws IOException {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1","123"," RandomLocation1");
        var article = new Document("book1","234"," RandomLocation2");

        catalog.addDocument(book);
        catalog.addDocument(article);

        CatalogUtil.save(catalog, "F:\\IntelijProjects\\Programare Avansata\\catalog.json");
    }

    private void testLoadView() throws IOException {
        Catalog catalog = CatalogUtil.load("F:\\IntelijProjects\\Programare Avansata\\catalog.json");
        CatalogUtil.view(catalog.findById("234"));
    }
    public static void main(String[] args) throws IOException {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

    }
}