package lyw;

public class Student {
	private String name;
	private int age;
	public Student(){
		name="ÎŞÃûÊÏ";
		age=20;
	}
	public void setname(String name){
		this.name=name;
	}
	public void setname(int age){
		this.age=age;
	}
	public String getname(){
		return(name);
	}
	public int getage(){
		return(age);
	}
	public String issameage(Student s){
		if(this.age==s.age)return("ture");
		else return("false");
	}
	public static void main(String[] args) {
		Student s1=new Student();
		Student s2=new Student();
		System.out.println(""+s1.getname());
		System.out.println(""+s1.getage());
		s2.setname("ÁºìÇÎÄ");
		s2.setname(20);
		System.out.println(""+s2.getname());
		System.out.println(""+s2.getage());
		System.out.println(""+s1.issameage(s2));
		s2.setname(10);
		System.out.println(""+s2.getage());
		System.out.println(""+s1.issameage(s2));
	}

}
