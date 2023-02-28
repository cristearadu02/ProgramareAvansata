public abstract class roadType {
    private int roadGrade;

    abstract void printInfo();
    public void setRoadGrade(int roadGrade) {
        this.roadGrade = roadGrade;
    }
    public int getRoadGrade() {
        return roadGrade;
    }
}
