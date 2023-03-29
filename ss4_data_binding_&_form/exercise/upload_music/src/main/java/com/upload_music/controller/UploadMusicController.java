package com.upload_music.controller;

import com.upload_music.service.IUploadMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class UploadMusicController {
    @Autowired
    private final IUploadMusicService uploadMusicService;

    public UploadMusicController(IUploadMusicService uploadMusicService) {
        this.uploadMusicService = uploadMusicService;
    }

}
