package com.translation.repository.Impl;

import com.translation.repository.ITranslateRepository;

import java.util.HashMap;
import java.util.Map;

public class TranslateRepositoryImpl implements ITranslateRepository {
    static Map<String, String> wordList = new HashMap<>();

    static {
        wordList.put("hello", "xin chao");
        wordList.put("Hi", "xin chao");
        wordList.put("Book", "sach");
        wordList.put("Laptop", "may tinh");
        wordList.put("Smartphone", "dien thoai");
        wordList.put("calculator", "may tinh");
        wordList.put("programming", "lap trinh");
    }

    @Override
    public String findWordTranslation(String word) {
        for (Map.Entry<String, String> entry : wordList.entrySet()) {
            if (entry.getKey().equals(word)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
