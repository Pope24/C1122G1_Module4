package com.convert_money.service.impl;

import com.convert_money.service.ICalculatorService;
import org.springframework.stereotype.Service;

@Service

public class CalculatorServiceImpl implements ICalculatorService {
    public double convertUSD(double usd) {
        return usd * 23000;
    }
}
