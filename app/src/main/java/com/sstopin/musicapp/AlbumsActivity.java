package com.sstopin.musicapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class AlbumsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);


        ArrayList<Music> music = new ArrayList<Music>();
        music.add(new com.sstopin.musicapp.Music("Lenny Kravitz", "5", "Fly Away"));
        music.add(new com.sstopin.musicapp.Music("Van Halen", "1985", "Panama"));
        music.add(new com.sstopin.musicapp.Music("Metallica", "...And Justice For All", "Blackened"));
        music.add(new com.sstopin.musicapp.Music("The Wallflowers", "Bringing Down The Horse", "One Headlight"));
        music.add(new com.sstopin.musicapp.Music("Stone Temple Pilots", "Core", "Creep"));
        music.add(new com.sstopin.musicapp.Music("Megadeth", "Countdown to Extinction", "Symphony Of Destruction"));
        music.add(new com.sstopin.musicapp.Music("Pink Floyd", "Dark Side Of The Moon", "Money"));
        music.add(new com.sstopin.musicapp.Music("Ozzy Osbourne", "Diary Of A Madman", "Over The Mountain"));
        music.add(new com.sstopin.musicapp.Music("Queensryche", "Empire", "Jet City Woman"));
        music.add(new com.sstopin.musicapp.Music("Def Leppard", "Hysteria", "Animal"));


        MusicAdapter adapter =
                new MusicAdapter(this, music);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music selectedMusic = (Music) parent.getItemAtPosition(position);

                Intent playingIntent = new Intent(AlbumsActivity.this, CurrentlyPlaying.class);
                playingIntent.putExtra("artist", selectedMusic.getArtist());
                playingIntent.putExtra("album", selectedMusic.getAlbum());
                playingIntent.putExtra("song", selectedMusic.getSong());
                startActivity(playingIntent);
            }
        });
    }
}
