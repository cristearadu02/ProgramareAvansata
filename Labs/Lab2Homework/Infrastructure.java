import java.util.ArrayList;
public class Infrastructure {
    private ArrayList<Road> roads;
    private String name;

    Infrastructure(String n, ArrayList<Road> r)
    {
        name = n;
        roads = r;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setRoads(ArrayList<Road> roads) {
        this.roads = roads;
    }
    public String getName() {
        return name;
    }
    public ArrayList<Road> getRoads() {
        return roads;
    }

    @Override
    public String toString() {
        return "Infrastructure{" +
                "roads=" + roads +
                ", name='" + name + '\'' +
                '}';
    }
    public void printInfo()
    {
        for(Road i : roads)
        {
            System.out.println(i);
        }
    }
    public float getBestDistance(Location a, Location b)
    {
        return 0f;
    }
}
