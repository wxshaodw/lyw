package s6;

public class TestOut {

	public static void main(String[] args) {
		int a[]={20,10,50,40,30,70,60,80,100};
		int i,j,t;
		for(i=0;i<9-1;i++){
			for(j=0;j<9-1-i;j++){
				if(a[j]>a[j+1]){
					t=a[j];
					a[j]=a[j+1];
					a[j+1]=t;
				}
			}
		}
		for(i=0;i<9;i++){
			System.out.println(""+a[i]);
		}
		// TODO Auto-generated method stub

	}

}
