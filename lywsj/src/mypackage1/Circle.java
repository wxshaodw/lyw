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
		System.out.println("该园的半径为"+getRadius());
		System.out.println("该园的周长为"+getPerimeter());
		System.out.println("该园的面积为"+getArea());
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
		System.out.println("该园柱的半径为"+getRadius());
		System.out.println("该园柱的周长为"+getPerimeter());
		System.out.println("该圆柱的体积为"+getVol());
	}
	
}