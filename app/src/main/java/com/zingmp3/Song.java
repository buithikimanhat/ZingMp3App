package com.zingmp3;

import android.content.Context;
import android.media.MediaPlayer;

public class Song {
	private String name;
	private String singer;
	private int file;
	private int timeInMiliseconds;
	private MediaPlayer mediaPlayer;

	public Song( String name, int file){
		name = name;
		file = file;

	}

	public int getFile() {
		return file;
	}

	public void setFile(int file) {
		this.file = file;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSinger() {
		return singer;
	}

	public void setSinger(String singer) {
		this.singer = singer;
	}



	public int getTimeInMiliseconds() {
		return timeInMiliseconds;
	}

	public void setTimeInMiliseconds(int timeInMiliseconds) {
		this.timeInMiliseconds = timeInMiliseconds;
	}

	public Song(){

	}

	public Song(String name, String singer, String imagePath, int timeInMiliseconds){
		name = name;
		singer = singer;
		imagePath = imagePath;
		timeInMiliseconds = timeInMiliseconds;
	}

	public void playing(Context context){
		mediaPlayer = MediaPlayer.create(context, file);
		mediaPlayer.start();
	}
}
