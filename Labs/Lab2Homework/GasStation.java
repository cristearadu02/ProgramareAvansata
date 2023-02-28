public class GasStation extends locType{

    private float gasPrice;

    GasStation(int cap, float price)
    {
        this.setCapacity(cap);
        gasPrice = price;

    }
    public void setGasPrice(float gasPrice) {
        this.gasPrice = gasPrice;
    }
    public float getGasPrice() {
        return gasPrice;
    }
    @Override
    void printInfo() {
        System.out.println("Gas Station");
    }

    @Override
    public String toString() {
        return "GasStation{" +
                "gasPrice=" + gasPrice +
                " gasStationCapacity=" + this.getCapacity() +
                '}';
    }
}
