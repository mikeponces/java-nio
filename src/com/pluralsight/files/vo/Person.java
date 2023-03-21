package com.pluralsight.files.vo;

public class Person {

	private String name;
	private int age;
	private String city;

	public Person(String name, int age, String city) {
		super();
		this.name = name;
		this.age = age;
		this.city = city;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	public String getCity() {
		return city;
	}
}
