package com.eightycats.math.functions;

/**
 * Straight line.
 */
public class Linear implements Function
{
    /**
     * This is a passthrough method. It returns the given value.
     */
    @Override
    public double apply (double value)
    {
        return value;
    }

}
