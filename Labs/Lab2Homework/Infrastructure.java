package Lab2Homework;

import java.util.ArrayList;

public class Infrastructure {
    private ArrayList<Road> edges = new ArrayList<>();
    private ArrayList<Location> vertices = new ArrayList<>();
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
    public float getBestDistance(Location a, Location b)
    {
        return 0f;
    }
    public Road getR(String name, int index)
    {
        for(int i = index; i<edges.size(); i++)
        {
            if(edges.get(i).getSource() == name)
                return edges.get((i));
        }
        return null;
    }
    public Road getRaux(String name)
    {
        for(int i = 0; i<edges.size(); i++)
        {
            if(edges.get(i).getSource() == name)
                return edges.get((i));
        }
        return null;
    }
    public boolean traverse(Road aux, Location destination)
    {
        while (aux != null && aux.getDestination() != destination.getName()) {
            aux = getRaux(aux.getDestination());
        }

        if (aux != null && aux.getDestination() == destination.getName()) {
            return true;
        }
        return false;
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
    public boolean canGo(Location source, Location destination)
    {
        if(this.isValid(source,destination) == true)
        {
            for(Road i : edges)
            {
                if(source.equals(destination) == true)
                    return true;
                int index = 0, prev = 0;
                if(i.getSource() == source.getName())
                {
                    if(i.getDestination() == destination.getName())
                    {
                        return true;
                    }
                    else
                    {
                        Road aux = getR(i.getDestination(), index);
                        index = edges.indexOf(aux);

                        while(index != prev && aux!=null)
                        {
                            prev = index;
                            index++;
                            boolean verify = traverse(aux, destination);
                            if(verify == true)
                                return true;
                            aux = getR(i.getDestination(), index);
                            index = edges.indexOf(aux);
                        }

                    }
                }
            }
        }
        return false;
    }
}
