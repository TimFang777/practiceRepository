package proxy.JDKdynamic;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
//proxy controller
public class Assistant implements InvocationHandler{
	private Boss bs=new Boss();
	@Override
	public Object invoke(Object proxy, Method method, Object[] args)
			throws Throwable {
		System.out.println("book");
		method.invoke(bs, args);
		System.out.println("record");
		return null;
	}

}
