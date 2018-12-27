package com.test;

import com.demo.Car;
import com.demo.MyArray;
import com.demo.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;


public class BeanFactoryTest {

	@Test
	public void testSimpleLoad(){
		ApplicationContext context=new ClassPathXmlApplicationContext("com.test/application.xml");
		Object bean=  context.getBean("car");
		System.out.println(bean);
	}

	@Test
	public void test1(){
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("com.test/application.xml"));
		MyTestBean bean= (MyTestBean) factory.getBean("myTestBean");
		System.out.println(bean.getStr());
	}

	@Test
	public void test2(){
		ArrayList<Object> aa=new ArrayList<>();
		System.out.println(aa.getClass().getGenericSuperclass());
		MyArray a=new MyArray();
		Type type = a.getClass().getGenericSuperclass();
		System.out.println(type);

	}
}
