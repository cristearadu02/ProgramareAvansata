package org.example;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

public class Student implements Comparable<Student>{

    private String name;
    private Set<Project> projectList;

    Student(String name)
    {
        this.name = name;
    }
    Student(String name, Set<Project> projectList)
    {
        this.name = name;
        this.projectList = new HashSet<>(projectList);
    }
    @Override
    public int compareTo(Student o)
    {
        return this.name.compareTo(o.name);
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", projectList=" + projectList +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Set<Project> getProjectList() {
        return projectList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(name, student.name) && Objects.equals(projectList, student.projectList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, projectList);
    }
}
