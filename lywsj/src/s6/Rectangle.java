package s6;

public class Rectangle {
	double x;
	double y;
	double Area;
	public Rectangle(double x,double y){
		this.x=x;
		this.y=y;
		this.Area=x*y;
	}
	public Rectangle(){};
	public static void main(String[] args) {
		int i,j,k;
		double xs[]={1,9,3,5,6}; 
		double ys[]={10,11,4,7,13}; 
		Rectangle rects[]=new Rectangle[25];
		
		for(i=0,k=0;i<xs.length;i++){
			for(j=0;j<ys.length;j++,k++){
				rects[k]=new Rectangle(xs[i],ys[j]);
			}
		}
		Rectangle T=new Rectangle();
		for(i=0;i<rects.length-1;i++){
			for(j=0;j<rects.length-1-i;j++){
				if(rects[j].Area>rects[j+1].Area){
					T=rects[j];
					rects[j]=rects[j+1];
					rects[j+1]=T;
				}
			}
		}
		for(k=0;k<rects.length;k++){
			System.out.println(""+rects[k].Area);
		}// TODO Auto-generated method stub
	}

}
