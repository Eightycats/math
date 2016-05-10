package com.eightycats.math.util;

import java.util.concurrent.ThreadLocalRandom;

/**
 * Access to a thread safe random instance.
 */
public class RandomUtils
{
    protected static ThreadLocalRandom getRandom ()
    {
        return ThreadLocalRandom.current();
    }

    public static double random ()
    {
        return getRandom().nextDouble();
    }

    public static double randomInRange (double min, double max)
    {
        if (min > max) {
            throw new IllegalArgumentException("The minimum range value [" + min
                + "] is greater than the maximum " + "value [" + max + "].");
        }

        double range = max - min;
        double result = random();

        result *= range;
        result += min;

        return result;
    }

    public static int randomInt ()
    {
        return getRandom().nextInt();
    }

    public static int randomPositiveInt ()
    {
        return Math.abs(getRandom().nextInt());
    }
}
