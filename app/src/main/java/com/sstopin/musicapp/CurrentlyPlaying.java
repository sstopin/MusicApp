package com.sstopin.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import org.w3c.dom.Text;

public class CurrentlyPlaying extends AppCompatActivity {
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.playing);

        Intent intent = getIntent();
        ListView listView = (ListView) findViewById(R.id.list);


        TextView album = (TextView) findViewById(R.id.albumPlaying);
        TextView artist = (TextView) findViewById(R.id.artistPlaying);
        TextView song = (TextView) findViewById(R.id.songPlaying);

        album.setText(intent.getStringExtra("album"));
        artist.setText(intent.getStringExtra("artist"));
        song.setText(intent.getStringExtra("song"));
    }

}
