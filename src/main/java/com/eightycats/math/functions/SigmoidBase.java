package com.eightycats.math.functions;

/**
 * Based sigmoid code.
 */
public abstract class SigmoidBase
    implements Function
{
    protected double _lambda = 1.0;

    public double getLambda ()
    {
        return _lambda;
    }

    public void setLambda (double lambda)
    {
        _lambda = lambda;
    }

    public static double sigmoid (double value)
    {
        return sigmoid(value, 1.0);
    }

    public static double sigmoid (double value, double lambda)
    {
        value *= -1;
        return 1 / (1 + Math.pow(Math.E, (value * lambda)));
    }
}
