package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {

         /* var students = IntStream.rangeClosed(0, 2)
                .mapToObj(i -> {
                    return new Student("S" + i, (Set<Project>) IntStream.rangeClosed(0,2).mapToObj(j -> {
                       return new Project("P" + j);
                    })
                    );
                })
                .toArray(Student[]::new);
            */

        Set<Project> projects = Arrays.asList(
                new Project("P0"),
                new Project("P1"),
                new Project("P2")
        ).stream().collect(Collectors.toSet());


        Set<Student> students = Arrays.asList(
                new Student("S0", new HashSet<>(Arrays.asList(new Project("P0"), new Project("P1"), new Project("P2")))),
                new Student("S1", new HashSet<>(Arrays.asList(new Project("P0"), new Project("P1")))),
                new Student("S2", new HashSet<>(Arrays.asList(new Project("P0"))))
        ).stream().collect(Collectors.toSet());


        List<Student> studentsList = new LinkedList<>(students);
        studentsList.sort(Student::compareTo);

        for(Student iterator : studentsList)
        {
            System.out.println(iterator);
        }

        Set<Project> projectsList = new TreeSet<>(projects);
        projectsList.stream().sorted(Project::compareTo);

        for(Project iterator : projectsList)
        {
            System.out.println(iterator);
        }
    }
}