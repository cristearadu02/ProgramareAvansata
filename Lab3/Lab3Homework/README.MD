Create the complete model: Person, Programmer, Designer, Company. All persons have a birth date. Each class must have at least one specific property, that others don't have (be creative).

  -> Din clasa Person am derivat Programmer si Deisgner. Am adaugat in Person si un camp de tip LocalDate, pt Programmer avem campul specific salary si gradul de experienta
 iar pentru Designer celebritatea acestuia.
 
Each person will contain a Map defining the relathionships to other persons or companies.
  
  -> In clasa Person, dar si in clasa Company am creat un Map intre un anumit Node si un String reprezentand relatia dintre this si Node-ul dat ca parametru
  
Create the Network class containing a List of identifiable nodes.

  -> Am creat clasa Network care are un camp ce contine un List de Node.
  
Create a method that computes the importance of a node in the network, as the number of its connections to other nodes.
  
  -> Am creat metoda calculateImportance ce returneaza dimensiunea map-ului unei anumite persoane/companii. 
  
Create a network object containing persons, companies and relationships and print it on the screen. When printing the network, the nodes must be ordered according to their importance.

  -> Am creat in Main un Network si l-am printat pe ecran, utilizand metoda toString() in care realizam si o sortare a nodurilor utilizand un lamba in toString().
