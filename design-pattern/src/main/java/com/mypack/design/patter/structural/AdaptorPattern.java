package com.mypack.design.patter.structural;

import org.apache.log4j.Logger;

interface MediaPlayer {
	public void play(String fileName);
}

class Mp3Player implements MediaPlayer{
	private static final Logger log = Logger.getLogger(Mp3Player.class);
	
	@Override
	public void play(String fileName) {
		if(fileName.equalsIgnoreCase("MP3")) {
			log.info("Playing ... " + fileName);
		} else {
			log.info("Wrong file format.");
		}
	}
}

interface AdvancedPlayer {
	public void playMP4(String fileName);
}

class Mp4Player implements AdvancedPlayer {
	private static final Logger log = Logger.getLogger(Mp4Player.class);
	@Override
	public void playMP4(String fileName) {
		log.info("Playing .... " + fileName);
	}
}

class MediaPlayerToAdvancedMediaPlayerAdaptor implements MediaPlayer {
	private AdvancedPlayer advancedPlayer;
	
	public MediaPlayerToAdvancedMediaPlayerAdaptor(AdvancedPlayer advancedPlayer) {
		this.advancedPlayer = advancedPlayer;
	}

	@Override
	public void play(String fileName) {
		advancedPlayer.playMP4(fileName);
	}
}

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
