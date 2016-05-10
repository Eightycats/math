package com.eightycats.math.functions;

/**
 * Derivate function of tanh.
 */
public class TanhDerivative implements Function
{
    private static TanhDerivative instance = new TanhDerivative();

    public static TanhDerivative getInstance ()
    {
        return instance;
    }

    @Override
    public double apply (double value)
    {
        return 1 - Math.pow(Tanh.tanh(value), 2);
    }

    public static void main (String[] args)
    {
        FunctionProcessor.dump(new TanhDerivative());
    }
}
