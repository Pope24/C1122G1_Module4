package com.validate_info_music.controller;

import com.validate_info_music.model.Music;
import com.validate_info_music.service.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class MusicController {
    @Autowired
    private IMusicService musicService;

    @GetMapping("")
    public ModelAndView showListMusic() {
        ModelAndView modelAndView = new ModelAndView("listMusic");
        modelAndView.addObject("musicList", musicService.findAll());
        return modelAndView;
    }

    @GetMapping("create")
    public String showFormCreateMusic(Model model) {
        model.addAttribute("music", new Music());
        return "formUpdateAndCreate";
    }

    @GetMapping("update/{id}")
    public ModelAndView showFormUpdateMusic(@PathVariable int id) {
        ModelAndView modelAndView = new ModelAndView("formUpdateAndCreate");
        modelAndView.addObject("music", musicService.findById(id));
        return modelAndView;
    }

    @PostMapping("save-music")
    public String saveMusic(@Valid @ModelAttribute Music music, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "formUpdateAndCreate";
        }
        musicService.save(music);
        return "redirect:/";
    }
}
