package Lab3Bonus;

import Lab2Homework.Location;

import java.util.*;

public class Network {

    private List<Node> nodes;
    private int[][] graph;
    private boolean[] reached;

    Network(List<Node> nodes)
    {
        this.nodes = nodes;
    }

    public void createMatrix()
    {
        sort();
        graph = new int[nodes.size()][nodes.size()];
        for(int i = 0; i< graph.length; i++)
            for(int j = 0; j< graph.length; j++)
            {
                if(nodes.get(i).getRelationships().containsKey(nodes.get(j)))
                {
                    graph[i][j] = 1;
                    graph[j][i] = 1;
                }
                else
                {
                    graph[i][j] = 0;
                    graph[j][i] = 0;
                }
            }
        /*
        for(int i = 0; i< graph.length; i++)
        {
            for(int j = 0; j< graph.length; j++)
            {
                System.out.print(graph[i][j] + " ");
            }
            System.out.println();
        }
         */
    }

    public void findBlocks()
    {
        createMatrix();
        Set<Node> block; // ceea ce va contine blockul
        Set<Set<Node>> verifyExists = new HashSet<>(); // pentru a tine evidenta blocurilor deja gasite
        Set<Node> neighbors; // vecinii nodurilor din bloc, la final ar trebui sa fie gol

        for(Node iterator : nodes)
        {   // reinitializam pentru fiecare nod din graf
            block = new HashSet<>();
            neighbors = new HashSet<>();

            if(iterator.calculateImportance() == 2) // daca dam de un nod cu gradul 2
            {
                block.add(iterator); // il adaugam la blockul curent
                neighbors.addAll(iterator.getRelationships().keySet()); // ii punem vecinii

                for(Node iterator2 : nodes) // cautam nodurile care ar putea face parte din blockul curent
                {
                    if(iterator2.calculateImportance() == 2 && verifyNeighbor(iterator2, block) == true) // daca e vecin cu un nod din block si are gradul 2, e ok
                    {
                        neighbors.addAll(iterator2.getRelationships().keySet()); // adaugam si vecinii nodului tocmai adaugat
                        block.add(iterator2); // il adaugam la blockul curent
                    }
                }

                neighbors.removeAll(block); // scoatem nodurile din block din vecini, daca mai ramane ceva inseamna ca nu e ok

                if(block.isEmpty() == false) // daca nu e gol, mergem mai departe
                {

                    if(verifyExists.contains(block) == false && neighbors.isEmpty() == true)
                    {
                        System.out.println("Block: " + block);
                        verifyExists.add(block); // adaugam blockul curent ca sa nu l mai afisam o data cand dam de urm nod
                    }

                }
            }


        }

    }
    boolean verifyNeighbor(Node needle, Set<Node> haystack)
    {
        for(Node iterator : haystack)
        {
            if(iterator.getRelationships().containsKey(needle) == true) // parcurgem lista de vecini a blockului curent si vedem daca se gaseste si nodul dat ca parametru
            {
                return true;
            }
        }
        return false;
    }
    public void findArticulationPoints()
    {
        Map<Node, List<Node>> initialDfs = new HashMap<>(); // vedem unde putem ajunge din fiecare nod initial
        createMatrix();
        for(int i = 0; i< nodes.size(); i++)
        {   List<Node> auxNode = new ArrayList<>();
            for (int j = 0; j < nodes.size(); j++)
            {
                if(existsPath(nodes.get(i), nodes.get(j))) // daca exista drum, marcam treaba asta
                {
                    auxNode.add(nodes.get(j));
                }
            }
            initialDfs.put(nodes.get(i), auxNode);
        }

        List<Node> copyNodes = new ArrayList<>(); // vom modifica nodes, scoatem pe rand noduri, deci trb sa tinem evidenta
        copyNodes.addAll(nodes);

        Map<Node, List<Node>> copyInitialDfs = new HashMap<>(); // asemenea ca la comentariul anterior
        copyInitialDfs.putAll(initialDfs);

        Set<String> result = new HashSet<>(); // ca sa nu le punem de mai multe ori, folosim un set

        for(int i = 0; i< nodes.size(); i++)
        {
            nodes = new ArrayList<>();
            nodes.addAll(copyNodes);

            Map<Node, List<Node>> finalDfs = new HashMap<>(); // vedem unde putem ajunge din nodul curent dupa eliminarea unui nod

            initialDfs = new HashMap<>();
            initialDfs.putAll(copyInitialDfs);

            initialDfs.remove(nodes.get(i)); // scoatem cheia nodului pe care il stergem

            nodes.remove(i); // scoatem nodul si din nodes, pt a recalcula matricea de adiacenta

            createMatrix();

            // calculam unde putem ajunge plecand din nodul curent, dupa stergerea unui anumit nod
                for(int j = 0; j< nodes.size(); j++)
                {
                    List<Node> auxNode = new ArrayList<>();

                    for(int m = 0; m <  nodes.size(); m++)
                    {
                        if(existsPath( nodes.get(j), nodes.get(m)))
                        {
                            auxNode.add( nodes.get(m));
                        }
                    }
                    finalDfs.put(nodes.get(j), auxNode); // aici e mapul care ne arata nodurile mentionate in comentariul anterior
                }

            for (Map.Entry<Node, List<Node>> entry : finalDfs.entrySet()) // iteram prin nodurile in care putem ajunge din fiecare nod dupa stergerea unui anumit nod
            {
                List<Node> finalValue = entry.getValue(); // luam valorile in care putem ajunge din nodul curent
                List<Node> initialValue = initialDfs.get(entry.getKey()); // luam valorile initiale pentru nodul curent, adica inainte de stergerea altui nod
                finalValue.remove(copyNodes.get(i)); // stergem si din nodurile in care putem ajunge nodul i, sters anterior
                    if(initialValue.size() - finalValue.size() > 1) // daca difera prin minim 2 noduri, inseamna ca s a deconectat graful, aici cuprindem si cazul cu noduri izolate
                      {
                          result.add(copyNodes.get(i).getName());
                      }
            }
        }

        nodes = new ArrayList<>(); // avem grija sa nu pierdem nodurile initiale
        nodes.addAll(copyNodes);

        System.out.println("Articulation points: " + result);
    }

    public boolean existsPath(Node source, Node destination)
    {
        sort();
        int start = nodes.indexOf(source);
        reached = new boolean[nodes.size()];
        for(int i = 0; i< reached.length; i++)
            reached[i] = false;
        dfs(start);
        int finish = nodes.indexOf(destination);
        return reached[finish];
    }

    public void dfs(int start)
    {
        reached[start] = true;

        for (int i = 0; i < graph[start].length; i++) {
            if (graph[start][i] == 1 && (reached[i] == false)) {
                dfs(i);
            }
        }
    }
    void sort()
    {
        Collections.sort(nodes, Collections.reverseOrder(Comparator.comparingInt(Node::calculateImportance))); // altfel da eroare
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

        this.sort();

        return "Network{\n" +
                "nodes=" + nodes +
                '}';
    }
}
