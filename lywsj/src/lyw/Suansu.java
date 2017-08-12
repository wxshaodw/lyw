package lyw;

public class Suansu {
	int a;
	int b;
	public Suansu(int x,int y){
		a=x;
		b=y;
	}
	public int AddAB(int a,int b){
		int r;
		r=a+b;
		return(r);
	}
	public int SubAB(int a,int b){
		int r;
		r=a-b;
		return(r);
	}
	public int MultiAB(int a,int b){
		int r;
		r=a*b;
		return(r);
	}
	public int DivAB(int a,int b){
		int r;
		r=a/b;
		return(r);
	}
	public static void main(String[] args) {
		Suansu u=new Suansu(10,5);
		System.out.println("a+b="+u.AddAB(u.a,u.b));
		System.out.println("a-b="+u.SubAB(u.a,u.b));
		System.out.println("a*b="+u.MultiAB(u.a,u.b));
		System.out.println("a/b="+u.DivAB(u.a,u.b));
	}

}
