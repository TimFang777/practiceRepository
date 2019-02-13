package proxy.cglibdynamic;
import net.sf.cglib.proxy.Enhancer;
/***
 * 
 * @author 
 * Used:
 * 		spring AOP
 * 		by default, spring aop use jdk proxy
 * 		set in applicationContext.xml to switch to cglib
 * 		<aop:aspectj-autoproxy proxy-target-class="true"></aop:aspectj-autoproxy>
 *
 */
public class Test {
	public static void main(String[] args) {
		Enhancer ehancer=new Enhancer();
		ehancer.setSuperclass(Boss.class);
		ehancer.setCallback(new Assistant());
		
		Boss bs= (Boss)ehancer.create();
		bs.meeting();
	}
}
