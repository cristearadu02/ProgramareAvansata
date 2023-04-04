package Homework;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.File;
import java.io.IOException;

public class LoadDrawingPanel {
    public static DrawingPanel load(String path)
    {
        ObjectMapper objectMapper = new ObjectMapper();
        DrawingPanel drawingPanel = null;
        try {
            drawingPanel = objectMapper.readValue(new File(path), DrawingPanel.class);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        return drawingPanel;
    }
}
