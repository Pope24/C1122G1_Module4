package com.upload_music.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private String name;
    private MultipartFile fileMusic;

    public MusicForm() {
    }

    public MusicForm(String name, MultipartFile fileMusic) {
        this.name = name;
        this.fileMusic = fileMusic;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public MultipartFile getFileMusic() {
        return fileMusic;
    }

    public void setFileMusic(MultipartFile fileMusic) {
        this.fileMusic = fileMusic;
    }
}
