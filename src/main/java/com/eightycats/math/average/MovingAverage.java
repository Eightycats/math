package com.eightycats.math.average;

/**
 * Calculates the average of the last N values to be added.
 */
public class MovingAverage
{
    /**
     * A circular buffer of the values to be averaged.
     */
    protected double[] _values;

    /**
     * The index where the next added value will get set.
     */
    protected volatile int _index = 0;

    /**
     * How many sample values have been added? Basically just used to see if we are full yet.
     */
    protected int _valueCount = 0;

    public MovingAverage (int size)
    {
        _values = new double[size];
    }

    public boolean isFull ()
    {
        return getCount() >= getSize();
    }

    public int getSize ()
    {
        return _values.length;
    }

    public synchronized void add (double value)
    {
        _values[_index] = value;

        if (_valueCount < getSize()) {
            _valueCount++;
        }

        _index++;
        // wrap around
        _index %= getSize();
    }

    public double getSum ()
    {
        double sum = 0.0;
        for (int i = 0; i < getCount(); i++) {
            sum += _values[i];
        }
        return sum;
    }

    public double getAverage ()
    {
        return getSum() / getCount();
    }

    public int getCount ()
    {
        return isFull() ? getSize() : _valueCount;
    }
}
