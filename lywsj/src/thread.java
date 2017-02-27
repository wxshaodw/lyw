
public class thread extends Thread {
int lc=0;
int gc=0;
public void run(){
	while(this.gc<300){
		if(this.lc<300){
			System.out.println(this.getName()+"兔子已到"+this.lc);
			this.lc+=100;
		}
		System.out.println(this.getName()+"乌龟已到"+this.gc);
		this.gc+=30;
	}
}
static public void main(String args[]){
	thread t1=new thread();
	t1.start();
}
}