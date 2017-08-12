package s12;
class runing implements Runnable{
	private int  road_a=0;
	private int  road_b=0;
	@Override
	public void run() {
		while(Thread.currentThread().getName().equals("ÍÃ×Ó")&&this.road_a<=300){
			System.out.println(Thread.currentThread().getName()+this.road_a);
			this.road_a=this.road_a+100;
		}
		while(Thread.currentThread().getName().equals("ÎÚ¹ê")&&this.road_b<=300){
			System.out.println(Thread.currentThread().getName()+this.road_b);
			this.road_b=this.road_b+30;
		}
		// TODO Auto-generated method stub
	}
	
}
public class run {
	public static void main(String[] args) {
		runing r1=new runing();
		runing r2=new runing();
		Thread r1s=new Thread(r1);
		Thread r2s=new Thread(r2);
		r1s.setName("ÍÃ×Ó");
		r2s.setName("ÎÚ¹ê");
		r1s.start();
		r2s.start();
		// TODO Auto-generated method stub

	}

}
