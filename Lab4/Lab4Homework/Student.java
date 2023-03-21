package Homework;

import java.util.Objects;

public class Student implements Comparable<Student>{

    private String name;

    Student(String name)
    {
        this.name = name;

    }
    @Override
    public int compareTo(Student o)
    {
        return this.name.compareTo(o.name);
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return Objects.equals(getName(), student.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
