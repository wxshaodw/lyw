package pc;
/*
TestFileBRW.java
�����������ڿ���̨�����ַ�(��������)��������������ִ洢��ָ�����ļ��У����Ҫ������������quit�ַ������ɡ�
*/
import java.util.*;
import java.io.*;
public class TestFileBRW{
public static void main(String[] args){
try{
//����System.in������
//System.in���ֽ�����ͨ��InputStreamReader����ת��Ϊ�ַ���
BufferedReader bufReader = new BufferedReader(new InputStreamReader(System.in));
//����FileWriter
BufferedWriter bufWriter = new BufferedWriter(new FileWriter(args[0]));

String input = null;

//ÿ��һ�н���һ��д�붯��
while(!(input = bufReader.readLine()).equals("quit")){
bufWriter.write(input);
/*
newLine()����д�������ϵͳ�����Ļ����ַ�����ִ�л�����ʱ��OS��������������ֻ����ַ�
*/
bufWriter.newLine();
}
bufReader.close();
bufWriter.close();
}
catch(ArrayIndexOutOfBoundsException e){
System.out.println("û��ָ���ļ�");
}
catch(IOException e){
e.printStackTrace();
}
}
}
