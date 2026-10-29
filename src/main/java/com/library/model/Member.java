package com.library.model;

import java.io.Serializable;

public class Member implements Serializable {

	private int id;
	private String name;
	private String email;
	private String phone;
	private String address;
	
	public Member() {}
	
	public Member(String name, String email, String phone, String address) {
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.address = address;
	}
	
	public Member(int id, String name, String email, String phone, String address) {
		this(name, email, phone, address);
		
		this.id = id;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}

	@Override
	public String toString() {
		return "Member [id=" + id + ", name=" + name + ", email=" + email + ", phone=" + phone + ", address=" + address
				+ "]";
	}

	
}
