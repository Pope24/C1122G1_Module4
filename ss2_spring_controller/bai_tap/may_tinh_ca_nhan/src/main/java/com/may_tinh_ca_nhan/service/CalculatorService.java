package com.may_tinh_ca_nhan.service;

import org.springframework.stereotype.Service;

@Service
public class CalculatorService implements ICalculatorService{
    @Override
    public double calculate(double numberOne, double numberTwo, String operator) {
        switch (operator) {
            case "add":
                return numberOne + numberTwo;
            case "divide":
                if (numberTwo == 0) {
                    throw new ArithmeticException();
                }
                else {
                    return numberOne / numberTwo;
                }
            case "multiple":
                return numberOne * numberTwo;
            case "subtract":
                return numberOne - numberTwo;
        }
        return 0;
    }
}
