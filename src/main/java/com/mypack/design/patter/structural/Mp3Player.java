package com.mypack.design.patter.structural;

public class Mp3Player implements MediaPlayer{
	@Override
	public void play(String fileName) {
		if(fileName.equalsIgnoreCase("MP3")) {
			System.out.println("Playing ... " + fileName);
		} else {
			System.out.println("Wrong file format.");
		}
	}
}
