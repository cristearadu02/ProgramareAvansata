package Lab3Homework;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Network {
    List<Node> nodes;
    Network(List<Node> nodes)
    {
        this.nodes = nodes;
    }
    public void addRelationship(Node base, Node newRelation, String relation)
    {
        if(nodes.contains(base) == true)
        {
            if(nodes.contains(newRelation) == true)
            {
                base.addRelationship(newRelation,relation);
                newRelation.addRelationship(base, relation);
            }
            else
            {
                System.out.println(newRelation + " doesn't exists in this network");
            }
        }
        else
        {
            System.out.println(base + " doesn't exists in this network.");
        }
    }
    @Override
    public String toString() {

        Collections.sort(nodes, Collections.reverseOrder(Comparator.comparingInt(Node::calculateImportance))); // altfel da eroare

        return "Network{\n" +
                "nodes=" + nodes +
                '}';
    }
}
