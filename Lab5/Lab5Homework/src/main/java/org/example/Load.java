package org.example;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class Load extends Command {

    public static Catalog load(String path) throws IOException, InvalidCatalogException
    {
        ObjectMapper objectMapper = new ObjectMapper();
        Catalog catalog = objectMapper.readValue(new File(path), Catalog.class);
        if(catalog == null)
            throw new InvalidCatalogException(path);
        return catalog;
    }
}
