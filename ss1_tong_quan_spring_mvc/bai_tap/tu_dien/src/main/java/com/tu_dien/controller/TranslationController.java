package com.tu_dien.controller;

import com.tu_dien.service.ITranslateService;
import com.tu_dien.service.TranslateServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class TranslationController {
    private ITranslateService translateService = new TranslateServiceImpl();
    @GetMapping("translate")
    public String showFromTranslation() {
        return "form";
    }
    @PostMapping("translate/result")
    public String showResultTranslation(@RequestParam(name = "word") String word, Model model) {
        String result = translateService.findWordTranslation(word);
        if (result != null) {
            model.addAttribute("result", result);
        }
        else model.addAttribute("result", "Khong co tu nay !!!");
        return "result";
    }
}
