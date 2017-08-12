
interface Shape{
	double Size();
}
class line implements Shape{
	int x;
	int y;
	public line(int x,int y){
		this.x=x;
		this.y=y;
	}
	public double Size() {
		line p1=new line(1,2);
		line p2=new line(1,3);
		return(Math.sqrt(p1.x-p2.x)*(p1.x-p2.x)+(p1.y-p2.y)*(p1.y-p2.y));
	}
}
class Trangle implements Shape{
	int sideA;
	int sideB;
	int sideC;
	public Trangle(int sideA,int sideB,int sideC){
		this.sideA=sideA;
		this.sideB=sideB;
		this.sideC=sideC;
	}
	public double Size() {
		double p=(sideA+sideB+sideC)/2.0;
		return Math.sqrt(p*(p-sideA)*(p-sideB)*(p-sideC));
	}
}
class Circle implements Shape{
	int r;
	public Circle(int r){
		this.r=r;
	}
	public double Size() {
		return 3.14*r*r;
	}
}
class rectangle implements Shape{
	int x;
	int y;
	public rectangle(int x,int y){
		this.x=x;
		this.y=y;
	}
	public double Size() {
		return x*y;
	}
}
public class ShapeArea {

	public static void main(String[] args) {
		String shape[];
		// TODO Auto-generated method stub

	}

}
