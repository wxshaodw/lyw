package lyw;
public class Test{
	public static void main(String  args[]){
	    Complex a,b;
		a=new Complex(1,2);
		b=new Complex(1,-2);
		System.out.println((a.addComplex(b)).toString());
		b=new Complex(3,4);
		System.out.println((a.addComplex(b)).toString());
		b=new Complex(-1,2);
		System.out.println((a.addComplex(b)).toString());
	}
}
class  Complex{
//������Զ���
int	realPart;  
int imaginPart;  
//��ӹ��췽��Complex()
 public Complex(){
	realPart=0;
	imaginPart=0;
	   }
//��ӹ��췽��Complex(int  r,  int  i) 
  public Complex(int  r,int  i){
	realPart=r;
	imaginPart=i;
       }
//��Ӹ�����ӷ��� addComplex
public Complex  addComplex(Complex  a) {
	    Complex b=new Complex();
		b.realPart=a.realPart+this.realPart;
		b.imaginPart=a.imaginPart+this.imaginPart;
		return  b;
        }
//���toString����
public  String toString(){
  		String slt="";
        if(this.realPart!=0)
           { 
           if(this.imaginPart>0)
           slt=String.valueOf(this.realPart)+"+";
            else
           slt=String.valueOf(this.realPart);
           }
                   
        if(this.imaginPart!=0)
          slt=slt+String.valueOf(this.imaginPart)+"i"  ;
       	return slt;
  }
}
