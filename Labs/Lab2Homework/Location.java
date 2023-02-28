package Lab2Homework;
public class Location {
    private String name;
    private float x,y;
    private locType type;
    Location(String nameL, float xC, float yC, locType loc)
    {
        name = nameL;
        x = xC;
        y = yC;
        type = loc;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCoord(float x, float y) {
        this.x = x;
        this.y = y;
    }
    public void setType(locType type) {
        this.type = type;
    }
    public String getName() {
        return name;
    }
    public float getX() {
        return x;
    }
    public float getY() {
        return y;
    }
    public locType getType() {
        return type;
    }
    public void printInfo()
    {
        System.out.println("Numele locatiei este " + name + ", fiind de tipul "+ type + " si avand coordonatele x: " + x + " si y: " + y + ".");
    }

    @Override
    public String toString() {
        return "Location{" +
                "name='" + name + '\'' +
                ", x=" + x +
                ", y=" + y +
                ", type=" + type +
                '}';
    }
}

