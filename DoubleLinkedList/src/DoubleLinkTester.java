
//DoubleLinkedList by Ted Callow
public class DoubleLinkTester {
public static void main(String[] args) throws ListOutOfBounds,
MissingFromList {
DLL l = new DLL("First guy in line");
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

System.out.println("size is now: " + l.size());

//end of Straayer's test
}
}