package student;

public class Student {
	private String firstname;
	private String lastname;
	private int grade;
	
	public Student(){
	}
	
	public String getFirstname(){
		return firstname;
	}
	
	public void setFirstname(String firstname){
		this.firstname = firstname;
	}
	
	public String getLastname(){
		return lastname;
	}
	
	public void setLastname(String lastname){
		this.lastname = lastname;
	}
	
	public int getGrade(){
		return grade;
	}
	
	public void setGrade(int grade){
		this.grade = grade;
	}
	
	@Override
	public String toString(){
		return this.firstname + " " + this.lastname + ": " + this.grade;
	}
}
