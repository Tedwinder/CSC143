
public class GenericFollowAlong {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
System.out.println("GenericFollowAlong by Ted Callow");
Crow whiteTail = new Crow("White Tail", 200);
Crow crow2 = new Crow("somebody", 292);
Crow [] flock = new Crow[5];
flock[0] = whiteTail;
flock[1] = crow2;
flock[2] = new Crow("Joe", 299);
flock[3] = new Crow("Dizzy",303);
flock[4] = new Crow("James", 343);
print(flock,"before sorting");
sort(flock);
print(flock,"after sorting");

	}
	private static void sort(Crow[] x){
		for(int pivot=0;pivot<(x.length-1); pivot++){
			int locOfBiggest=pivot;
			for(int test=pivot+1;test<x.length;test++){
				if (x[test].compareTo(x[locOfBiggest+1]) >0){
					locOfBiggest=test;
				}
			}swap(x,pivot,locOfBiggest);
		}
	}

	private static void print(Crow[] x, String header){
			System.out.println("\n Flock: " + header);
					for (int i=0; i<x.length; i++){
					 System.out.println(" flock[" + i + "] = " +x[i]);
		}
}

		private static void swap(Crow[] x,int i,int j){
			Crow temp;
			temp = x[i];
			x[i]=x[j];
			x[j]=temp;
		}
}
