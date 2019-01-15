package com.test;

import com.aop.TestBean;
import com.dateproperty.String2DateConverter;
import com.demo.Car;
import com.demo.MyArray;
import com.demo.MyTestBean;
import com.listener.TestEvent;
import com.pojo.UserManager;
import org.junit.Test;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.io.ClassPathResource;

import java.lang.reflect.Type;
import java.text.MessageFormat;
import java.util.*;


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

	@Test
	public void testProperty(){
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("com.test/application.xml");
		UserManager userManager = (UserManager) context.getBean("userManager");
		System.out.println(userManager);
	}

	/**
	 * 屏蔽特定字符的demo
	 */
	@Test
	public void testPostProcess(){
		ConfigurableListableBeanFactory bf=new XmlBeanFactory(new ClassPathResource("com.test/application1.xml"));
		BeanFactoryPostProcessor bfpp= (BeanFactoryPostProcessor) bf.getBean("dfpp");
		bfpp.postProcessBeanFactory(bf);
		System.out.println(bf.getBean("simpleBean"));
	}

	@Test
	public void testI18N(){
		//信息格式化串
		String pattern1="{0},你好！你于{1}在工商银行存入{2}员";
		String pattern2="At {1,time,short} On {1,date,long},{0} paid {2,number,currency}.";

		//用于动态替换占位符的参数
		Object[] params={"John",new GregorianCalendar().getTime(),1.0E3};

		//使用默认本地化对象格式化信息
		String msg1 = MessageFormat.format(pattern1, params);

		//使用指定的本地化对象格式化信息
		MessageFormat mf=new MessageFormat(pattern2, Locale.US);
		String msg2 = mf.format(params);
		System.out.println(msg1);
		System.out.println(msg2);
	}

	@Test
	public void testListener(){
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:com.test/application1.xml");
		TestEvent event=new TestEvent("hello","msg");
		context.publishEvent(event);
	}

	@Test
	public void testString2PhoneNumberConvert(){
		DefaultConversionService conversionService=new DefaultConversionService();
		conversionService.addConverter(new String2DateConverter());
	}

	@Test
	public void testAOP(){
		ApplicationContext context=new ClassPathXmlApplicationContext("classpath:com.test/application-aop.xml");
		TestBean bean=(TestBean)context.getBean("test");
		bean.test();
	}
}
