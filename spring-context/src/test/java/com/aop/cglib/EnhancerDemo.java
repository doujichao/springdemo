package com.aop.cglib;

import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;

/**
 * 测试CGLIB
 */
public class EnhancerDemo {
	public static void main(String[] args){
		Enhancer enhancer=new Enhancer();
		enhancer.setSuperclass(EnhancerDemo.class);
		enhancer.setCallback((MethodInterceptor) (o, method, objects, methodProxy) -> {
			System.err.println("Before invoke"+method);
			Object result = methodProxy.invokeSuper(o, objects);
			System.err.println("After invoke"+method);
			return result;
		});

		EnhancerDemo o = (EnhancerDemo) enhancer.create();
		o.test();
		System.out.println(o);
	}

	public void test(){
		System.out.println("EnhancerDemo test()");
	}
}
