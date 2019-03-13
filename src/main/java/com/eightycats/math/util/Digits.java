/**
 * Copyright 2018 Matthew A Jensen <eightycats@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */
package com.eightycats.math.util;

import java.math.BigInteger;

/**
 * Gets at the digits of a numeric value.
 */
public class Digits
{
    public static int getDigitCount (int value)
    {
        return (int) getDigitCount((long)value);
    }

    public static int getDigitCount (int value, int base)
    {
        return (int) getDigitCount((long)value, base);
    }

    public static long getDigitCount (long value)
    {
        return getDigitCount(value, 10);
    }

    public static long getDigitCount (long value, int base)
    {
        return (long) Math.floor(Logarithm.log(value, base)) + 1L;
    }

    public static int getDigit (int value, int place)
    {
        return (int)getDigit((long)value, (long)place, 10);
    }

    public static int getDigit (int value, int place, int radix)
    {
        return (int) getDigit((long)value, (long)place, radix);
    }

    public static long getDigit (long value, int place)
    {
        return getDigit(value, place, 10);
    }

    public static long getDigit (long value, long place, int radix)
    {
        return (long) (value / Math.pow(radix, place)) % radix;
    }

    public static int getDigitCount (BigInteger value)
    {
        return getDigitCount(value, 10);
    }

    public static int getDigitCount (BigInteger value, int base)
    {
        int count = 0;
        BigInteger bigBase = new BigInteger(Integer.toString(base));
        BigInteger zero = new BigInteger("0");
        while (value.compareTo(zero) > 0) {
            count++;
            value = value.divide(bigBase);
        }
        return count;
    }

    public static int getDigit (BigInteger value, int place)
    {
        return getDigit(value, place, 10);
    }

    public static int getDigit (BigInteger value, int place, int radix)
    {
        String radixString = Integer.toString(radix);
        BigInteger bigDigit = new BigInteger(radixString);
        bigDigit = bigDigit.pow(place);
        return value.divide(bigDigit).mod(new BigInteger(radixString)).intValue();
    }

    public static void main (String[] args)
    {
        int value = 123456789;
        int count = getDigitCount(value);
        System.out.println("Count: " + count);

        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + getDigit(value, i));
        }

        value = 0xABCDEF;
        count = getDigitCount(value, 16);
        System.out.println("Count: " + count);

        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + Integer.toHexString(getDigit(value, i, 16)));
        }

        BigInteger big = new BigInteger("93326215443944152681699238");
        count = getDigitCount(big);
        System.out.println("Count: " + count);
        for (int i = 0; i < count; i++) {
            System.out.println(i + ": " + getDigit(big, i));
        }
    }
}
