package mypackage2;
class StaticDemo {
static int x;
int y;
public static int getX() {
return x;
}
public static void setX(int newX) {
x = newX;
}
public int getY() {
return y;
}
public void setY(int newY) {
y = newY;
}
}
public class Demo2_4 {
public static void main(String[] args) {
	StaticDemo a= new StaticDemo();
	StaticDemo b= new StaticDemo();
	a.setY(2);
	b.setY(4);
System.out.println("静态变量x="+StaticDemo.getX());
System.out.println("实例变量y="+a.getY());
System.out.println("实例变量y="+b.getY());// 非法，编译时将出错
StaticDemo.setX(1);
System.out.println("静态变量a.x="+StaticDemo.getX());
System.out.println("实例变量a.y="+a.getY());
System.out.println("静态变量b.x="+StaticDemo.getX());
System.out.println("实例变量b.y="+b.getY());
}
}
