package com.demo;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;

public class MyNamespaceHandle extends NamespaceHandlerSupport {
	@Override
	public void init() {
		registerBeanDefinitionParser("user",new UserBeanDefinitionParser());
	}
}
