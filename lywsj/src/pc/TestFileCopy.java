package pc;
import java.io.*;
public class TestFileCopy{
public static void main(String args[]){
try{
	//���Ƶ�Դ�ļ�file1.txt
FileInputStream rf=new  FileInputStream("F:/a.txt");
//���Ƶ�Ŀ���ļ�file2.txt���������ڣ�����Զ�����
FileOutputStream wf=new FileOutputStream("F:/b.txt");
byte b[]=new byte[512];
int count=-1;
while((count=rf.read(b, 0, 512))!=-1){//ÿ�ζ�ȡ512���ֽ�
wf.write(b,0,count);
String a=new  String(b,0,count);
System.out.println(a);}
rf.close();
wf.close();
}
catch(IOException ie){
System.out.println(ie.toString());
}
catch(Exception e){
System.out.println(e.toString());
}
}
}
