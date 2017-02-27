package s05;
interface Shape{
	double Size();
}
class line implements Shape{
	int x1;
	int y1;
	int x2;
	int y2;
	public line(int x1,int y1,int x2,int y2){
		this.x1=x1;
		this.y1=y1;
		this.x2=x2;
		this.y2=y2;
	}
	public double Size() {
		return(Math.sqrt(x1-x2)*(x1-x2)+(y1-y2)*(y1-y2));
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
		int i;
		double[] size=new double[5]	;
		line l=new line(1,2,1,3);
		Trangle t=new Trangle(3,4,5);
		Circle c=new Circle(3);
		rectangle r=new rectangle(3,4);
		size[0]=l.Size();
		size[1]=t.Size();
		size[2]=c.Size();
		size[3]=r.Size();
		for(i=0;i<4;i++){
			System.out.println(""+size[i]);
		}
		
		// TODO Auto-generated method stub

	}

}
