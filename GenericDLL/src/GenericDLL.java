//Generic DLL by Ted Callow



public class GenericDLL <T  extends Comparable<T>> implements Listy{
//public class GenericDLL implements Listy, Comparable {

	private Node head;
	private Node tail;
	
	
public GenericDLL (String name){
	
	head = null;
	tail = null;
}
	
public class Node {
	Object per;
	Node next;
	Node prev;
}
	
	@Override
	public void add(Object o) {
		// TODO Auto-generated method stub
		 
		if(head==null){
			head = new Node();
			head.per=o;
			head.next=null;
			
		}else {
			Node runner = head;
			while(runner.next!=null){
				runner = runner.next;
			}
		Node tail= new Node();
		tail.per=o;
		tail.next=null;
		tail.prev=runner;
		runner.next=tail;
		}
	}

	@Override
	public void add(Object[] o) {
		// TODO Auto-generated method stub
		Node runner = head;
		for(int i=0;i<o.length;i++){
			add(o[i]);
			runner=runner.next;	
		}
	}

	@Override
	public int size() {//not clear what this method is supposed to do exactly
		// TODO Auto-generated method stub
		int i=0;
		Node runner=head;
		while (runner!=null){
			i++;
			runner=runner.next;
		}
		return i;
	}

	@Override
	public Object get(int n) throws ListOutOfBounds {
		// TODO Auto-generated method stub
		if (n>size()){throw new ListOutOfBounds("List Out of Bounds: " + n);}
		Node runner = head;
		for(int i=0;i<n;i++){
			runner=runner.next;	
		}
		//System.out.println(runner.per);
		return runner.per;
	}
	
	public Object getPrev(Object o) {
		// TODO Auto-generated method stub
		
		Node runner = head;
		for(int i=0;i<size();i++){
			runner=runner.next;	
			if(runner.per==o){
				return runner.prev.per;
			}
		}return runner.prev.per;
	}
	
	public void replace(Object toReplace, Object rePlacement) {
		Node runner=head;
		if (locOf(toReplace)==-1){
			throw new MissingFromList("Missing From List: " + toReplace);}
		while (runner !=null){
			if(runner.per==toReplace){
				if(runner==tail){
					tail.per=rePlacement;
				}else if(runner==head){
					head.per=rePlacement;
				}else{
				Node guyAfter= runner.next;
				Node guyBefore=runner;
				Node newNode=new Node();
				newNode=runner;
				newNode.prev=guyBefore;
				newNode.next=guyAfter;
				newNode.per=rePlacement;
				}
			}runner=runner.next;
		}
	}
	
	@Override
	public void insertAfter(Object afterMe, Object toInsert) 
			throws MissingFromList {
		// TODO Auto-generated method stub
		Node runner = head;
		boolean inserted= false;
		if (locOf(afterMe)==-1){
			throw new MissingFromList("Missing From List: " + afterMe);}
		while (runner !=null && !inserted){
			if(runner.per==afterMe){
				if (runner.next==null){//if the next item in the list is the tail
					add(toInsert);
				}else{//next is not the tail	
				Node after = runner.next;
				Node newNode = new Node();
				after.prev=newNode;
				newNode.next = after;	
				newNode.prev = runner;
				runner.next = newNode;
				newNode.per = toInsert;
				inserted=true;
				
				}
			}
			runner=runner.next;	
		}
	}

	@Override
	public void insertAfter(int afterMe, Object[] toInsert) throws ListOutOfBounds {
		// TODO Auto-generated method stub
		if (afterMe>size()){throw new ListOutOfBounds("List Out of Bounds: " + afterMe);}
		Node runner = head;
		Object[] o = toInsert;
		for(int i=0;i<afterMe;i++){
			runner=runner.next;	
		}
		insertAfter(runner.per, o);
	}

	@Override
	public void insertAfter(Object afterMe, Object[] toInsert) throws MissingFromList {
		// TODO Auto-generated method stub
		Node runner = head;
		int count=0;
		if (locOf(afterMe)==-1){
			throw new MissingFromList("Missing From List: " + afterMe);}
			while (runner !=null){
					if(runner.per==afterMe){
						insertAfter(count,toInsert[0]);
						for(int j=0;j<toInsert.length-1;j++){
						insertAfter(toInsert[j],toInsert[j+1]);
					}
					//break;
				} runner=runner.next; count++;	
		}  	
	}

	@Override
	public void insertAfter(int afterMe, Object toInsert) throws ListOutOfBounds {
		if (afterMe>size()){throw new ListOutOfBounds("List Out of Bounds: " + afterMe);}
		Node runner = head;
		for(int i=0;i<afterMe;i++){
			runner=runner.next;	
		}
		insertAfter(runner.per,toInsert);
	}

	@Override
	public void insertBefore(Object beforeMe, Object toInsert) throws MissingFromList{
		boolean inserted = false;
		Node runner = head;
		if (locOf(beforeMe)==-1){
			throw new MissingFromList("Missing From List: " + beforeMe);}
		
		
		while (runner !=null && inserted==false){
			if(runner.per==beforeMe){			
				if (runner == head) {//to insert before position 0
					Node newNode = new Node();
					newNode.next = runner;
					runner.prev = newNode;
					newNode.per = toInsert;
					inserted = true;
					head = newNode;

				}else {//to insert after position 0
					Node before = runner.prev;
					Node newNode = new Node();
					before.next = newNode;
					newNode.next = runner;
					newNode.prev = runner.prev;
					newNode.per = toInsert;
					runner.prev = newNode;
					inserted = true;
				}
			}
			runner=runner.next;
		}	
	}

	@Override
	public void insertBefore(int beforeMe, Object[] toInsert) throws ListOutOfBounds {
		// TODO Auto-generated method stub
		if (beforeMe>size()){throw new ListOutOfBounds("List Out of Bounds: " + beforeMe);}
		Node runner = head;
		Object[] o = toInsert; 
		for(int i=0;i<beforeMe;i++){
			runner=runner.next;	
		}
		insertBefore(runner.per, o);
	}
	
	@Override
	public void insertBefore(Object beforeMe, Object[] toInsert) throws MissingFromList {
		// TODO Auto-generated method stub
		Node runner = head;
		if (locOf(beforeMe)==-1){
			throw new MissingFromList("Missing From List: " + beforeMe);}
		while (runner !=null){
					if(runner.per==beforeMe){
						int end= toInsert.length-1;
						insertBefore(beforeMe,toInsert[end]);
						for(int j=end;j>0;j--){
						insertBefore(toInsert[j],toInsert[j-1]);
						}break;
					}runner=runner.next; 
				} 	
		}  	
	
	@Override
	public void insertBefore(int beforeMe, Object toInsert) throws ListOutOfBounds {
		// TODO Auto-generated method stub
		if (beforeMe>size()){throw new ListOutOfBounds("List Out of Bounds: " + beforeMe);}
		Node runner = head;
		for(int i=0;i<beforeMe;i++){
			runner=runner.next;	
		}
		insertBefore(runner.per,toInsert);
	}
		
//	public void delete(Object[] objToDelete){
//		for (int i=0;i<objToDelete.length;i++){
//			int location= locOf(objToDelete[i]);
//			delete(location);	                                  
//			} 	
//		}   	
//	

	@Override
	public boolean delete(Object objToDelete) {
		// TODO Auto-generated method stub
		Node runner = head;
		if (runner.next==null && runner.per!=objToDelete){
			throw new MissingFromList("Missing From List: " + objToDelete);}
		
		while (runner !=null){	
			if(runner==head && runner.per==objToDelete){//to delete first
				runner=runner.next;
				head=runner;
				head.prev=null;
			}else if(runner.next==null && runner.per==objToDelete){//to delete last
				runner=runner.prev;
				runner.next=null;
				return true;
			}else
			 if(runner.per==objToDelete){//to delete middle
					Node guyBefore=runner.prev;
					guyBefore.next=runner.next;
					runner.prev=guyBefore;
					runner=runner.next;
					return true;
				}else
			runner=runner.next;
		}
		return false;	
	}
	
	@Override
	public boolean delete (int indexToDelete){ // returns true if it succeeds 
		// TODO Auto-generated method stub

		if (indexToDelete>size())
		{throw new ListOutOfBounds("List Out of Bounds: " + indexToDelete);}
		Node runner = head;
		for(int i=0;i<indexToDelete;i++){
		runner=runner.next;
		}
		delete(runner.per);
		return true;
	}
	


	@Override
	public Object[] toArray(){
		
		String[] r = new String[size()];
		Node runner=head;
		for(int i=0;i<size();i++){
			r[i] = (String)get(i);
			runner=runner.next;
			//System.out.println(r[i]);
		}
		return r;
	}
	
	
	public String[] toArrayString(){
		
		String[] r = new String[size()];
		Node runner=head;
		for(int i=0;i<size();i++){
			r[i] = (String)get(i);
			runner=runner.next;
			//System.out.println(r[i]);
		}
		return r;
	}

	@Override
	public int locOf(Object toFind){//return -1 if not found
		int i=0;
		Node runner=head;
		while(runner!=null){
			if(runner.per==toFind){
			return i;
			}else{
				i++;		
			}runner=runner.next;
		}return -1;
	}
	//@Override
//	public void print(String label) {
//		// TODO Auto-generated method stub
//		System.out.println(label);
//		Node runner = head;
//		int i=0;
//		while(runner!=null){	
//			System.out.println("List Position " + i + ": " + runner.per);
//			runner=runner.next;
//			i++;
//		}		
//	}



	
	public void deleteLL(){
		Object[] o= toArray();
		for (int k=0; k<o.length-1; k++){//delete linked list
			delete(0);}
		head=null;
		//if (size()==0){System.out.println("sucessfully deleted");}	
	}
	
	public void recreateLL(Object[] o){
		
		for (int k=0; k<o.length; k++){
			add(o[k]);}	
	}
	
	public void sort(){
		Object[] o= toArray();//create array
		deleteLL();//delete LL
		for(int pivot=0;pivot<o.length-1; pivot++){
			int locOfBiggest=pivot;
			for(int test=pivot+1;test<o.length; test++){
			if (((String)o[test]).compareTo((String)o[locOfBiggest])<0){
					locOfBiggest=test;
			}
		}swap(o,locOfBiggest,pivot);
		}recreateLL(o);//recreates DLL from the array
		
	}

	
	private void swap(Object[] o,int i,int j){
		  	
		Object temp = o[i];
		o[i]=o[j];
		o[j]=temp;	
	}
	
	public void print(String label) {
		System.out.println(toString(label));
		}

	public String toString(String label) {
		return label + "\n" + toString() + "\n";
	}

		public String toString() {

		int i = 0;
		String list = "";
		Node runner = head;

		while (runner != null) {
			list += "List Position " + i + ": " + runner.per + "\n";
			runner=runner.next;
			i++;
		}
		return list;
		}
		
		public void quickSort(){
			String[] a=toArrayString();
			int start=0;
			int end=size()-1;
			
			quickSort(a,start,end);
		}
			
		public void quickSort(String[]a,int start, int end)
		{	
		        // index for the "left-to-right scan"
		        int i = start;
		        // index for the "right-to-left scan"
		        int j = end;

		        // only examine arrays of 2 or more elements.
		        if (j - i >= 1)
		        {
		            // The pivot point of the sort method is arbitrarily set to the first element int the array.
		            String pivot = a[i];
		            // only scan between the two indexes, until they meet.
		            while (j > i)
		            {
		           
		                while (a[i].compareTo(pivot) <= 0 && i < end && j > i){
		                    i++;
		                }
		             
		                while (a[j].compareTo(pivot) >= 0 && j > start && j >= i){
		                    j--;
		                }
		                if (j > i)
		                    swap(a, i, j);
		            }
		            swap(a, start, j);
		            // sort left partition
		         
		            quickSort(a, start, j - 1);
		            // sort right partition
		            quickSort(a, j + 1, end);
		        }deleteLL();recreateLL(a); 
		    }
		}				

