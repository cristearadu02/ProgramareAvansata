package Homework;

import java.util.Objects;

public class Project implements Comparable<Project>
{
    private String name;

    Project(String name)
    {
        this.name = name;
    }
    @Override
    public int compareTo(Project o) {
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
        return "Project{" +
                "name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Project project = (Project) o;
        return Objects.equals(name, project.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
