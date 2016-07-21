import java.util.ArrayList;
import javax.swing.JFileChooser;
import java.beans.XMLEncoder;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

public class XMLSave {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
Student a = new Student("Dave", 111);
double[] asgrades={56,56,56,88,88,99};
a.grades=asgrades;
Student b = new Student("Will",777);
double[] bsgrades={56,556,99,56,88,88,99};
b.grades=bsgrades;
ArrayList<Student> myData= new ArrayList<Student>();
myData.add(a);
myData.add(b);
JFileChooser jfc = new JFileChooser();
int user = jfc.showSaveDialog(null);
if (user !=JFileChooser.APPROVE_OPTION) System.exit(1);
String f = jfc.getSelectedFile().getAbsolutePath();
try{
	FileOutputStream fos = new FileOutputStream(f);
	XMLEncoder encoder = new XMLEncoder(fos);
	encoder.writeObject(myData);
	encoder.close();
	System.out.println("That's all folks");
}catch (FileNotFoundException e){
	e.printStackTrace();
	}
}

}
