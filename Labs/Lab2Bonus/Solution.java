package Lab2Bonus;
public class Solution {

    private Infrastructure data;
    private float[][] graph;
    private int numVertices;
    Solution(Infrastructure input)
    {
        data = input;
        graph = new float[input.getVertices().size()][input.getVertices().size()];
        numVertices = graph.length;

        for(int i = 0; i < graph.length; i++)
        {
            for(int j = 0; j < graph.length; j++)
            {
                if(i==j)
                    graph[i][j] = 0;
                else
                    graph[i][j] = input.directConnection(input.getVertices().get(i), input.getVertices().get(j));
            }
        }

        for(int i = 0; i < graph.length; i++)
        {
            for (int j = 0; j < graph.length; j++)
            {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
    }

    int minDistance(float dist[], boolean existsMinPath[])   {
        float min = Float.MAX_VALUE;
        int min_index = -1;
        for (int v = 0; v < numVertices; v++)
            if (existsMinPath[v] == false && dist[v] <= min) {
                min = dist[v];
                min_index = v;
            }

        return min_index;
    }
    void dijkstra(Location source, Location destination)
    {
        if(data.canGo(source,destination) == true)
        {
            int src_node = data.getVertices().indexOf(source);
            float dist[] = new float[numVertices]; // dist[i] = distanta minima dintre source si i

        // retinem daca pentru un anumit nod exista un drum de lung minima sau nu
        boolean existsMinPath[] = new boolean[numVertices];

        // plecam de la ideea ca nu exista un min path si distanta e "infinita"
        for (int i = 0; i < numVertices; i++) {
            dist[i] = Integer.MAX_VALUE;
            existsMinPath[i] = false;
        }

        dist[src_node] = 0;
        // cautam min path
        for (int count = 0; count < numVertices - 1; count++)
        {
            // u - nodul cu distanta minima fata de sursa
            int u = minDistance(dist, existsMinPath);
            // marcam ca l am verificat pe u
            existsMinPath[u] = true;
            // nodurile adiacente cu nodul dat
            for (int v = 0; v < numVertices; v++)
            {// daca nodul v nu e in path, il adaugam, sau updatam
                if ((existsMinPath[v] == false && graph[u][v] != 0) && dist[u] != Float.MAX_VALUE && dist[u] + graph[u][v] < dist[v])
                    dist[v] = dist[u] + graph[u][v];
            }
        }

        for (int i = 0; i < numVertices; i++)
            if(data.getVertices().get(i).getName() == destination.getName())
                    System.out.println(source.getName() + " - " + destination.getName() + ": " + dist[i]);
        }
        else
        {
            System.out.println("There is no road between " + source.getName() + " and " + destination.getName() );
        }
    }

}
