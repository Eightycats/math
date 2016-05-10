package com.eightycats.math.functions;

/**
 * Applies a function to a set of inputs.
 */
public class FunctionProcessor
    implements Processor
{
    protected Function _function;

    public FunctionProcessor(Function function)
    {
        _function = function;
    }

    @Override
    public double[] process( double[] input )
    {
        double[] result = new double[1];
        result[0] = _function.apply( input[0] );
        return result;
    }

    public Function getFunction()
    {
        return _function;
    }

    public static void dump (Function function)
    {
        dump(function, -5.0, 5.0, .1);
    }

    /**
     * Convenience method for printing a range of function values.
     */
    public static void dump (Function function, double from, double to, double increment)
    {
        for (double value = from; value <= to; value += increment) {
            System.out.println(value + "," + function.apply(value));
        }
    }
}
