package com.upload_music.model;

public class Music {
    private String name;
    private String musicFile;

    public Music() {
    }

    public Music(String name, String musicFile) {
        this.name = name;
        this.musicFile = musicFile;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getMusicFile() {
        return musicFile;
    }

    public void setMusicFile(String musicFile) {
        this.musicFile = musicFile;
    }
}
