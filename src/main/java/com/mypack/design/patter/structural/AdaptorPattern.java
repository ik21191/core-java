package com.mypack.design.patter.structural;

public class AdaptorPattern {

	public static void main(String[] args) {
		MediaPlayer mPlayer = new Mp3Player();
		mPlayer.play("MP3");
		mPlayer.play("MP4");
		
		AdvancedPlayer advancedPlayer = new Mp4Player();
		advancedPlayer.playMP4("MP4");
		
		mPlayer = new MediaPlayerToAdvancedMediaPlayerAdaptor(advancedPlayer);
		mPlayer.play("MP4");
	}
}
