package s6;

public class TestStr {
	String str[]={"hello","world","welcome","hi","hey"};

	public static void main(String[] args) {
		int i,j;
		String str[]={"hello","world","welcome","hi","hey"};
		String t;
		for(i=0;i<str.length-1;i++){
			for(j=0;j<str.length-1-i;j++){
				if(str[i].compareTo(str[i+1])>0){
					t=str[i];
					str[i]=str[i+1];
					str[i+1]=t;
				}
			}
		}
		for(i=0;i<str.length;i++){
			System.out.println(""+str[i]);
			// TODO Auto-generated method stub
		}

	}

}
