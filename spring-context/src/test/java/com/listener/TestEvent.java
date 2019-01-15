package com.listener;

import org.springframework.context.ApplicationEvent;

public class TestEvent extends ApplicationEvent {

	public String msg;

	/**
	 * Create a new ApplicationEvent.
	 *
	 * @param source the object on which the event initially occurred (never {@code null})
	 */
	public TestEvent(Object source) {
		super(source);
	}

	public TestEvent(Object source,String msg){
		this(source);
		this.msg=msg;
	}

	public void print(){
		System.out.println(msg);
	}
}
