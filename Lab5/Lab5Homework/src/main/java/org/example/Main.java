package org.example;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.net.URISyntaxException;

public class Main {
    private void testCreateSave() throws IOException, InvalidCommand {
        Catalog catalog = new Catalog("MyDocuments");
        var book = new Document("article1","123"," RandomLocation1");
        var article = new Document("book1","234","F:\\IntelijProjects\\Programare Avansata\\PrezentareEngleza.docx");
        article.addTag("Title", "FCSB e Steaua");
        article.addTag("Author", "George Stancu");

        catalog.addDocument(book);
        catalog.addDocument(article);

        Save.save(catalog, "F:\\IntelijProjects\\Programare Avansata\\catalog.json");
    }

    private void testLoadView() throws IOException, InvalidCatalogException, TemplateException, URISyntaxException, InvalidCommand {
        Catalog catalog = Load.load("F:\\IntelijProjects\\Programare Avansata\\catalog.json");
        View.view(catalog.findById("234"));
        Listt.list(catalog);
        Report.report(catalog);
    }
    public static void main(String[] args) throws IOException, InvalidCatalogException, TemplateException, URISyntaxException, InvalidCommand {
        Main app = new Main();
        app.testCreateSave();
        app.testLoadView();

    }
}