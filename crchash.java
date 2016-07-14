
package hashing;
import javax.swing.JOptionPane;
public class hashing {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String it =JOptionPane.showInputDialog("Enter a string");
		int theHash= hash(it);
		System.out.println("the hash is " + theHash);
	}
private static int hash(String x){
	int retval=0;
	byte[] b= x.getBytes();
	for (int i=0; i<b.length; i++){
		retval +=b[i]<<i;}
	return retval;
}
}
