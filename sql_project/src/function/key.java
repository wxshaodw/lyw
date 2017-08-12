package function;


public class key {
	public static String encrypt(String word){
		char[] key=word.toCharArray();
		char[] passkey= new char[word.toCharArray().length];
		for(int i=0;i<word.toCharArray().length;i++){
			passkey[i]=(char) (key[i]+4);
		}
		return String.valueOf(passkey);
	}
	public static String deciphering(String passkey){
		char[] key=passkey.toCharArray();
		char[] word= new char[passkey.toCharArray().length];
		for(int i=0;i<passkey.toCharArray().length;i++){
			word[i]=(char) (key[i]-4);
		}
		return String.valueOf(word);
	}
	/*public static void main(String[] args) {
		String a=key.encrypt("wx4852010");
		String b=key.deciphering("0238<96454");
		System.out.println(a);
		System.out.println(b);
    }*/
}
