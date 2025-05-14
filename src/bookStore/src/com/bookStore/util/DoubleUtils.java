package com.bookStore.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleUtils {
    public static Double reserveNumDigits(double num, int numDigits) {
        BigDecimal saleCount_ = new BigDecimal(num);
        num = saleCount_.setScale(numDigits, RoundingMode.HALF_UP).doubleValue();
        return num;
    }

    public static Double operationNum(double d1, double d2, String oop) {
        BigDecimal b1 = new BigDecimal(d1);
        BigDecimal b2 = new BigDecimal(d2);
        switch (oop){
            case "add":
                b1 = b1.add(b2);
                break;
            case "sub":
                b1 = b1.subtract(b2);
                break;
            case "mul":
                b1 = b1.multiply(b2);
                break;
            case "div":
                b1 = b1.divide(b2);
                break;
            default:
                throw new RuntimeException("input oop is wrong!");
        }

        return b1.doubleValue();
    }
}
