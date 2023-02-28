package Lab1Bonus;

import java.util.Scanner;

public class Lab1Bonus {
    public static int Read()
    {
        // --------> Citire si validare int ca input <-----------

        Scanner keyboard = new Scanner(System.in);

        while (!keyboard.hasNextInt())
        {
            System.out.print("Please enter an integer value: ");
            keyboard.next();
        }
        int n = keyboard.nextInt();

        return n;

        // ----------------------------------------------------
    }
    public static void main(String[] args)
    {
        System.out.print("Enter an integer value, number of vertices of cycle graph: ");
        int n = Read();

        // -------> Creeare matrice de adiacenta pentru graf ciclic - pe linie si coloana, suma 2 <--------

        int adj[][] = new int[n][n];

        for(int i = 0; i<n; i++)
        {
            adj[i][(i+1)%n] = 1;
            adj[(i+1)%n][i] = 1; // elementul "simetric"
        }

        int adjPow[][] = new int[n][n];
        adjPow = adj;
        for(int k = 2; k<=n; k++)
        { int adjAux[][] = new int [n][n];
            for(int i = 0; i < n; i++)
                for(int j = 0; j < n; j++)
                {   adjAux[i][j] = 0;
                    for (int p = 0; p < n; p++)
                    {
                        adjAux[i][j] += adj[i][p] * adjPow[p][j];
                    }
                }
            adjPow = adjAux;
            System.out.println("Power " + k);
            for(int i = 0; i < n; i++)
            { for(int j = 0; j < n; j++)
                {
                    System.out.print(adjPow[i][j] + " ");
                }
                System.out.println();
            }
        }
        // -----------------------------------------------------------------------------------------------

        // ----> Creeare matrice de adiacenta pentru graf regular, stim gradul fiecarui nod <-------------
/*
        System.out.print("Enter an integer value, number of vertices of regular graph: ");
        int m = Read();
        System.out.print("Enter an integer value, vertex degree: ");
        int d = Read();

        while(d>m)
        {
            System.out.print("Invalid degree. Please insert a value between 0 and " + m + " : ");
            d = Read();
        }
*/


        // -----------------------------------------------------------------------------------------------

    }
}