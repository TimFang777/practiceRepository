package singleton;

public class SingletonHungry {
	static private SingletonHungry s=new SingletonHungry();
	private SingletonHungry(){}
	public static SingletonHungry getInstance(){
		return s;
	}
}
