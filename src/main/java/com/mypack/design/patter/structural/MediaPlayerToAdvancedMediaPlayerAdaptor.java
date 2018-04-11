package com.mypack.design.patter.structural;

public class MediaPlayerToAdvancedMediaPlayerAdaptor implements MediaPlayer {
	private AdvancedPlayer advancedPlayer;
	
	public MediaPlayerToAdvancedMediaPlayerAdaptor(AdvancedPlayer advancedPlayer) {
		this.advancedPlayer = advancedPlayer;
	}

	@Override
	public void play(String fileName) {
		advancedPlayer.playMP4(fileName);
	}
}
