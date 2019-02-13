package observer;
/***
 * 
 * @author Tim
 * 
 * Used:
 * 		Spring event driven model-ApplicationEvent, ApplicationListener, ApplicationEventMulticaster
 *
 */
public class Test {
	public static void main(String[] args) {
		TargetServer ts=new TargetServer();
		
		Observer a=new User("Allen");
		Observer b=new User("Bill");
		Observer c=new User("Candy");

		ts.registerObserver(a);
		ts.registerObserver(b);
		ts.registerObserver(c);
		
		
		ts.setInformation("dinner tonight");
		ts.setInformation("dinner canceled");
		
		ts.removeObserver(b);
		
		ts.setInformation("overtime tonight");

		

	}
}
