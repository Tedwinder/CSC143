import java.beans.XMLDecoder;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;

public class XMLRead {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
	try{
	
		ArrayList<Student> myData= new ArrayList<Student>();
		FileInputStream fis= new FileInputStream("/Users/tedcu76/Documents/test1.xml");
		XMLDecoder decoder = new XMLDecoder(fis);
		myData=(ArrayList<Student>) decoder.readObject();
	
		System.out.println("how many students: " + myData.size());
		for (int i=0;i<myData.size();i++){
			System.out.println("name:  " + myData.get(i).getName());
		}
		
		decoder.close();
	}catch(FileNotFoundException e)
	{
		e.printStackTrace();	
	}
	}
}
