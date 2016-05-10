package com.eightycats.math.normalization;

/**
 * Scales inputs to the range between 0.0 to 1.0.
 */
public class UnitNormalization extends RangeBasedNormalization
{
    public static final double MIN_OUTPUT = 0.0;

    public static final double MAX_OUTPUT = 1.0;

    /**
     * @param minInput the minimum actual input value to expect.
     * @param maxInput the max actual input value to expect.
     */
    public UnitNormalization (double minInput, double maxInput)
    {
        super(minInput, maxInput, MIN_OUTPUT, MAX_OUTPUT);
    }
}
