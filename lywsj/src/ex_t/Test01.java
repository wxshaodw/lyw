package ex_t;

import java.io.*;
import java.util.*;
public class Test01 {
	public static void main(String[] args) {
		try{
			int a;//①，此处添加一段不会出现异常的代码；
			a=10/0;//②，此处添加一段会出现“0做除数”异常的代码；
			int b[]={1};b[1]=20;//③，此处添加一段会出现“数组下标溢出”异常的代码；
			System.out.println("嘻嘻，我没犯错！");
		}catch (ArithmeticException e){
			System.out.println("0不能做除数。");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("数组下标溢出。");
		}
		System.out.println("不管你有没犯错，我都要运行！");
	}
}
