package lyw;

public class exchange {
	int a;
	int b;
	public static void ex(exchange x){
		int t;
		t=x.a;
		x.a=x.b;
		x.b=t;
	}

	public static void main(String[] args) {
		exchange a=new exchange();
		a.a=10;
		a.b=5;
		ex(a);
		System.out.println(""+a.a);
		System.out.println(""+a.b);
		// TODO Auto-generated method stub

	}

}
