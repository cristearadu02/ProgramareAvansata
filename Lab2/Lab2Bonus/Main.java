package Lab2Bonus;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {

        Location Iasi = new Location("Iasi", 47.5f, 27.8f, new City(10000, 2));
        Location Bucuresti = new Location("Bucuresti", 23.5f, 90.8f, new City(100000, 6));
        Location Pitesti = new Location("Pitesti", 89.00f, 56.75f, new City(3000, 4));
        Location Mamaia = new Location("Mamaia", 78.5f, 89.8f, new City(9000, 3));
        Location Tecuci = new Location("Tecuci", 69f, 70f, new City(1000,10));
        Location Madrid = new Location("Madrid", 100f, 200f, new City(1000,10));

        Road a1 = new Road(120f, new Highway(10, "cement"), Iasi, Bucuresti,200);
        Road e1 = new Road(90f, new Express(8, "basalt"), Bucuresti, Pitesti,170);
        Road a2 = new Road(90f, new Highway(8, "piatra"), Bucuresti, Mamaia, 190);
        Road e2 = new Road(90f, new Express(8, "basalt"), Pitesti, Mamaia,470);
        Road a3 = new Road(120f, new Highway(10, "Beton"), Bucuresti, Tecuci, 900);
        Road a4 = new Road(120f, new Highway(10, "Beton"), Tecuci, Iasi, 170);
        Road e9 = new Road(90f, new Express(8, "basalt"), Pitesti, Iasi,200);
        Road a10 = new Road(120f, new Highway(10, "good"), Mamaia, Tecuci, 300);

        ArrayList<Road> roads = new ArrayList<Road>();
        roads.add(a1);
        roads.add(e1);
        roads.add(e2);
        roads.add(a2);
        roads.add(a3);
        roads.add(a4);
        roads.add(e9);
        roads.add(a10);

        ArrayList<Location> locations = new ArrayList<Location>();
        locations.add(Iasi);
        locations.add(Bucuresti);
        locations.add(Pitesti);
        locations.add(Mamaia);
        locations.add(Tecuci);
        locations.add(Madrid);

        Infrastructure Romania = new Infrastructure("Romania", roads, locations);
        //System.out.println(Romania);

        //System.out.println(Romania.isValid(Madrid, Iasi));
        //System.out.println(Romania.canGo(Bucuresti, Iasi));

        Solution sol = new Solution(Romania);

        sol.dijkstra(Pitesti,Madrid);

    }
}