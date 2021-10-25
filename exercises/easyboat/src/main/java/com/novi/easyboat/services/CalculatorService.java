package com.novi.easyboat.services;

public class CalculatorService {
    public int add(int a, int b) {
        return a + b;
    }

    public int minus(int a, int b) {
        return a - b;
    }

    public int multiply(int a, int b) {
        if (a == 0 || b == 0) {
            throw new RuntimeException("You can't multiply by 0");
        }
        return a * b;
    }

    public String concat(String a, String b) {
        return a + " - " + b;
    }
}
