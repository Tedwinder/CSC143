
public class Crow {

	String name = "";
	int weight = 0;
	public Crow(String name, int weight) {
		this.name=name;
		this.weight=weight;
		// TODO Auto-generated constructor stub
	}
	
	public String toString(){
		return "Crow, name= " + this.name+ ", weight= "
+ this.weight + " grams";
		
			}
	public int compareTo(Crow other) {
		return this.name.compareTo(other.name);
		//return ((int)(this.weight-other.weight));
		
	}
}
