public class Airport extends locType {
    private int airportGrade;


    Airport(int cap, int grade)
    {
        this.setCapacity(cap);
        airportGrade = grade;
    }
    public void setAirportGrade(int airportGrade) {
        this.airportGrade = airportGrade;
    }
    public int getAirportGrade() {
        return airportGrade;
    }
    @Override
    void printInfo() {
        System.out.println("AIRPORT!");
    }

    @Override
    public String toString() {
        return "Airport{" +
                "airportGrade=" + airportGrade +
                " airportCapacity=" + this.getCapacity() +
                '}';
    }
}
