package com.sstopin.musicapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class ArtistsActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.word_list);

        ArrayList<Music> music = new ArrayList<Music>();
        music.add(new Music("Def Leppard", "Hysteria", "Animal"));
        music.add(new Music("Lenny Kravitz", "5", "Fly Away"));
        music.add(new Music("Megadeth", "Countdown to Extinction", "Symphony Of Destruction"));
        music.add(new Music("Metallica", "...And Justice For All", "Blackened"));
        music.add(new Music("Ozzy Osbourne", "Diary Of A Madman", "Over The Mountain"));
        music.add(new Music("Pink Floyd", "Dark Side Of The Moon", "Money"));
        music.add(new Music("Queensryche", "Empire", "Jet City Woman"));
        music.add(new Music("Stone Temple Pilots", "Core", "Creep"));
        music.add(new Music("Van Halen", "1985", "Panama"));
        music.add(new Music("The Wallflowers", "Bringing Down The Horse", "One Headlight"));

        MusicAdapter adapter =
                new MusicAdapter(this, music);
        ListView listView = (ListView) findViewById(R.id.list);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Music selectedMusic = (Music) parent.getItemAtPosition(position);

                Intent playingIntent = new Intent(ArtistsActivity.this, CurrentlyPlaying.class);
                playingIntent.putExtra("artist", selectedMusic.getArtist());
                playingIntent.putExtra("album", selectedMusic.getAlbum());
                playingIntent.putExtra("song", selectedMusic.getSong());
                startActivity(playingIntent);
            }
        });
    }
}
