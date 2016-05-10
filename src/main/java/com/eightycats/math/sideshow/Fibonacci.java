package com.eightycats.math.sideshow;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;

public class Fibonacci
{
    // Math.sqrt(5.0)
    public static final double SQUARE_ROOT_5 = 2.23606797749979;

    // (1.0 + Math.sqrt(5.0)) / 2;
    public static final double PHI = 1.618033988749895;

    public static final double PHI_RECIPROCAL = 1.0 / PHI;

    public static final BigDecimal BIG_SQRT_5 = new BigDecimal(SQUARE_ROOT_5);

    public static final BigDecimal BIG_PHI = new BigDecimal(PHI);

    public static final BigDecimal BIG_PHI_RECIPROCAL = new BigDecimal(PHI_RECIPROCAL);

    public static final BigInteger BIG_ZERO = new BigInteger(new byte[] { 0 });

    public static final BigInteger BIG_ONE = new BigInteger(new byte[] { 1 });

    public static long fib (int n)
    {
        if (n <= 0) {
            return 0;
        }
        // after this point, the long starts to overflow
        if (n > 92) {
            throw new IllegalArgumentException("Cannot fit Fibonacci result into a long.");
        }
        long result = 0;
        long prev = 1;
        for (int i = 1; i <= n; i++) {
            result += prev;
            prev = result - prev;
        }
        return result;
    }

    public static long fibEstimate (int n)
    {
        if (n <= 0) {
            return 0;
        }
        if (n == 1) {
            return 1;
        }
        // after this point, the long starts to overflow
        if (n > 70) {
            throw new IllegalArgumentException("Cannot estimate for valuse over 70.");
        }
        return Math.round((Math.pow(PHI, n) - Math.pow(PHI_RECIPROCAL, n)) / SQUARE_ROOT_5);
    }

    public static BigInteger bigFib (int n)
    {
        if (n <= 0) {
            return BIG_ZERO;
        }
        if (n == 1) {
            return BIG_ONE;
        }
        BigDecimal result = BIG_PHI.pow(n);
        result = result.subtract(BIG_PHI_RECIPROCAL.pow(n));
        result = result.divide(BIG_SQRT_5, MathContext.DECIMAL128);
        // round
        result = result.setScale(0, BigDecimal.ROUND_HALF_UP);
        return result.toBigInteger();
    }

    public static void main (String[] args)
    {
        for (int i = 0; i <= 92; i++) {
            System.out.println(i + "\t= " + fib(i));
        }
    }
}
