package Lab2Homework;

import java.util.ArrayList;

public class Infrastructure {
    private ArrayList<Road> edges;
    private ArrayList<Location> vertices;
    private String name;

    Infrastructure(String name, ArrayList<Road> roads, ArrayList<Location> locations)
    {
        this.name = name;
        edges = roads;
        vertices = locations;
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
    public float getBestDistance(Location a, Location b)
    {
        return 0f;
    }
}
