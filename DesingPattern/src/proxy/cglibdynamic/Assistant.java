package proxy.cglibdynamic;

import java.lang.reflect.Method;

import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

//proxy controller
//user bytecode-high efficiency
//disadvantage: package import needed
public class Assistant implements MethodInterceptor {

	@Override
	public Object intercept(Object arg0, Method arg1, Object[] arg2,
			MethodProxy arg3) throws Throwable {
		System.out.println("book");
		//Object result = arg1.invoke(arg0, arg2);
		Object result = arg3.invokeSuper(arg0, arg2);
		System.out.println("record");
		return result;
	}
}
