package s05;
abstract class Animal{
	String name;
	int age;
	int weight;
	public void showInfo( ){
		System.out.println("姓名；"+name);
		System.out.println("年龄；"+age);
		System.out.println("体重；"+weight);
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
		System.out.println("它的移动方式是：fly");
	}
	void eat() {
		System.out.println("它的食物是：虫子");
	}
}

public class TestAnimal {

	public static void main(String[] args) {
		Bird a=new Bird("啄木鸟",10,50);
		a.showInfo();
		a.move();
		a.eat();
		// TODO Auto-generated method stub

	}

}
