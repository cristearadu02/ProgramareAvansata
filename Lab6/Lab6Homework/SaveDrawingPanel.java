package Homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class SaveDrawingPanel {
    public static void save(DrawingPanel drawingPanel, String path) {

        ObjectMapper objectMapper = new ObjectMapper();
        try {
            objectMapper.writeValue(new File(path), drawingPanel);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
