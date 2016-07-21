import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XMLRead {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try{
	
		ArrayList<Student> myData= new ArrayList<Student>();
		FileInputStream fis= new FileInputStream("C:\\Users\\ECallow18310\\Documents");
		XMLDecoder decoder = new XMLDecoder(fis);
		myData=(ArrayList<Student>) decoder.readObject();
	
		System.out.println("how many students: " + myData.size());
	
	}catch(FileNotFoundException e)
	{
		e.printStackTrace();	
	}
	}
}
