package s6;

public class Outer {
	String name;
	int i;
	public Outer(){
		this.name="Outer";
		this.i=20;
	}
	class Inner{
		String name;
		int i;
		public Inner(){
			this.name="Inner";
			this.i=10;
		}
		public void printInfo(){
			System.out.println(""+Outer.this.name);
			System.out.println(""+Outer.this.i);
			System.out.println(""+this.name);
			System.out.println(""+this.i);
		}
	}
	
	public static void main(String[] args) {
		Outer A=new Outer();
		Inner B= A.new Inner();
		B.printInfo();
		// TODO Auto-generated method stub

	}

}
