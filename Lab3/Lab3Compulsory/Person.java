package Lab3Compulsory;

import java.util.HashMap;
import java.util.Map;

public class Person implements  Node, Comparable<Person>
{
    private String name;
    private Map<Node, String> relationships = new HashMap<>();

    Person(String name)
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
    @Override
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }
    @Override
    public int compareTo(Person other) {
        return this.name.compareTo(other.name);
    }
    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", relationships=" + relationships +
                '}';
    }
}
