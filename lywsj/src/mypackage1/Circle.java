package mypackage1;

public class Circle {
	double radius;
	public Circle(){
		radius=0;
	}
	public Circle(double r){
		radius=r;
	}
	double  getRadius(){
		return(radius);
	}
	double getPerimeter(){
		return(3.14*2*radius);
	}
	double getArea() {
		return(3.14*radius*radius);
	}
	void disp(){
		System.out.println("��԰�İ뾶Ϊ"+getRadius());
		System.out.println("��԰���ܳ�Ϊ"+getPerimeter());
		System.out.println("��԰�����Ϊ"+getArea());
	}
	public static void main(String[] args) {
		Circle a;
		a=new Circle(1);
		a.disp();
		Cylinder b;
		b=new Cylinder(1,2);
		b.dispVol();
	}

}
class  Cylinder extends Circle{
	double height;
	public Cylinder(double r,double h ){
		radius=r;
		height=h;
	}
	double getHeight(){
		return(height);
	}
	double getVol(){
		return(getArea()*height);
	}
	void dispVol(){
		System.out.println("��԰���İ뾶Ϊ"+getRadius());
		System.out.println("��԰�����ܳ�Ϊ"+getPerimeter());
		System.out.println("��Բ�������Ϊ"+getVol());
	}
	
}