package com.mypack.design.patter.structural;

public class Mp4Player implements AdvancedPlayer {
	@Override
	public void playMP4(String fileName) {
		System.out.println("Playing .... " + fileName);
	}
}
