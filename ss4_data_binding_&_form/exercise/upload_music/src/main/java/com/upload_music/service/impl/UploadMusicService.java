package com.upload_music.service.impl;

import com.upload_music.model.Music;
import com.upload_music.service.IUploadMusicService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class UploadMusicService implements IUploadMusicService {
    private List<Music> musicList = new ArrayList<>();
    @Override
    public void uploadMusic(Music music) {
        musicList.add(music);
    }
}
