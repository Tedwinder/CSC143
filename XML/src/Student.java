
public class Student {//remember if adding a constructor 

	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double[] getGrades() {
		return grades;
	}
	public void setGrades(double[] grades) {
		this.grades = grades;
	}
	public long getSid() {
		return sid;
	}
	public void setSid(long sid) {
		this.sid = sid;
	}
	String name;
	double[] grades;
	long sid;
	public Student(String name, long sid){
		this.name=name;
		this.sid=sid;
	}
	public Student(){
		
	
	}
	
}
