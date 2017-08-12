import java.util.Scanner;;
public class ae {
	String str;
	public void chaeak(){
		int i,s1=0,s2=0,s3=0;
		char ch;
		Scanner in =new Scanner(System.in);
		this.str=in.nextLine();
		for(i=0;i<str.length();i++){
			ch=str.charAt(i);
			if(ch>='0'&&ch<='9')s1=s1+1;
			if(ch==' ')s2=s2+1;
			if(ch>='A'&&ch<='z')s3=s3+1;
		}
		System.out.println(s1);
		System.out.println(s2);
		System.out.println(s3);
	}

	public static void main(String[] args) {
		ae a=new ae();
		a.chaeak();
		// TODO Auto-generated method stub

	}

}
