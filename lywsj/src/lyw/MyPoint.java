package lyw;

public class MyPoint {
	private int x;
	private int y;
	public MyPoint(){
		x=0;
		y=0;
	}
	public MyPoint(int x,int y){
		this.x=x;
		this.y=y;
	}
	public static  float getD(MyPoint a,MyPoint b){
		float d;
		d=(float)Math.sqrt((a.x-b.x)*(a.x-b.x)+(a.y-b.y)*(a.y-b.y));
		return(d);
	}
	public static void main(String[] args) {
		MyPoint p1=new MyPoint();
		MyPoint p2=new MyPoint(4,5);
		p1.x=2;
		p1.y=3;
		System.out.println("p1(2,3)µ½p2(4,5)µÄ¾àÀëÎª:"+getD(p1,p2));
		// TODO Auto-generated method stub
	}
}
