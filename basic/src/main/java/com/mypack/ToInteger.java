package com.mypack;

public class ToInteger {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
	
	public static Integer toInteger(Object object) {
		Integer intValue = 0;
		try {
			if(object instanceof Double) {
				intValue = ((Double)object).intValue();
			} else {
				intValue = (Integer)object;
			}
			}catch(Exception e) {
				System.out.println("Exception while number conversion : " + e);
			}
		return intValue;
	}

}
