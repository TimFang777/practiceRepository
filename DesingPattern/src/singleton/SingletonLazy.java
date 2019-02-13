package singleton;

public class SingletonLazy {
	static private SingletonLazy s;
	
	private SingletonLazy(){}
	
	public static SingletonLazy getInstance(){
		if(s==null){
			synchronized (SingletonLazy.class) {
				if(s==null){
					s=new SingletonLazy();
				}
			}
		}
		return s;
	}
}
