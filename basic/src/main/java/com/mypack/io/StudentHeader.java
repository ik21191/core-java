package com.mypack.io;

public enum StudentHeader {
	STUDENT_ID(0, "id"), STUDENT_NAME(1, "name"), STUDENT_MOBILE(2, "mobile"), STUDENT_ADDRESS(3, "address");
	
	int index;
	String indexValue;	
	
	private StudentHeader(int index, String indexValue) {
		this.index = index;
		this.indexValue = indexValue;
	}

	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}

	public String getIndexValue() {
		return indexValue;
	}

	public void setIndexValue(String indexValue) {
		this.indexValue = indexValue;
	}
}
