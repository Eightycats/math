package com.eightycats.math.functions;

/**
 * A threshold function. Once a value makes it past a certain value, this will return the success
 * signal value. Otherwise, it will return the failue value.
 */
public class Threshold
    implements Function
{
    protected double _threshold;

    protected double _successValue = 1.0;

    protected double _failureValue = 0.0;

    public Threshold ()
    {
        this(0.0);
    }

    public Threshold (double threshold)
    {
        _threshold = threshold;
    }

    /**
     * Applies this function checking
     */
    @Override
    public double apply (double value)
    {
        if (value > _threshold) {
            return _successValue;
        }
        return _failureValue;
    }

    public double getFailureValue ()
    {
        return _failureValue;
    }

    public void setFailureValue (double failureValue)
    {
        _failureValue = failureValue;
    }

    public double getSuccessValue ()
    {
        return _successValue;
    }

    public void setSuccessValue (double successValue)
    {
        _successValue = successValue;
    }

    public double getThreshold ()
    {
        return _threshold;
    }

    public void setThreshold (double threshold)
    {
        _threshold = threshold;
    }

}
