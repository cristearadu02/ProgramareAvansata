package Lab3Bonus;

import java.util.Map;

/**
 * The interface Node.
 */
public interface Node {
    /**
     * Gets name.
     *
     * @return the name
     */
    // abstract by default
    String getName();
    Map<Node, String> getRelationships();
    void addRelationship(Node node, String value);
    int calculateImportance();

}
