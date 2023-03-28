package org.example;

import freemarker.template.Configuration;
import freemarker.template.Template;
import freemarker.template.TemplateException;

import java.awt.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.net.URISyntaxException;
import java.util.HashMap;
import java.util.Map;

public class Report extends Command{
    public static void report(Catalog catalog) throws IOException, TemplateException, URISyntaxException {

        Configuration cfg = new Configuration(Configuration.VERSION_2_3_30);
        cfg.setClassForTemplateLoading(Main.class, "/templates");
        cfg.setDefaultEncoding("UTF-8");

        try {
            Template template = cfg.getTemplate("catalog.ftl");

            // Prepare the data model for the template
            Map<String, Object> data = new HashMap<>();
            data.put("name", catalog.getName());
            data.put("docs", catalog.getDocs());

            // Generate the HTML output
            File file = new File("F:\\IntelijProjects\\Programare Avansata\\ProgramareAvansata\\Document" + Math.random() + ".html");
            Writer fileWriter = new FileWriter(file);

           /*
            StringWriter out = new StringWriter();
            template.process(data, out);
            String html = out.toString();
            System.out.println(html);
           */

            template.process(data,fileWriter);
                try {
                    if (!file.exists()) {
                        throw new FileNotFound();
                    }
                    if (Desktop.isDesktopSupported()) {
                        Desktop desktop = Desktop.getDesktop();
                        if (desktop.isSupported(Desktop.Action.OPEN)) {
                            desktop.open(file);
                        } else {
                            System.out.println("File not supported.");
                        }
                    }
                }catch (FileNotFound e)
                {

                }
                fileWriter.close();

        } catch (IOException | TemplateException e) {
            e.printStackTrace();
        }


    }
}
