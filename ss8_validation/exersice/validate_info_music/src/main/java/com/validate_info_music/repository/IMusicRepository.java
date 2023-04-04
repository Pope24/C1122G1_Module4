package com.validate_info_music.repository;

import com.validate_info_music.model.Music;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Controller;

@Controller
public interface IMusicRepository extends JpaRepository<Music, Integer> {
}
