import javax.swing.JOptionPane;


public class Multithread {
	static int n;
	static int[] divisors = new int[n];
	static int i;
	
	public static void main(String[] args){
		
		Multithread myMt= new Multithread();
		myMt.doIt();
		
		
		
	}
	
	public void doIt(){
		n=Integer.parseInt(JOptionPane.showInputDialog("How Many?"));
		divisors= new int[n+1];
		findDivisors fd = new findDivisors();
		System.out.println("Starting the task");
		fd.start();//start creates a separate thread, which makes the processes run asynchronously
		int pDone=0;
		do{
			int newPdone=(i*100)/n;
			if(newPdone!=pDone){
				pDone=newPdone;
				System.out.println(pDone + "%");
			}
			//System.out.println("i= " + i);
		}while(i<n);
		//System.out.println("Divisors calculated " + n);
		for(int j=1; j<n; j++){
			System.out.println(divisors[j] + " divisors of " + j);
		}
	}
	private class findDivisors extends Thread{
		public void run(){
			for (i=1; i<= n; i++){
				int nd = 0;
				for (int k=1; k<=i; k++){
					if (i%k == 0) nd++;
				}
				divisors[i] = nd;
			}
		}
	}

}
