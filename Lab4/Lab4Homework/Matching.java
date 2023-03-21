package Homework;

import java.util.*;

public class Matching {

    Map<Student, Set<Project>> graph;
    List<Student> students;
    List<Project> projects;
    boolean[][] matrix;
    int[] assignedProjects;

    Matching(List<Student> students, List<Set<Project>> projects)
    {
       graph = new HashMap<>();
       this.students = new ArrayList<>(students);
       this.projects = new ArrayList<>();

       for(int i = 0; i<students.size(); i++)
       {
           graph.put(students.get(i), projects.get(i));
            if(this.projects.size() < projects.size())
                this.projects = new ArrayList<>(projects.get(i));
       }
        generateMatrix();
    }

    void generateMatrix()
    {
        matrix = new boolean[graph.size()][graph.size()];
        for(int i =0; i <matrix.length; i++)
        {
            for(int j =0; j<matrix.length; j++)
            {
                if(graph.get(students.get(i)).contains(projects.get(j)) == true)
                    matrix[i][j] = true;
                else
                    matrix[i][j] = false;
            }
        }

        for(int i =0; i <matrix.length; i++)
        {
            for (int j = 0; j < matrix.length; j++)
            {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }
    public Map<Student, Set<Project>> getGraph() {
        return graph;
    }

    @Override
    public String toString() {
        StringBuilder result = new StringBuilder();

        for (Map.Entry<Student,Set<Project>> entry : graph.entrySet())
        {
            result.append("[" + entry.getValue().size() + "] " + entry.getKey().getName() + " -> ");
            for(Project iterator : entry.getValue())
            {
                result.append(iterator.getName() + ", ");
            }
            result.append("\n");
        }
            return result.toString();
    }

    void numOfPreferencesBelowAverage()
    {
        Collection<Set<Project>> projects = graph.values();
        double avg = projects.stream().mapToInt(Set::size).average().getAsDouble();

        System.out.println("Studentii cu nr de proiecte sub nr mediu (" + avg + "): ");
            students.stream()
                    .filter(s -> graph.get(s).size() < avg)
                    .forEach(System.out::println);
    }

    boolean matching(int u, boolean visited[], int[] assignedProjects)
    {
        // incercam pt fiecare proiect
        for (int v = 0; v < matrix.length; v++)
        {
            // daca studentul u doreste proiectul v si nu e deja asignat
            if (matrix[u][v] && !visited[v])
            {

                // marcam ca am asignat v
                visited[v] = true;

                // vedem si daca l a luat cineva mai inainte si daca are disponbile altceva
                if (assignedProjects[v] < 0 || matching(assignedProjects[v], visited, assignedProjects) == true)
                {
                    assignedProjects[v] = u;
                    return true;
                }
            }
        }
        return false;
    }

    // nr max de cuplaje
    int maxCardinality()
    {
        // pt vector la pozitia i vom avea indicele studentului respectiv
        assignedProjects = new int[matrix.length];

        // toate proiectele sunt neasignate
        for(int i = 0; i < matrix.length; ++i)
            assignedProjects[i] = -1;

        // numaram cate proiecte s au dat
        int result = 0;
        for (int u = 0; u < matrix.length; u++)
        {
            // pt urm student, toate sunt nevizitate
            boolean visited[] = new boolean[matrix.length] ;
            for(int i = 0; i < matrix.length; ++i)
                visited[i] = false;

            // verificam daca studentul u are disponibil un proiect
            if (matching(u, visited, assignedProjects) == true)
                result++;
        }
        return result;
    }

    void printMatchings()
    {
        this.maxCardinality();
        System.out.println("Matchings: ");
        for(int i = 0; i < assignedProjects.length; i++)
        {
            System.out.println("-->" + students.get(assignedProjects[i]).getName() + " - " + projects.get(i).getName());
        }
    }
}
