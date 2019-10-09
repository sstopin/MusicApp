package com.sstopin.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;


public class CurrentlyPlaying extends AppCompatActivity {
    String playingAlbum;
    String playingArtist;
    String playingSong;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playing);

        Intent intent = getIntent();
        ListView listView = (ListView) findViewById(R.id.list);

        TextView album = (TextView) findViewById(R.id.albumPlaying);
        TextView artist = (TextView) findViewById(R.id.artistPlaying);
        TextView song = (TextView) findViewById(R.id.songPlaying);

//        if (!intent.getStringExtra(("album")).equals("")) {
        if (intent.hasExtra("album")) {
            playingAlbum = intent.getStringExtra(("album"));
            playingArtist = intent.getStringExtra(("artist"));
            playingSong = intent.getStringExtra(("song"));
        }
        else {
            SharedPreferences prefs = getSharedPreferences("MusicInfo", MODE_PRIVATE);
            playingAlbum = prefs.getString("album", "");
            playingArtist = prefs.getString("artist", "");
            playingSong = prefs.getString("song", "");
        }


        album.setText(playingAlbum);
        artist.setText(playingArtist);
        song.setText(playingSong);

        SharedPreferences.Editor editor = getSharedPreferences("MusicInfo", MODE_PRIVATE).edit();
        editor.putString("album", playingAlbum);
        editor.putString("artist", playingArtist);
        editor.putString("song", playingSong);
        editor.apply();

        // Set a click listener on currently playing button
        Button homeButton = (Button) findViewById(R.id.homeBtn);
        homeButton.setOnClickListener(new View.OnClickListener() {
            // The code in this method will be executed when the albums View is clicked on
            // and highlight the textview.
            public void onClick(View view) {
                Intent mainIntent = new Intent(CurrentlyPlaying.this, MainActivity.class);
                mainIntent.setFlags(mainIntent.getFlags() | Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(mainIntent);
            }
        });
    }
}
