package pc;
import java.io.*;
public class TestFileCopy{
public static void main(String args[]){
try{
	//复制的源文件file1.txt
FileInputStream rf=new  FileInputStream("F:/a.txt");
//复制的目的文件file2.txt，若不存在，则会自动创建
FileOutputStream wf=new FileOutputStream("F:/b.txt");
byte b[]=new byte[512];
int count=-1;
while((count=rf.read(b, 0, 512))!=-1){//每次读取512个字节
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
