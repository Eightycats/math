package com.eightycats.math.normalization;

/**
 * Interface for normalizing input values (to a certain range, etc.).
 */
public interface Normalizer
{
    public double normalize (double value);

    public double[] normalize (double[] inputs);
}
