package com.translation.service.impl;

import com.translation.repository.ITranslateRepository;
import com.translation.repository.Impl.TranslateRepositoryImpl;
import com.translation.service.ITranslateService;

public class TranslateServiceImpl implements ITranslateService {
    private ITranslateRepository translateRepository = new TranslateRepositoryImpl();
    @Override
    public String findWordTranslation(String word) {
        return translateRepository.findWordTranslation(word);
    }
}
