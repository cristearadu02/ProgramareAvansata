package Lab3Bonus;

import java.time.LocalDate;

public class Designer extends Person {
    private int celebrityGrade;

    /**
     * Instantiates a new Person.
     *
     * @param name the name
     */
    Designer(String name, LocalDate date, int celebrityGrade)
    {
        super(name, date);
        this.celebrityGrade = celebrityGrade;
    }

    public int getCelebrityGrade() {
        return celebrityGrade;
    }

    public void setCelebrityGrade(int celebrityGrade) {
        this.celebrityGrade = celebrityGrade;
    }

    @Override
    public String toString() {
        return "Designer{" +
                "name=" + getName() +
                ", celebrityGrade=" + celebrityGrade +
                ", importance=" + calculateImportance() +
                '}';
    }
}
