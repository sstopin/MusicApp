package com.sstopin.musicapp;

// This is the custom Music constructor to handle
// the displaying of song, album and artist

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
