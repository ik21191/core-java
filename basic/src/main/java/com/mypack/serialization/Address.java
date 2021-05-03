package com.mypack.serialization;

import java.io.Serializable;

public class Address implements Serializable {
	private static final long serialVersionUID = 1L;

	String name;

	public Address(String name) {
		this.name = name;
	}
}
