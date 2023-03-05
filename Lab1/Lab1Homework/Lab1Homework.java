package Lab1Homework;
import java.util.Scanner;
public class Lab1Homework {
    public static void main(String[] args) throws Exception
    {
        long initTime = System.nanoTime();

        /*
        // --------> Citire si validare int ca input <-----------
        System.out.print("Enter an integer value: ");

        Scanner keyboard = new Scanner(System.in);

        while (!keyboard.hasNextInt())
        {
            System.out.print("Please enter an integer value: ");
            keyboard.next();
        }
        int n = keyboard.nextInt();

        System.out.println("Number: " + n);
        // ----------------------------------------------------
        */

        int n = 0;
        try {
             n = Integer.valueOf(args[0]);
        }
        catch(Exception e)
        {
            System.out.println(e);
        }
        finally {
            System.out.println("The 'try catch' is finished.");
        }

            // -----------> Creeare latin square <-----------------
            int[][] LatinSquare = new int[n][n];

            for (int i = 0; i < LatinSquare.length; i++) {
                int aux = n - i + 1;
                for (int j = 0; j < LatinSquare.length; j++) {
                    LatinSquare[i][i] = 1; // diagonala principala
                    if (i < j) // deasupra diag principala
                    {
                        LatinSquare[i][j] = LatinSquare[i][j - 1] + 1;
                    } else if (i != j) // sub diag principala
                    {
                        LatinSquare[i][j] = aux;
                        aux++;
                    }
                }
            }
            // ----------------------------------------------------
        if(n <= 30_000 && n > 1)
        {
            // -------------> PRINT LATIN SQUARE <-----------------
            for (int i = 0; i < LatinSquare.length; i++) {
                for (int j = 0; j < LatinSquare.length; j++) {
                    System.out.print(LatinSquare[i][j]);
                    System.out.print(" ");
                }
                System.out.println(" ");
            }
            // -----------------------------------------------------

            // --------> CREARE STRING DIN INT <--------------------
            for (int i = 0; i < LatinSquare.length; i++) {
                String line = new String("Line number ");
                line = line + String.valueOf(i + 1);
                line = line + " : ";

                String column = new String("Column number ");
                column = column + String.valueOf(i + 1);
                column = column + " : ";
                for (int j = 0; j < LatinSquare.length; j++) {
                    line = line + String.valueOf(LatinSquare[i][j]);
                    column = column + String.valueOf(LatinSquare[j][i]);
                }
                System.out.println(line);
                System.out.println(column);
            }
            // ----------------------------------------------------
        }
        else
        {
            long finalTime = System.nanoTime();
            System.out.println("time: " + String.valueOf(finalTime - initTime));
        }
        // keyboard.close();
    }
}
