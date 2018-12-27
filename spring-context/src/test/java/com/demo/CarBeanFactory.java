package com.demo;


import org.springframework.beans.factory.FactoryBean;

public class CarBeanFactory implements FactoryBean<Car> {

	private String info;

	@Override
	public Car getObject() throws Exception {
		Car car=new Car();
		String[] infos = info.split(",");
		car.setBrand(infos[0]);
		car.setMaxSpeed(Integer.parseInt(infos[1]));
		car.setPrice(Double.parseDouble(infos[2]));
		return car;
	}

	@Override
	public Class<?> getObjectType() {
		return Car.class;
	}

	public String getInfo() {
		return info;
	}

	public void setInfo(String info) {
		this.info = info;
	}

}
