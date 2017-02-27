package s12;
public class gtrun extends Thread{
	int g=0,t=0;
	public void run(){
		while(!(g==300)){
			g+=30;
			t+=100;
			System.out.println("兔子在"+t+"米");
			System.out.println("乌龟在"+g+"米");
		}
	}
	public static void main(String[] args) {
		gtrun a= new gtrun();
		a.run();
		// TODO Auto-generated method stub

	}

}
