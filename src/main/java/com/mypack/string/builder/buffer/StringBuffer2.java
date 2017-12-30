package com.mypack.string.builder.buffer;

public class StringBuffer2 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		StringBuilder whereClause = new StringBuilder();
        whereClause.append("RTRIM(LTRIM(email_lower)) = ").append("abc@abc.com");
        System.out.println(whereClause);
	}

}
