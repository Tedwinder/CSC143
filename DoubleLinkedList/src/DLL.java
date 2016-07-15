//DoubleLinkedList by Ted Callow

public class DLL implements Listy {
	
	private Node head;
	private Node tail;
	
	
public DLL (String name){
	
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

	@Override
	public void insertAfter(Object afterMe, Object toInsert) 
			throws MissingFromList {
		// TODO Auto-generated method stub
		Node runner = head;
		boolean inserted= false;
		if (runner.next==null && runner.per!=afterMe){
			throw new MissingFromList("Missing From List: " + afterMe);}
		
		while (runner !=null && !inserted){
			if(runner.per==afterMe){
				Node guyAfter= runner.next;
				Node guyBefore=runner;
				Node newNode=new Node();
				runner=runner.next;
				runner=newNode;
				runner.next=guyAfter;
				runner.prev=guyBefore;
				runner.per=toInsert;
				inserted=true;
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
		if (runner.next==null && runner.per!=afterMe){
			throw new MissingFromList("Missing From List: " + afterMe);}
		while (runner !=null){
					if(runner.per==afterMe){
						insertAfter(afterMe,toInsert[0]);
						for(int j=0;j<toInsert.length-1;j++){
						insertAfter(toInsert[j],toInsert[j+1]);
					}break;
				} runner=runner.next; 	
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

		while (runner !=null){
			if(runner.per==beforeMe){			
				if (runner == head) {
					Node newNode = new Node();
					newNode.next = runner;
					runner.prev = newNode;
					newNode.per = toInsert;
					inserted = true;
		
					head = newNode;

				}else {
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
		if (inserted == false)throw new MissingFromList("insertBefore obj,obj");
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
		if (runner.next==null && runner.per!=beforeMe){
			throw new MissingFromList("Missing From List: " + beforeMe);}
		while (runner !=null){
					if(runner.per==beforeMe){
						insertBefore(beforeMe,toInsert[0]);
						for(int j=0;j<toInsert.length-1;j++){
						insertAfter(toInsert[j],toInsert[j+1]);
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
		for(int i=0;i<size()-1;i++){
			r[i] = (String)get(i);
			runner=runner.next;
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
	@Override
	public void print(String label) {
		// TODO Auto-generated method stub
		System.out.println(label);
		Node runner = head;
		int i=0;
		while(runner!=null){	
			System.out.println("List Position " + i + ": " + runner.per);
			runner=runner.next;
			i++;
		}		
	}
	
}//end class DLL
