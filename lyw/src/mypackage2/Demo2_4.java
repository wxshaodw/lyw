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
System.out.println("��̬����x="+StaticDemo.getX());
System.out.println("ʵ������y="+a.getY());
System.out.println("ʵ������y="+b.getY());// �Ƿ�������ʱ������
StaticDemo.setX(1);
System.out.println("��̬����a.x="+StaticDemo.getX());
System.out.println("ʵ������a.y="+a.getY());
System.out.println("��̬����b.x="+StaticDemo.getX());
System.out.println("ʵ������b.y="+b.getY());
}
}
