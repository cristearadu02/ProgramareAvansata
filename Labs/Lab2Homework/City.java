public class City extends locType
{
    private int cityGrade;

    @Override
    void printInfo()
    {
        System.out.println("City");
    }
    public int getCityGrade() {
        return cityGrade;
    }
    public void setCityGrade(int cityGrade) {
        this.cityGrade = cityGrade;
    }
    City(int cap, int grade)
    {
        this.setCapacity(cap);
        cityGrade = grade;
    }

    @Override
    public String toString() {
        return "City{" +
                "cityGrade=" + cityGrade +
                " cityCapacity=" + this.getCapacity() +
                '}';
    }
}
