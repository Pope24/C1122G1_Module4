package com.tu_dien.service;

import com.tu_dien.repository.ITranslateRepository;
import com.tu_dien.repository.TranslateRepositoryImpl;

public class TranslateServiceImpl implements ITranslateService{
    private ITranslateRepository translateRepository = new TranslateRepositoryImpl();
    @Override
    public String findWordTranslation(String word) {
        return translateRepository.findWordTranslation(word);
    }
}
