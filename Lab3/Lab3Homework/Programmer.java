package Lab3Homework;

import java.time.LocalDate;

public class Programmer extends Person {
    private float salary;
    private ProgrammerType grade;
    /**
     * Instantiates a new Person.
     *
     * @param name the name
     */
    Programmer(String name, LocalDate date, float salary, ProgrammerType grade)
    {
        super(name, date);
        this.salary = salary;
        this.grade = grade;
    }

    public float getSalary() {
        return salary;
    }

    public ProgrammerType getGrade() {
        return grade;
    }

    public void setSalary(float salary) {
        this.salary = salary;
    }

    public void setGrade(ProgrammerType grade) {
        this.grade = grade;
    }

    @Override
    public String toString() {
        return "Programmer{" +
                "name=" + this.getName() +
                ", salary=" + salary +
                ", grade=" + grade +
                ", importance=" + calculateImportance() +
                '}' + "\n";
    }
}
