package com.tbp.crud.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
public class User {

private int id;
private String name;
private String address;

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
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
@Override
public String toString() {
	return "User [id=" + id + ", name=" + name + ", address=" + address + "]";
}
public User(int id, String name, String address) {
	super();
	this.id = id;
	this.name = name;
	this.address = address;
}
public User() {
	super();
	// TODO Auto-generated constructor stub
}



}
