package org.example;

public class Listt extends Command{
    public static void list(Catalog catalog)
    {
        if(catalog.getDocs() != null)
        {
            for(Document iterator : catalog.getDocs())
            {
                System.out.print(iterator);
            }
        }
        else
        {
            System.out.println(catalog.getName() + " doesn't have any documents.");
        }
    }
}
