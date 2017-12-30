package com.mypack.enums;

public enum Test {

	ERROR1("ERROR1", "This is error1"), ERROR2("ERROR2", "This is error2"),
	ERROR3("ERROR3", "This is error3");
	 
	private final String code;
	private final String message;
	
	 
	 private Test(String code, String message) {
		this.code = code;
		this.message = message;
	}


	public String getCode() {
		return code;
	}


	public String getMessage() {
		return message;
	}
	@Override
    public String toString() {
        return  code + "," + message;
    }
	
	/*@Override
    public String toString() {
        return code + " : " + message;
    }*/
}
