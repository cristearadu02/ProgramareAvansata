package org.example;

import freemarker.template.TemplateException;

import java.io.IOException;
import java.net.URISyntaxException;

abstract class Command {

    public static void save(Catalog catalog, String path) throws IOException, InvalidCommand {
        throw new InvalidCommand(" save");
    }

    public static Catalog load(String path) throws IOException, InvalidCatalogException, InvalidCommand {
        throw new InvalidCommand(" load");
    }

    public static void view(Document doc) throws InvalidCommand {
        throw new InvalidCommand(" view");
    }

    public static void list(Catalog catalog) throws InvalidCommand {
        throw new InvalidCommand(" list");
    }

    public static void report(Catalog catalog) throws IOException, TemplateException, URISyntaxException, InvalidCommand {
        throw new InvalidCommand(" report");
    }
}
