package com.test;

import com.demo.MyTestBean;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.io.ClassPathResource;


public class BeanFactoryTest {

	@Test
	public void testSimpleLoad(){
		ApplicationContext context=new ClassPathXmlApplicationContext("com.test/application.xml");
		MyTestBean bean= (MyTestBean) context.getBean("myTestBean");
		System.out.println(bean.getStr());
	}

	@Test
	public void test1(){
		XmlBeanFactory factory=new XmlBeanFactory(new ClassPathResource("com.test/application.xml"));
		MyTestBean bean= (MyTestBean) factory.getBean("myTestBean");
		System.out.println(bean.getStr());
	}
}
