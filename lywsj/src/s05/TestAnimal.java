package s05;
abstract class Animal{
	String name;
	int age;
	int weight;
	public void showInfo( ){
		System.out.println("������"+name);
		System.out.println("���䣻"+age);
		System.out.println("���أ�"+weight);
	}
	abstract void move( );
	abstract void eat( );
}
class Bird extends Animal{
	public Bird(String name,int age,int weight){
		super();
		this.name=name;
		this.age=age;
		this.weight=weight;
		}
	void move() {
		System.out.println("�����ƶ���ʽ�ǣ�fly");
	}
	void eat() {
		System.out.println("����ʳ���ǣ�����");
	}
}

public class TestAnimal {

	public static void main(String[] args) {
		Bird a=new Bird("��ľ��",10,50);
		a.showInfo();
		a.move();
		a.eat();
		// TODO Auto-generated method stub

	}

}
