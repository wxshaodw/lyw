package s6;

class Matrix{
	int data[][];
	public Matrix(int data[][]){
		this.data=data;
		}
	public Matrix(){}
}
public class TestMatrix {
	public static void main(String[] args) {
		int i,j,k,t=0;
		int data_a[][]={{1,2,3},{4,5,6},{1,2,3}};
		int data_b[][]={{9,8,7,1},{6,5,4,1},{3,2,1,1}};
		Matrix a=new Matrix(data_a);
		Matrix b=new Matrix(data_b);
		Matrix c=new Matrix();
		c.data=new int[a.data.length][b.data[0].length];
		for(i=0;i<a.data.length;i++){
			for(j=0;j<b.data[0].length;j++){
				for(k=0;k<b.data.length;k++){
					t=t+(a.data[i][k]*b.data[k][i]);
				}
				c.data[i][j]=t;
			}
		}
		for(i=0;i<c.data.length;i++){
			for(j=0;j<c.data[0].length;j++){
				System.out.print(""+c.data[i][j]);
				System.out.print(" ");
				}
			System.out.println("");
		}
		// TODO Auto-generated method stub

	}

}
