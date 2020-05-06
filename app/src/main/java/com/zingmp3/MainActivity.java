package com.zingmp3;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

	private ArrayList<Song> playingList;
	private Song currentSong;
	private String title;


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		playingList = new ArrayList<Song>();
		addSongs();
		currentSong = (Song)playingList.get(0);

		// playing
		ImageView imagePlaying = (ImageView) findViewById(R.id.imagePlaying);
		imagePlaying.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				playing();
			}
		});

		// next song
		ImageView imageNext = (ImageView) findViewById(R.id.imageNext);
		imageNext.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				TextView currentText = (TextView) findViewById(R.id.currentSong);
				currentText.setText(currentSong.getName());
				getNext();
				playing();
			}
		});

		// previous song
		ImageView imagePrevious = (ImageView) findViewById(R.id.imagePrevious);
		imagePrevious.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {
				getPrevious();
				playing();
			}
		});


	}

	public void playing(){
		title = currentSong.getName();
		currentSong.playing(MainActivity.this);
	}

	public void getNext(){
		int currentIndex = playingList.indexOf(currentSong);
		if (currentIndex+1 < playingList.size()){
			currentSong = (Song)playingList.get(currentIndex+1);
		}else{
			currentSong = (Song)playingList.get(0);
		}

	}

	public void getPrevious(){
		int currentIndex = playingList.indexOf(currentSong);
		if (currentIndex+1 > 0){
			currentSong = (Song)playingList.get(currentIndex-1);
		}else{
			currentSong = (Song)playingList.get(playingList.size()-1);
		}
	}


	public void addSongs(){
		playingList.add(new Song("Song 1", R.raw.song1));
		playingList.add(new Song("Song 2", R.raw.song2));
	}





}
