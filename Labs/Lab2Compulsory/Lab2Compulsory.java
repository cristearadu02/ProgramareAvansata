package Lab2Compulsory;
public class Lab2Compulsory {
    public static void main(String[] args) {

        Location myGasStation = new Location("OMV",123.70f,93.2f,locType.GAS_STATION);
        Location myAirport = new Location("Otopeni", 290.5f, 120.90f, locType.AIRPORT);
        Location myGym = new Location("World Class",170.98f, 250.89f, locType.GYM);
        Location myShop = new Location("Lidl", 47.14722f, 27.59428f, locType.SHOP);
        Location myCity = new Location("Iasi", 47.1622f, 27.5889f, locType.CITY);

        Road a1 = new Road(120f, roadType.HIGHWAY, myCity, myShop);
        Road e2 = new Road(90f, roadType.EXPRESS, myShop, myAirport);
        Road c1 = new Road(50f, roadType.COUNTRY, myCity, myGasStation);
        Road f8 = new Road(30f, roadType.FORESTRY, myGasStation, myGym);

        System.out.println(myCity);
        System.out.println(myGym);
        System.out.println(myGasStation);
        System.out.println(a1);
        System.out.println(c1);
        System.out.println(f8);
        System.out.println(e2);
    }
}