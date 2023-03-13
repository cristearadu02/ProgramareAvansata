package Lab3Homework;

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
    void addRelationship(Node node, String value);
    int calculateImportance();

}
