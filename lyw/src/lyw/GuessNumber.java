package lyw;
import javax.swing.JOptionPane;
public class GuessNumber
{     
     public static void main (String args[ ])
     { 
           System.out.println("����һ��1��100֮�������,��²������");
           int realNumber=(int)(Math.random()*100)+1;
           int yourGuess=0;
           String str=JOptionPane.showInputDialog("�������Ĳ²�:");  
           yourGuess=Integer.parseInt(str); 
           while(yourGuess!=realNumber) //ѭ������
           {
              if(yourGuess>realNumber) //��������
               {
                   str=JOptionPane.showInputDialog("�´���,��������Ĳ²�:");
                   yourGuess=Integer.parseInt(str); 
               }
             else if(yourGuess<realNumber) //��������
               {
                   str=JOptionPane.showInputDialog("��С��,��������Ĳ²�:");
                   yourGuess=Integer.parseInt(str); 
               }
           }
          System.out.println("�¶���!");
      }
}

