package s7;

public class change_Str {
	String x[]={"zero","one","two", "three","four", "five","six","seven","eight","nine"} ;
	String y[]={"ten","eleven","twelve","thirteen","fourteen","fifteen","sixteen","seventeen","eighteen","nineteen" };
	String z[]={"twenty","thirty","fourty","fifty", "sixty","seventy", "eighty","ninety" }; 
	public String chang_Number(int s1){
		String data = null,g,s;
		if(s1>20&&s1<100){
			if(s1%10==0)data=s=z[s1/10];
			else{
				g=x[(s1%10)];
				s=z[(s1/10)-2];
				data=s+" "+g;
			}
		}
		else{
			if(s1>=0&&s1<10){
				data=x[s1];
			}
			else{
				data=y[s1%10];
			}
		}
		return data;
	}

	public static void main(String[] args) {
		change_Str c1= new change_Str();
		System.out.println(""+c1.chang_Number(1));
		System.out.println(""+c1.chang_Number(10));
		System.out.println(""+c1.chang_Number(51));
		// TODO Auto-generated method stub
	}
}
