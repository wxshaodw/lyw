package pc;
//TestFileSearch.java
import java.io.*;
class ListFilter implements FilenameFilter{
private String pre="", ext="";//pre��ʾ�ļ�ǰ׺��ext��ʾ�ļ���׺
public ListFilter(String filterstr){
int i,j;
filterstr=filterstr.toLowerCase();
i=filterstr.indexOf("*");
j=filterstr.indexOf(".");
if(i>0)
pre=filterstr.substring(0,i);
if(i==-1& j>0)
pre=filterstr.substring(0,j);
if(j>=0)
ext=filterstr.substring(j+1);
} 
public boolean accept(File dir,String filename){
boolean y=true;
try{
filename=filename.toLowerCase();
y=filename.startsWith(pre) & filename.endsWith(ext);
}
catch(NullPointerException e){ 
}
return y;
}
}
public class TestFileSearch{
public static void main(String args[]){
		//Ҫ��������������һ��������ʾĿ¼���ڶ�������ʾҪ���˵��ļ�
		String strDir, strExtension;
		switch(args.length){
			case 1:
				strDir=".";
				strExtension=args[0];
				break;
			case 2:
				strDir=args[0];
				strExtension=args[1];
				break;
			default:
				System.out.println("����������!");
				return;
		}
File f=new File(strDir);
ListFilter ls=new ListFilter(strExtension);
//System.out.println(f.getAbsolutePath());
String str[]=f.list(ls);
for(int i=0;i<str.length;i++)
	System.out.println(str[i]);
}
}
