package s12;
public class gtrun extends Thread{
	int g=0,t=0;
	public void run(){
		while(!(g==300)){
			g+=30;
			t+=100;
			System.out.println("������"+t+"��");
			System.out.println("�ڹ���"+g+"��");
		}
	}
	public static void main(String[] args) {
		gtrun a= new gtrun();
		a.run();
		// TODO Auto-generated method stub

	}

}
