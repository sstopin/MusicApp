package com.sstopin.musicapp;

// This is the custom Word constructor to handle
// the displaying of the Miwok and English words for
// each categoty.

public class Music {
    private String mArtist;
    private String mAlbum;
    private String mSong;


    public Music(String artist, String album, String song){
        mArtist = artist;
        mAlbum = album;
        mSong = song;
    }

    public String getArtist () {
        return mArtist;
    }

    public String getAlbum () {
        return mAlbum;
    }

    public String getSong () {
        return mSong;
    }
}
