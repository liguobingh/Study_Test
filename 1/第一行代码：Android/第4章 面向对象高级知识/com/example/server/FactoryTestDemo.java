
public class FactoryTestDemo {
	public static void main(String args[]) {
		Fruit fruit = Factory.getInstance("apple");
		fruit.eat();
	}
}