package com.mypack.enums;

public enum Test2 {

	IEEE1(new String[]{" ", " - ", " [", "] \"", "\" ", " ", " \"", "\" \"", "\" ", " "}), 
	IEEE2(new String[]{"This is error2"}),
	IEEE3(new String[]{"This is error3"});
	 
	private final String[] message;
	
	 
	 private Test2(String[] message) {
		this.message = message;
	}


	public String[] getMessage() {
		return message;
	}
	
	/*@Override
    public String toString() {
		String temp = "";
		for(int i=0; i < message.length; i++) {
			temp = temp + message[i];
		}
        return temp;
    }*/
	
	/*@Override
    public String toString() {
        return code + " : " + message;
    }*/
}
