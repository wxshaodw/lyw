package s7;
public class Cheak_S {
	public int Cheak_w(String str[]){
		int i=0;
		for(int j=0;j<str.length;j++){
			if(str[j].startsWith("w"))i=i+1;
		}
		return(i);
	}
	public int Cheak_or(String str[]){
		int i=0;
		for(int j=0;j<str.length;j++){
			if(str[j].indexOf("or")!=-1)i=i+1;
		}
		return(i);
	}
	public int Cheak_3(String str[]){
		int i=0;
		for(int j=0;j<str.length;j++){
			if(str[j].length()==3)i=i+1;
		}
		return(i);
	}

	public static void main(String[] args) {
		Cheak_S s1=new Cheak_S();
		String str[]={"I","am","a","student","i","will","be","a","teacher","or","writer","when","i","grow","up","and","then","i","will","buy","a","big","house"};
		System.out.println("在字符串数组str中以w开头的字符串数目："+s1.Cheak_w(str));
		System.out.println("在字符串数组str中含or开头的字符串数目："+s1.Cheak_or(str));
		System.out.println("在字符串数组str中长度为3的字符串数目为："+s1.Cheak_3(str));
		// TODO Auto-generated method stub

	}

}
