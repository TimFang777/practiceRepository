package singleton;


public class Test {
	public static void main(String[] args) {
		SingletonLazy s1=SingletonLazy.getInstance();
		SingletonLazy s2=SingletonLazy.getInstance();
		System.out.println(s1==s2);
		
		SingletonHungry s3=SingletonHungry.getInstance();
		SingletonHungry s4=SingletonHungry.getInstance();
		System.out.println(s3==s4);

	}
}
