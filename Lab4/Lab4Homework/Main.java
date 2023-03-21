package Homework;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import com.github.javafaker.Faker;

public class Main {
    public static void main(String[] args)
    {

        var students = IntStream.rangeClosed(0, 9)
                .mapToObj(i -> new Student(new Faker().name().fullName()))
                .collect(Collectors.toList());

        List<Set<Project>> projects = new ArrayList<>();
        List<String> projectList = new ArrayList<>();

        for(int i =0; i<10; i++)
        {
            projectList.add(new Faker().name().title());
        }

        for(int j = 1; j<=10 ; j++)
        {
            projects.add(IntStream.rangeClosed(0, j-1)
                    .mapToObj(i -> new Project(projectList.get(i)))
                    .collect(Collectors.toSet()));
        }

        Matching cuplaj = new Matching(students, projects);

        System.out.println(cuplaj);

        cuplaj.numOfPreferencesBelowAverage();

        cuplaj.printMatchings();
    }
}