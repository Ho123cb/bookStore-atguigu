package com.bookStore.util;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class DoubleUtils {
    public static Double reserveNumDigits(double num, int numDigits) {
        BigDecimal saleCount_ = new BigDecimal(num);
        num = saleCount_.setScale(numDigits, RoundingMode.HALF_UP).doubleValue();
        return num;
    }
}
