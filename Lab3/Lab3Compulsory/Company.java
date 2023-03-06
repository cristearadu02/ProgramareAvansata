package Lab3Compulsory;

import java.util.HashMap;
import java.util.Map;

public class Company implements  Node, Comparable<Company>
{
    private String name;
    private Map<Node, String> relationships = new HashMap<>();
    Company(String name)
    {
        this.name = name;
    }
    @Override
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", relationships=" + relationships +
                '}';
    }

    @Override
    public int compareTo(Company other) {
        return this.name.compareTo(other.name);
    }
}
