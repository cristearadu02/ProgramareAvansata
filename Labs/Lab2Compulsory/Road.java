package Lab2Compulsory;

import java.lang.Math;
import java.util.Objects;

public class Road {
    private float speedLimit;
    private float length;
    private roadType type;
    private String source, destination;

    public Road(float sL, roadType rT, Location a, Location b)
    {
        speedLimit = sL;
        type = rT;
        source = a.getName();
        destination = b.getName();
        length = (float) Math.sqrt( Math.pow(b.getX() - a.getX(),2) + Math.pow(b.getY() - a.getY(),2) );
    }
    /*
    public void recalculateLength()
    {
        length = (float) Math.sqrt( Math.pow(destination.getX() - source.getX(),2) + Math.pow(destination.getY() - source.getY(),2) );
    }

     */
    public void setType(roadType type) {
        this.type = type;
    }
    public void setDestination(Location destination) {
        this.destination = destination.getName();
    }
    public void setSource(Location source) {
        this.source = source.getName();
    }
    public void setSpeedLimit(float speedLimit) {
        this.speedLimit = speedLimit;
    }
    public float getLength() {
        return length;
    }
    public float getSpeedLimit() {
        return speedLimit;
    }
    public String getDestination() {
        return destination;
    }
    public String getSource() {
        return source;
    }
    public roadType getType() {
        return type;
    }
    public void printInfo()
    {
        System.out.println("Drumul este de tip " + type + ", pleaca din " + source + " si ajunge in " + destination + ", avand o lungime de " + length + " km si putand circula cu maxim " + speedLimit + " km/h.");
    }

    @Override
    public String toString() {
        return "Lab2Compulsory.Road{" +
                "speedLimit=" + speedLimit +
                ", length=" + length +
                ", type=" + type +
                ", source=" + source +
                ", destination=" + destination +
                '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Road road = (Road) o;
        return  Float.compare(road.getSpeedLimit(), getSpeedLimit()) == 0 &&
                Float.compare(road.getLength(), getLength()) == 0 &&
                getType() == road.getType() &&
                Objects.equals(getSource(), road.getSource()) &&
                Objects.equals(getDestination(), road.getDestination());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getSpeedLimit(), getLength(), getType(), getSource(), getDestination());
    }

}
