package com.mypack.xml.sax.beans;

import java.util.ArrayList;
import java.util.List;

public class Fields {
	private String sequence, name, description, targetField;
	private List<String> listTargetSuccessField = new ArrayList<String>();
	public String getSequence() {
		return sequence;
	}
	public void setSequence(String sequence) {
		this.sequence = sequence;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getTargetField() {
		return targetField;
	}
	public void setTargetField(String targetField) {
		this.targetField = targetField;
	}
	public List<String> getListTargetSuccessField() {
		return listTargetSuccessField;
	}
	public void setListTargetSuccessField(List<String> listTargetSuccessField) {
		this.listTargetSuccessField = listTargetSuccessField;
	}
	
	
}
