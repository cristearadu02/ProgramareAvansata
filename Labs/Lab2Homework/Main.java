package Lab2Homework;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Location myCity = new Location("Iasi", 47.1622f, 27.5889f, new City(10000, 9));
        Location myGasStation = new Location("OMV",123.70f,93.2f, new GasStation(25, 7.39F));
        Location myAirport = new Location("Otopeni", 290.5f, 120.90f, new Airport(1200, 10));


        Road a1 = new Road(120f, new Highway(10, "cement"), myCity, myAirport);
        Road e2 = new Road(90f, new Express(8, "basalt"), myGasStation, myAirport);

        ArrayList<Road> roads = new ArrayList<Road>();
        roads.add(a1);
        roads.add(e2);

        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(myCity);
        locations.add(myGasStation);
        locations.add(myAirport);

        Infrastructure Romania = new Infrastructure("Romania", roads, locations);
        System.out.println(Romania);

    /*

        Location myGym = new Location("World Class",170.98f, 250.89f, locType.GYM);
        Location myShop = new Location("Lidl", 47.14722f, 27.59428f, locType.SHOP);

        Road a1 = new Road(120f, roadType.HIGHWAY, myCity, myShop);
        Road e2 = new Road(90f, roadType.EXPRESS, myShop, myAirport);
        Road c1 = new Road(50f, roadType.COUNTRY, myCity, myGasStation);
        Road f8 = new Road(30f, roadType.FORESTRY, myGasStation, myGym);


        System.out.println(a1);
        System.out.println(c1);
        System.out.println(f8);
        System.out.println(e2);

     */
    }
}