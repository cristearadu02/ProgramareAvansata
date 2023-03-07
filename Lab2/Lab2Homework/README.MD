Create a class that describes an instance of the problem. 
   -> Clasa Infrastructure retine un ArrayList de Location, reprezentand nodurile grafului si un ArrayList de Road ce reprezinta drumurile din graf. 
      Clasa Road contine doua stringuri, sursa si destinatia unui drum. Pe baza acestora vom creea matricea de adiacenta a grafului, punand 1 pt [i][j] unde exista conexiune directa.
 
Override the Object.equals method for the Location and Road classes. The problem should not allow adding the same location or road twice.
   -> Am dat @Override la metoda equals pentru ambele clase, apoi cand incercam sa adaugam un nou drum sau o noua locatie, verificam parametrul dat metodei cu functia contains care apeleaza equals.

Instead of using an enum, create dedicated classes either for locations: cities, air ports, gas stations etc. or roads: highway, express, country, etc. Each concrete location class may have additional specific propertes (population, number of terminals, gas price, etc.)
   -> Am creat cate 2 tipuri de clase pentru fiecare, drum sau locatie, implementandu-le plecand de la 2 clase abstracte.

Implement a method that determines if a problem's instance is valid.
   -> Aici verificam ca locatiile date ca parametru sa existe in vectorul de locatii, lungime drumurilor fiind verificata deja de la creeare, daca e mai scurta decat ar trebui, o calculam euclidean.
   
   
Implement an algorithm for determining if it is possible to go from one location to another using the given roads.
  -> Aici facem o parcurgere dfs a grafului plecand din nodul dat ca parametru, mai apoi generam valorile boolenee, 1 daca avem drum pana intr-un anumit nod si 0 daca nu.
     Mai apoi luam indicele locatiei destinatie si returnam valoarea sa din vectorul de bool reached.
  
Write doc comments in your source code and generate the class documentation using javadoc.
  -> Am generat comentarii JavaDoc.
