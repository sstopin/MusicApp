package com.sstopin.musicapp;

// adapter to handle the arraylist of music objects

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class MusicAdapter extends ArrayAdapter<com.sstopin.musicapp.Music> {

    public MusicAdapter(Activity context, ArrayList<com.sstopin.musicapp.Music> music){
        super(context, 0, music);
    }

    public View getView(int position, View convertView, ViewGroup parent) {

        com.sstopin.musicapp.Music currentWord = getItem(position);
        View listItemView = LayoutInflater.from(getContext()).inflate(
                R.layout.list_item, parent, false);
        TextView albumTextView = (TextView) listItemView.findViewById(R.id.albumName);
        TextView artistTextView = (TextView) listItemView.findViewById(R.id.artistName);
        TextView songTextView = (TextView) listItemView.findViewById(R.id.songName);

        albumTextView.setText(currentWord.getAlbum());
        artistTextView.setText(currentWord.getArtist());
        songTextView.setText(currentWord.getSong());

        return listItemView;
    }
}

