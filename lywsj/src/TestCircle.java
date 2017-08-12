
interface Shape {
	double getArea();
}
class Circle implements Shape{
	int r;
	public Circle(int r){
		this.r=r;
	}
	public double getArea() {
		return 3.14*r*r;
	}
	
}
public class TestCircle {

	public static void main(String[] args) {
		Circle a=new Circle(5);
		System.out.println("该圆的面积为"+a.getArea());
		// TODO Auto-generated method stub

	}

}
