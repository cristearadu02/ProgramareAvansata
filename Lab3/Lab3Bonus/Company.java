package Lab3Bonus;

import java.util.HashMap;
import java.util.Map;


/**
 * The type Company.
 */
public class Company implements Node, Comparable<Company>
{
    private String name;
    private float avgSalary;
    private Map<Node, String> relationships = new HashMap<>();

    Company(String name, float avgSalary)
    {
        this.name = name;
        this.avgSalary = avgSalary;
    }

    public Map<Node, String> getRelationships() {
        return relationships;
    }

    public float getAvgSalary() {
        return avgSalary;
    }

    public void setAvgSalary(float avgSalary) {
        this.avgSalary = avgSalary;
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
    public int calculateImportance() {
        return relationships.size();
    }

    @Override
    public int compareTo(Company other)
    {
        return Integer.compare(calculateImportance(), other.calculateImportance() );
    }
    @Override
    public String toString() {
        return "Company{" +
                "name='" + name + '\'' +
                ", importance=" + calculateImportance() +
                '}' + "\n";
    }
}
