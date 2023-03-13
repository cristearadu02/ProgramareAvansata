package Lab3Bonus;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;


public class Person implements Node, Comparable<Person>
{
    private String name;
    private Map<Node, String> relationships = new HashMap<>();
    private LocalDate birthDate;


    Person(String name, LocalDate birthDate)
    {
        this.name = name;
        this.birthDate = birthDate;
    }
    @Override
    public String getName() {
        return name;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    @Override
    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

    @Override
    public void addRelationship(Node node, String value) {
        relationships.put(node, value);
    }

    @Override
    public int calculateImportance() {
        return relationships.size();
    }

    @Override
    public int compareTo(Person other)
    {
        return Integer.compare(calculateImportance(), other.calculateImportance() );
    }
    @Override
    public String toString() {
        return "Person{" +
                "name=" + getName() +
                ", importance=" + calculateImportance() +
                '}' + "\n";
    }
}
