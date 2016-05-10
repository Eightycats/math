package com.eightycats.math.average;

/**
 * Calculates an average of added values.
 */
public class IncrementalAverage
{
    /**
     * Number of values added so far.
     */
    protected double _count;

    /**
     * The current calculated average.
     */
    protected double _average;

    /**
     * Clears out the current average.
     */
    public void reset()
    {
        _count = 0.0;
        _average = 0.0;
    }

    /**
     * Adds a new sample value. Recalculates the average.
     */
    public void add( double value )
    {
        _count++;
        _average = _average + ( 1.0 / _count ) * (value - _average);
    }

    /**
     * Gets the number of values added.
     */
    public int getCount()
    {
        return (int) _count;
    }

    /**
     * Gets the average of all the values added so far.
     */
    public double getAverage()
    {
        return _average;
    }

    @Override
    public String toString()
    {
        return "[count="+getCount()+", average="+getAverage()+"]";
    }
}
