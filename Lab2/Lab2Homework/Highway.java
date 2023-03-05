package Lab2Homework;

public class Highway extends roadType
{
    private String material;

    Highway(int grade ,String mat)
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
        System.out.println("HIGHWAY");
    }

    @Override
    public String toString() {
        return "Highway{" +
                "material='" + material + '\'' +
                '}';
    }
}
