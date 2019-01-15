package com.aop;

public class TestBean {
	private String testStr="testStr";

	public String getTestStr(){
		return testStr;
	}

	public void setTestStr(){
		this.testStr=testStr;
	}

	public void test(){
		System.out.println("test");
	}
}
