package proxy.JDKdynamic;

import java.lang.reflect.Proxy;

/***
 * 
 * @author jdk dynamic proxy
 * 
 *         based on reflection;no package imported
 * 
 *         low efficiency
 * 
 *         spring AOP default
 */

public class Test {
	public static void main(String[] args) {
		Assistant as = new Assistant();

		Task t = (Task) Proxy.newProxyInstance(
				Assistant.class.getClassLoader(), new Class[] { Task.class },
				as);
		t.meeting();
	}
}
