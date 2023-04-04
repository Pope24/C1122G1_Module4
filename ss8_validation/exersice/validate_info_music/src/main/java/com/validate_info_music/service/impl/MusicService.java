package com.validate_info_music.service.impl;

import com.validate_info_music.model.Music;
import com.validate_info_music.repository.IMusicRepository;
import com.validate_info_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService {
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music findById(int id) {
        return musicRepository.findById(id).get();
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }
}
