
//DoubleLinkedList by Ted Callow
public class DoubleLinkTester {
public static void main(String[] args) throws ListOutOfBounds,
MissingFromList {
GenericDLL l = new GenericDLL("First guy in line");


l.add("Thor"); l.add("Loki"); l.add("Odin"); l.add("Zeus"); l.add("Hera"); l.add("Neptune"); l.print("Newly-minted list");
l.insertAfter("Thor", "Freja"); l.print("After inserting Freja after Thor");
l.insertBefore("Zeus", "Venus"); l.print("After inserting Venus before Zeus");
String[] bunnies = {"Harry", "Fuzzy"}; l.insertBefore("Thor", bunnies); l.print("After inserting bunnies before Thor");
String[] kids = {"Cupid","Bambi","Thumper"}; l.insertAfter("Hera", kids); l.print("After inserting kids after Hera");
l.insertBefore(12, "Ravananana"); l.print("After inserting Ravananana before int argument 12");
l.insertAfter(12, "After 12"); l.print("After inserting \"After 12\" after int argument 12");
String[] someshit = {"Some", "Shit"}; l.insertBefore("Ravananana", someshit); l.print("After inserting {some,shit} array before Ravananan");
String[] someshit2 = {"Some2", "Shit2"}; l.insertAfter("Ravananana", someshit2); l.print("After inserting someshit2 array after Ravananan");
String[] someshit3 = {"Some3", "Shit3"}; l.insertBefore(3, someshit3); l.print("After inserting someshit3 array before 3");
String[] someshit4 = {"Some4", "Shit4"}; l.insertAfter(4, someshit4); l.print("After inserting someshit4 array after 4");
l.delete("Zeus"); l.print("After deleting Zeus");
l.delete(4); l.print("After deleting 4");
l.delete(0); l.print("after deleting 0");
l.delete(0); l.print("after deleting 0 a second time");
l.replace("Some2", "yummy");l.print("yummy");
System.out.println("size is now: " + l.size());
l.quickSort();l.print("after sort");
//end of Straayer's test












//test for add method
//l.add("Thor"); l.add("Loki"); l.add("Papadopolous"); l.add("Zeus");
//l.add("Hera"); l.add("Neptune"); 
//l.print("Newly-minted list");

//System.out.println(l.locOf("Neptune"));

//l.quickSort();l.print("after sort");

//System.out.print(l.size());


//l.insertAfter("lala", "Freja"); l.print("After inserting Freja");
//l.insertBefore("Zeus", "Venus"); l.print("After inserting Venus before Zeus");
//l.delete(3);l.print("deleting 3");//delete(0) not ok; add ok; locOF remember return -1
//l.insertBefore("Hera", "Doggie"); l.print("After inserting Doggie before Hera");
//l.insertBefore("Doggie", "Lala"); l.print("After inserting lala before Thor");
//System.out.println(l.locOf("Odin"));
//l.quickSort();l.print("after quicksort");
//l.sort();l.print("after sort");

//l.sort();l.print("after sort");
//l.toArray();
//l.deleteLL();l.print("all gone");
//l.recreateLL(l.toArray());l.print("doubled?");

//String[] kids = {"Cupid","Bambi","Thumper"};
//l.insertAfter("Hera", kids); l.print("After inserting kids");
//l.delete("Zeus"); l.print("After deleting Zeus");//doesn't work yet for last member or array
//l.delete(4); l.print("After deleting 4");
//l.insertAfter(2, "Doggie");; l.print("After inserting doggie");
//l.delete("Thumper"); l.print("After deleting Thumper");
//System.out.println("size is now: " + l.size()); System.out.println("guy at the beginning: " + l.get(0)); System.out.println("guy at the end: " + l.get(l.size()-1));
//l.delete(kids); l.print("After deleting kids");
//l.insertBefore("Doggie", kids);l.print("inserting kids before doggie");
//
//l.size();
//l.delete(kids);l.print("after deleting kids");
//l.delete(kids);l.print("after deleting kids again");
//l.delete(kids);l.print("after deleting kids again");
//l.add(kids);l.print("adding another set of kids");
//l.size();
//l.delete(kids);l.print("deleting kids again");
//l.size();
//l.insertAfter(1, kids);l.print("after inserting kids after position 1");
//l.insertBefore(1, kids);l.print("after inserting kids before position 1");
//l.insertBefore(1, "susan");l.print("susan before #1");


//System.out.println(l.size());
//

//System.out.println("Doggie is at position # " + l.locOf("Doggie"));
//System.out.println(l.toArray());
//l.insertBefore("Thor", "Baldur");l.print("inserting Baldur before Thor");

//l.delete(0);l.print("deleting 0");//insertBefore- fail
//l.delete(1);l.print("deleting 1");//add - success
//l.delete(2);l.print("deleting 2");//insertBefore
//l.delete(3);l.print("deleting 3");//insertAfter
//l.delete(4);l.print("deleting 4");//add - fail
//l.delete(7);l.print("deleting 7");//insertAfter - success
//l.delete(6);l.print("deleting 6");//add - fail
//l.delete(5);l.print("deleting 5");//insertBefore - success
//l.delete(8);l.print("deleting 8");//add - fail
//l.delete(9);l.print("deleting 9");//add
//l.delete(10);l.print("deleting 10");//add

//l.insertBefore("Doggie", kids);l.print("inserting kids before Doggie");
//l.insertAfter(1, kids);l.print("after inserting kids after position 1");
//l.insertBefore(1, kids);l.print("after inserting kids after position 1");
//l.insertAfter("susan", kids);l.print("inserting kids after susan");//doesn't work

//l.insertAfter("Baldur", kids);l.print("inserting kids after Baldur");
//l.insertBefore("Doggie", kids);l.print("inserting kids before Doggie");
//l.insertBefore(8, kids);l.print("inserting kids again before Doggie");
//System.out.println("The size of the list is: " +l.size());
//l.delete(kids);l.print("deleting the little children");
//System.out.println("The size of the list is: " +l.size());
//l.delete("Hera");l.print("deleted Hera");
}
}
//list of errors: delete last; insertBefore first; compounding array insertions
//questions - is delete(9) a mistake?; 
//ANY NEED FOR get(int n)method? I didn't use