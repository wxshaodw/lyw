package ex_t;
class FatherClass{
public FatherClass(){
System.out.println("FatherClass Create");
}
}
public class ChildClass extends FatherClass{
public ChildClass(){
	System.out.println("ChildClass Create");
}
public static void main(String[]args){
FatherClass fc=new FatherClass();
ChildClass cc=new ChildClass();
}
}
