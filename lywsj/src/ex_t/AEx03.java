package ex_t;
import java.io.*;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class AEx03 {
	public static void main(String[] args) {
		try{
			FileWriter fw=new FileWriter("Lyw.txt");
			BufferedWriter bw=new BufferedWriter(fw);
			String str[]=new String[3];
			for(int i=0;i<3;i++){
				Scanner in= new Scanner(System.in);
				str[i]=in.nextLine();
				bw.write(str[i]);
				bw.newLine();
				bw.flush();
			}
			bw.close();
			fw.close();
			for(int i=0;i<3;i++){
				System.out.println(str[i]);
				
			}
		}catch(IOException e){
		JOptionPane.showMessageDialog(null,"ÎÄ¼þ¶ÁÐ´³ö´í");
		}
		// TODO Auto-generated method stub

	}

}
