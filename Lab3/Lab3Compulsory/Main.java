package Lab3Compulsory;

import java.util.ArrayList;
import java.util.List;
public class Main {
    public static void main(String[] args)
    {
        List<Node> network = new ArrayList<Node>();

        Person person1 = new Person("Radu");
        person1.addRelationship(new Company("FII"),"student");
        person1.addRelationship(new Person("Greg"),"friend from school");
        network.add(person1);
        network.get(0).addRelationship(new Company("Steaua"), "CAM");
        System.out.println(network);
    }
}
