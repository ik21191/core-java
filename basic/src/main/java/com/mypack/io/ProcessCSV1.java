package com.mypack.io;

import java.io.File;
import java.io.FileInputStream;

import com.Ostermiller.util.CSVParser;
import com.Ostermiller.util.LabeledCSVParser;

public class ProcessCSV1 {
	public static void main(String arr[]) {
		System.out.println("Program started.");
		try {
			FileInputStream stream1 = new FileInputStream(new File("C:/Imran/a/testCSV.csv"));
			LabeledCSVParser lcsvp = new LabeledCSVParser(new CSVParser(stream1));
			while (lcsvp.getLine() != null) {
				System.out.println("Name: " + lcsvp.getValueByLabel("Name"));
				System.out.println("Address: " + lcsvp.getValueByLabel("Address"));
			}
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Program ended.");
	}
}
