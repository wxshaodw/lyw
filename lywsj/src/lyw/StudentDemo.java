
class Student{
	String name;
	int age;
	String Id;
	int grade1;
	int grade2;
	int grade3;
}
class Undergraduate extends Student{
	public Undergraduate(){
		super();
	}
	public Undergraduate(String name,int age,String Id,int grade1,int grade2,int grade3){
		this.name=name;
		this.age=age;
		this.Id=Id;
		this.grade1=grade1;
		this.grade2=grade2;
		this.grade3=grade3;
	}
	public String test(){
		if(grade1>60&&grade2>60&&grade3>60)return "get";
		else return("lost");
	}
}
class Graduate extends Student{
	public Graduate(){
		super();
	}
	public Graduate(String name,int age,String Id,int grade1,int grade2,int grade3){
		this.name=name;
		this.age=age;
		this.Id=Id;
		this.grade1=grade1;
		this.grade2=grade2;
		this.grade3=grade3;
	}
	public String test(){
		if(grade1>80&&grade2>80&&grade3>80)return "get";
		else return("lost");
	}
}
public class StudentDemo {
	public static void main(String[] args) {
		Undergraduate Stu1=new Undergraduate("С��",20,"201435020225",40,50,60);
		Graduate Stu2=new Graduate("С��",20,"201435020230",90,92,91);
		System.out.println("������"+Stu1.name);
		System.out.println("���䣺"+Stu1.age);
		System.out.println("ѧ�ţ�"+Stu1.Id);
		System.out.println("��Ŀ1�ɼ���"+Stu1.grade1);
		System.out.println("��Ŀ2�ɼ���"+Stu1.grade2);
		System.out.println("��Ŀ3�ɼ���"+Stu1.grade3);
		System.out.println("ѧλ֤�������"+Stu1.test());
		System.out.println("������"+Stu2.name);
		System.out.println("���䣺"+Stu2.age);
		System.out.println("ѧ�ţ�"+Stu2.Id);
		System.out.println("��Ŀ1�ɼ���"+Stu2.grade1);
		System.out.println("��Ŀ2�ɼ���"+Stu2.grade2);
		System.out.println("��Ŀ3�ɼ���"+Stu2.grade3);
		System.out.println("ѧλ֤�������"+Stu2.test());
		// TODO Auto-generated method stub

	}

}
