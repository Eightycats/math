package com.eightycats.math.normalization;

/**
 * NOOP Normalizer.
 */
public class PassthroughNormalization
    implements Normalizer
{
    @Override
    public double[] normalize (double[] inputs)
    {
        return inputs;
    }

    /**
     * Returns the given value.
     */
    @Override
    public double normalize (double value)
    {
        return value;
    }
}
