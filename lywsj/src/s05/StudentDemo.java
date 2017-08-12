package s05;
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
		Undergraduate Stu1=new Undergraduate("小明",20,"201435020225",40,50,60);
		Graduate Stu2=new Graduate("小李",20,"201435020230",90,92,91);
		System.out.println("姓名；"+Stu1.name);
		System.out.println("年龄："+Stu1.age);
		System.out.println("学号；"+Stu1.Id);
		System.out.println("科目1成绩；"+Stu1.grade1);
		System.out.println("科目2成绩；"+Stu1.grade2);
		System.out.println("科目3成绩；"+Stu1.grade3);
		System.out.println("学位证书情况；"+Stu1.test());
		System.out.println("姓名；"+Stu2.name);
		System.out.println("年龄："+Stu2.age);
		System.out.println("学号；"+Stu2.Id);
		System.out.println("科目1成绩；"+Stu2.grade1);
		System.out.println("科目2成绩；"+Stu2.grade2);
		System.out.println("科目3成绩；"+Stu2.grade3);
		System.out.println("学位证书情况；"+Stu2.test());
		// TODO Auto-generated method stub

	}

}
