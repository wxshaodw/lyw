package ex_t;

import java.io.*;
public class Test02{ 
public static void main(String args[]){
  	  	File file=new File("Test02.java");
 	   	System.out.println("name��"+file.getName());
    System.out.println("path��"+file.getAbsolutePath());
    System.out.println("length��"+file.length());
}
}
