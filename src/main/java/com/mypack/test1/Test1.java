package com.mypack.test1;

import javax.sound.midi.MidiDevice.Info;

import org.apache.log4j.Logger;

public class Test1 {
	private static final Logger log = Logger.getLogger(Test1.class);
	public static void main(String arr[]) {
		
		String test1 = "BKksV9CWoaSnyK5FKka7iQA3c2EhfndL*4ByydUz7q753SD0xxrb11tvG7BLj2z1x2FlAIqT72VdKABOEywjPud9KAx3Dx3D-18x2d5uKqDHx2BU6xxwPrQKQ8eH2vwx3Dx3DCDWX0GQJGedGx2F5mUx2BHSNx2Bwx3Dx3D-74WfbdZD876j9q2bPIopZAx3Dx3D-hSx2Fy2PwxxNx2B4GkiZY7zyx2B7gx3Dx3D";
		String test2 = "BKksV9CWoaSnyK5FKka7iQA3c2EhfndL*4ByydUz7q753SD0xxrb11tvG7BLj2z1x2FlAIqT72VdKABOEywjPud9KAx3Dx3D-18x2d5uKqDHx2BU6xxwPrQKQ8eH2vwx3Dx3DCDWX0GQJGedGx2F5mUx2BHSNx2Bwx3Dx3D-74WfbdZD876j9q2bPIopZAx3Dx3D-hSx2Fy2PwxxNx2B4GkiZY7zyx2B7gx3Dx3D";
		
		String s = "2017-01-18";
		/*log.info(s.length());
		log.info(s.substring(0, 4));
		log.info(s.substring(5, 7));
		log.info(s.substring(8, 10));
		
		log.info(test1.equals(test2));*/
		
		
		
		String s1 = "/servlet/Denial.jsp?denialreason=license&arnumber=6180939&isnumber=--&punumber=--&internalerrorreason=Not Specified&pdfType=article";
		String s2 = "/servlet/Denial.jsp?denialreason=license&arnumber=6180939&isnumber=--&punumber=--&internalerrorreason=Not Specified&pdfType=article";
		if(s1.equals(s2)) {
			log.info("Both are same ");
		}
		
	}
}
