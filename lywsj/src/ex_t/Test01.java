package ex_t;

import java.io.*;
import java.util.*;
public class Test01 {
	public static void main(String[] args) {
		try{
			int a;//�٣��˴����һ�β�������쳣�Ĵ��룻
			a=10/0;//�ڣ��˴����һ�λ���֡�0���������쳣�Ĵ��룻
			int b[]={1};b[1]=20;//�ۣ��˴����һ�λ���֡������±�������쳣�Ĵ��룻
			System.out.println("��������û����");
		}catch (ArithmeticException e){
			System.out.println("0������������");
		}catch(ArrayIndexOutOfBoundsException e){
			System.out.println("�����±������");
		}
		System.out.println("��������û�����Ҷ�Ҫ���У�");
	}
}
