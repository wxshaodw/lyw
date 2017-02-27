package function;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class file {
	public static void create_file(String address,String text) throws IOException{
		FileWriter fw=new FileWriter(address);
		fw.write(key.encrypt(text));
		fw.flush();
		fw.close();

	}
	public static String out_file(String address) throws IOException{
		FileReader fr=new FileReader(address);
		BufferedReader br=new BufferedReader(fr);
		String str="";
		while(br.ready())str=str+br.readLine();
		fr.close();
		br.close();
		return key.deciphering(str);
	}
	public static void deleteFile(String sPath) {   
		File a= new File(sPath);  
		a.delete();  
	} 
}
