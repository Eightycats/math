package com.eightycats.math.util;

import java.util.*;

/**
 * A set of functions for performing useful operations on arrays of double values.
 */
public abstract class ArrayUtils
{
    /**
     * This copies the given values into the new array of the given size.
     *
     * If the given values array is already of the correct size, then the values array itself is
     * returned unchanged.
     *
     * If the new size is smaller than previously, then not all values will get copied. If the new
     * size is larger, then the additional values will be zero.
     */
    public static double[] setLength (double[] values, int size)
    {
        if (values.length == size) {
            return values;
        }

        double[] newValues = new double[size];

        // init new value array to zero
        Arrays.fill(newValues, 0.0);

        System.arraycopy(values, 0, newValues, 0, size);

        return newValues;
    }

    public static double[] copy (double[] array)
    {
        int length = array.length;
        double[] values = new double[length];
        System.arraycopy(array, 0, values, 0, length);
        return values;
    }

    public static void copyInto (double[] source, double[] target)
    {
        int length = source.length;
        if (length > target.length) {
            setLength(target, length);
        }
        System.arraycopy(source, 0, target, 0, length);
    }

    /**
     * Set all values in the array to 0.
     */
    public static void zero (double[] array)
    {
        Arrays.fill(array, 0);
    }

    /**
     * Adds an array of offsets from the given values.
     */
    public static void add (double[] values, double[] offsets)
    {
        int count = Math.min(values.length, offsets.length);

        for (int index = 0; index < count; index++) {
            values[index] += offsets[index];
        }
    }

    /**
     * Subtracts an array of offsets from the given values.
     */
    public static void subtract (double[] values, double[] offsets)
    {
        int count = Math.min(values.length, offsets.length);

        for (int index = 0; index < count; index++) {
            values[index] -= offsets[index];
        }
    }

    /**
     * Multiplies every value of the given array the given factor.
     */
    public static void scale (double[] array, double factor)
    {
        int count = array.length;

        for (int i = 0; i < count; i++) {
            array[i] *= factor;
        }
    }

    /**
     * Multiplies each value in the array by the corresponding value in the given factors array.
     */
    public static void scale (double[] array, double[] factors)
    {
        int count = Math.min(array.length, factors.length);

        for (int i = 0; i < count; i++) {
            array[i] *= factors[i];
        }
    }

    /**
     * Compares the contents of two double arrays.
     */
    public boolean equals (double[] array, double[] other)
    {
        int length = array.length;

        // check if the arrays are the same size
        boolean equal = length == other.length;
        for (int i = 0; i < length && equal; i++) {
            equal = array[i] == other[i];
        }
        return equal;
    }

    /**
     * Return the given array values as a string. Useful for logging purposes.
     */
    public static String toString (double[] values)
    {
        return toString(values, " ");
    }

    public static String toString (double[] values, String delimiter)
    {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                result.append(delimiter);
            }
            result.append(values[i]);
        }
        return result.toString();
    }

    public static String toString (int[] values)
    {
        return toString(values, " ");
    }

    public static String toString (int[] values, String delimiter)
    {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                result.append(delimiter);
            }
            result.append(values[i]);
        }
        return result.toString();
    }

    public static String toString (long[] values)
    {
        return toString(values, " ");
    }

    public static String toString (long[] values, String delimiter)
    {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < values.length; i++) {
            if (i > 0) {
                result.append(delimiter);
            }
            result.append(values[i]);
        }
        return result.toString();
    }
}
