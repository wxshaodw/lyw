package jsp_01;

public class ClassTester {
	public static void main(String args[]) {
	Person A = new Person(); 
	Person B = new Person(); 
	if(A.getClass() == B.getClass())
	{ System.out.println("A and B are instances of same class"); }
	else
	{ System.out.println("A and B are instances of different class"); }
	}
	
	
	public static class Person{
		
		public void Person(){
		}
		
			
	}

}


