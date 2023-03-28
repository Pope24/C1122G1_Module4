package com.ung_dung_chuyen_doi_tien_te.service;

import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

@Service

public class CalculatorServiceImpl implements ICalculatorService {
    public double convertUSD(double usd) {
        return usd * 23000;
    }
}
