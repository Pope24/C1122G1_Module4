package com.validate_info_music.service;

import com.validate_info_music.model.Music;

import java.util.List;

public interface IMusicService {
    List<Music> findAll();
    Music findById(int id);
    void save(Music music);
}
