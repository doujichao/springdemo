package com.test;

import com.demo.MyTestBean;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;


public class BeanFactoryTest {

	@Test
	public void testSimpleLoad(){
		ApplicationContext context=new ClassPathXmlApplicationContext("com.test/application.xml");
		MyTestBean bean= (MyTestBean) context.getBean("myTestBean");
		System.out.println(bean.getStr());
	}
}
