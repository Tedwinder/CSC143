//class buffering/flushing example 7/19/16
import java.io.FileWriter;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileOutputStream;

import javax.swing.JFileChooser;

public class Streams {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
JFileChooser jfc = new JFileChooser();
//jfc.showSaveDialog(parent);
int theCode=jfc.showSaveDialog(null);
File theFile=jfc.getSelectedFile();

if (theCode != JFileChooser.APPROVE_OPTION) System.exit(1);

try{
	//FileWriter fw = new FileWriter(theFile);
	FileOutputStream fw = new FileOutputStream (theFile);
	DataOutputStream dos= new DataOutputStream(fw);
	ObjectOutputStream obj = new ObjectOutputStream(dos);//double check this
	dos.writeInt(65);
	dos.writeShort(65);
	dos.writeByte(65);
	HumanBean me= new HumanBean();
	me.name="Ted";
	me.height=73;
	me.numOfSiblings=1;
	obj.writeObject(obj);
	
	fw.write(65);
	
	PrintWriter pw = new PrintWriter(fw);
	pw.print("The quick brown fox. . . ");
}catch (Exception e){
	e.printStackTrace();
	
}

	}

}
