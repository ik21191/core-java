package com.mypack.xml.sax.beans;

import java.util.ArrayList;
import java.util.List;

public class FileToProcess {

	String fileName, filePattern;
	List<List<Fields>> fieldList = new ArrayList<List<Fields>>();
	
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	
	public String getFilePattern() {
		return filePattern;
	}
	public void setFilePattern(String filePattern) {
		this.filePattern = filePattern;
	}
	public List<List<Fields>> getFieldList() {
		return fieldList;
	}
	public void setFieldList(List<List<Fields>> fieldList) {
		this.fieldList = fieldList;
	}
	
	
}
