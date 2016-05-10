package com.eightycats.math.functions;

public class SigmoidDerivative extends SigmoidBase
{
    public SigmoidDerivative ()
    {
        this(1.0);
    }

    public SigmoidDerivative (double lambda)
    {
        setLambda(lambda);
    }

    @Override
    public double apply (double value)
    {
        double sigmoid = sigmoid(value, getLambda());
        return getLambda() * (1 - sigmoid) * sigmoid;

    }

    public static void main (String[] args)
    {
        FunctionProcessor.dump(new SigmoidDerivative());
    }
}
