package com.eightycats.math.functions;

/**
 * This is an interface for classes that can take an array of
 * double inputs, perform some operation on them, and return
 * an array of results. The length of the output array does not
 * necessarily need to be the same as the input array.
 */
public interface Processor
{
    public double[] process( double[] input );
}
