package com.eightycats.math.functions;

/**
 * S-shaped sigmoid function. Positive numbers passed through this function approach a limit of 1.
 * Negative numbers approach 0.
 */
public class Sigmoid extends SigmoidBase implements Derivable
{
    public SigmoidDerivative derivative;

    public Sigmoid ()
    {
        this(1.0);
    }

    public Sigmoid (double lambda)
    {
        derivative = new SigmoidDerivative();
        setLambda(lambda);
    }

    @Override
    public double apply (double value)
    {
        return sigmoid(value, getLambda());
    }

    @Override
    public Function getDerivative ()
    {
        return derivative;
    }

    @Override
    public void setLambda (double lambda)
    {
        super.setLambda(lambda);
        derivative.setLambda(lambda);
    }

    public static void main (String[] args)
    {
        FunctionProcessor.dump(new Sigmoid());
    }
}
