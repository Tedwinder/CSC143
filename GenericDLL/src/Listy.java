//DoubleLinkedList by Ted Callow
public interface Listy {
public void add(Object o); 
public void add(Object[] o); 
public int size(); 
public Object get(int n) throws ListOutOfBounds; 
//check negative or too big!
public void insertAfter(Object afterMe, Object toInsert) throws MissingFromList;
public void insertAfter(int afterMe, Object[] toInsert) throws ListOutOfBounds; 
//check negative or too big!
public void insertAfter(Object afterMe, Object[] toInsert) throws MissingFromList;
public void insertAfter(int afterMe, Object toInsert) throws ListOutOfBounds; 
//check negative or too big!
public void insertBefore(Object beforeMe, Object toInsert) throws MissingFromList;
public void insertBefore(int beforeMe, Object[] toInsert) throws ListOutOfBounds; //check negative or too big!
public void insertBefore(Object beforeMe, Object[] toInsert) throws MissingFromList;
public void insertBefore(int beforeMe, Object toInsert) throws ListOutOfBounds; //check negative or too big!
public boolean delete (Object objToDelete); // returns true if it succeeds 
public boolean delete (int indexToDelete); // returns true if it succeeds 
public Object[] toArray(); 
public int locOf(Object toFind);
// returns location of object, or -1 if not found

public void print(String label); //prints on System.out a nicely formatted
//version of the list with the argument label

}