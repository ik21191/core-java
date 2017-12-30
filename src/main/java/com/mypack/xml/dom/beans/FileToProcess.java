package com.mypack.xml.dom.beans;

import java.util.List;

public class FileToProcess {

	String fileName;
	List<Fields> fieldList;
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public List<Fields> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<Fields> fieldList) {
		this.fieldList = fieldList;
	}
	
}