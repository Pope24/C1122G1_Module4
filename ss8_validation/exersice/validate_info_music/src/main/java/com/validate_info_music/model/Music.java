package com.validate_info_music.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

@Entity
public class Music {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NotBlank(message = "Không được để trống")
    @Size(max = 800, message = "Vượt kích thước cho phép")
    @Pattern(regexp = "^((?=[A-Za-z0-9])(?![_\\\\-]).)*$", message = "Không chứa các kí tự đặc biệt")
    private String nameMusic;
    @NotBlank(message = "Không được để trống")
    @Size(max = 300, message = "Vượt kích thước cho phép")
    @Pattern(regexp = "^((?=[A-Za-z0-9])(?![_\\\\-]).)*$", message = "Không chứa các kí tự đặc biệt")
    private String singer;
    @NotBlank(message = "Không được để trống")
    @Size(max = 1000, message = "Vượt kích thước cho phép")
    @Pattern(regexp = "^((?=[A-Za-z0-9,])(?![_\\\\-]).)*$", message = "Không chứa các kí tự đặc biệt")
    private String typeMusic;

    public Music() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNameMusic() {
        return nameMusic;
    }

    public void setNameMusic(String nameMusic) {
        this.nameMusic = nameMusic;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public String getTypeMusic() {
        return typeMusic;
    }

    public void setTypeMusic(String typeMusic) {
        this.typeMusic = typeMusic;
    }
}
