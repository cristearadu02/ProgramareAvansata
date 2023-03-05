package Lab2Homework;

public class Express extends roadType{

    private String material;

    Express(int grade ,String mat)
    {
        this.setRoadGrade(grade);
        material = mat;
    }
    public void setMaterial(String material) {
        this.material = material;
    }
    public String getMaterial() {
        return material;
    }
    @Override
    void printInfo() {
        System.out.println("EXPRESS");
    }

    @Override
    public String toString() {
        return "Highway{" +
                "material='" + material + '\'' +
                '}';
    }
}
