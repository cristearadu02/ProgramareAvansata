package Lab2Bonus;

import java.util.ArrayList;

public class Infrastructure {
    private ArrayList<Road> edges = new ArrayList<>();
    private ArrayList<Location> vertices = new ArrayList<>();
    private int[][] adjacencyMatrix;
    private boolean[] reached;
    private String name;

    Infrastructure(String name, ArrayList<Road> roads, ArrayList<Location> locations)
    {
        this.name = name;
        for(Road i : roads)
        {
            if(edges.contains(i) == false)
            {
                edges.add(i);
            }
            else
            {
                System.out.println(i + " already exists in this infrastructure. ");
            }
        }
        for(Location i : locations)
        {
            if(vertices.contains(i) == false)
            {
                vertices.add(i);
            }
            else
            {
                System.out.println(i + " already exists in this infrastructure. ");
            }
        }

        calculateMatrix();

    }

    public void calculateMatrix()
    {
        adjacencyMatrix = new int[vertices.size()][vertices.size()];
        for(int i = 0; i < adjacencyMatrix.length; i++)
        {
            for(int j = 0; j < adjacencyMatrix.length; j++)
            {
                adjacencyMatrix[i][j] = existsConnection(vertices.get(i).getName(), vertices.get(j).getName());
            }
        }
    }
    public int existsConnection(String source,String destination)
    {
        for(Road iterator : edges)
        {
            if(iterator.getSource().equals(source) && iterator.getDestination().equals(destination))
            {
                return 1;
            }
        }
        return 0;
    }
    public void addEdge(Road edge)
    {
        if(edges.contains(edge) == false)
        {
            edges.add(edge);
        }
        else
        {
            System.out.println(edge + " already exists in this infrastructure. ");
        }
    }
    public void addVertice(Location vertice)
    {
        if(vertices.contains(vertice) == false)
        {
            vertices.add(vertice);
        }
        else
        {
            System.out.println(vertice + " already exists in this infrastructure. ");
        }
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setEdges(ArrayList<Road> edges) {
        this.edges = edges;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Road> getEdges() {
        return edges;
    }
    @Override
    public String toString() {
        return "Infrastructure{" +
                "edges=" + edges +
                ", vertices=" + vertices +
                ", name='" + name + '\'' +
                '}';
    }
    public void printInfo()
    {
        for(Road i : edges)
        {
            System.out.println(i);
        }
    }
    public boolean isValid(Location source, Location destination)
    {
        boolean sourceExists = false;
        boolean destionationExists = false;
        for(Location i : vertices)
        {
            if(i.getName() == source.getName())
                sourceExists = true;
            if(i.getName() == destination.getName())
                destionationExists = true;
        }
        if(sourceExists == true && destionationExists == true)
            return true;
        return false;
    }
    public boolean existsPath(Location source, Location destination)
    {
        if(isValid(source, destination) == false)
            return false;
        int start = vertices.indexOf(source);
        reached = new boolean[vertices.size()];
        for(int i = 0; i< reached.length; i++)
            reached[i] = false;
        dfs(start);
        int finish = vertices.indexOf(destination);
        return reached[finish];
    }
    public void dfs(int start)
    {
        reached[start] = true;

        for (int i = 0; i < adjacencyMatrix[start].length; i++) {
            if (adjacencyMatrix[start][i] == 1 && (reached[i] == false)) {
                dfs(i);
            }
        }
    }
    public float directConnection(Location a, Location b)
    {
        for(Road i : edges)
        {
            if(i.getSource() == a.getName() && i.getDestination() == b.getName())
                return i.getLength();
        }
        return 0;
    }
    public ArrayList<Location> getVertices() {
        return vertices;
    }
}
