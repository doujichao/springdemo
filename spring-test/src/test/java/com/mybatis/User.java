package com.mybatis;

public class User {
	private Integer id;
	private String name;
	private Integer age;

	/**
	 * mybatis必须要有这个无参构造方法，不然根据UserMapper.xml
	 * 中的配置，再查询数据库的时候，将不能反射构造出User实例
	 *
	 */
	public User() {

	}

	public User(String name, Integer age) {
		this.name = name;
		this.age = age;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}
}
