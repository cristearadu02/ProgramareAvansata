package org.example;

import java.awt.*;
import java.io.File;
import java.io.IOException;

public class View extends Command{

    public static void view(Document doc){

                if(doc!=null)
                {
                    File file = new File(doc.getLocation());
                    try {
                        if (!file.exists())
                        {
                            throw new FileNotFound();
                        }
                        if (Desktop.isDesktopSupported())
                        {
                            Desktop desktop = Desktop.getDesktop();
                            if (desktop.isSupported(Desktop.Action.OPEN))
                            {
                                desktop.open(file);
                            }
                            else
                            {
                                System.out.println("File not supported.");
                            }
                        }
                    }
                    catch (FileNotFound e)
                    {

                    }
                    catch (IOException e)
                    {
                        System.out.println("Failed to open the file: " + e.getMessage());
                    }
                }
        }
    }

