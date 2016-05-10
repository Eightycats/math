package com.eightycats.math.normalization;

/**
 * Scales a range of input values to a specific output range.
 */
public class RangeBasedNormalization
    implements Normalizer
{
    public static final double DEFAULT_MIN_OUTPUT = -1.0;

    public static final double DEFAULT_MAX_OUTPUT = 1.0;

    protected double _minInput;

    protected double _maxInput;

    protected double _minOutput;

    protected double _maxOutput;

    public RangeBasedNormalization (double minInput, double maxInput)
    {
        this(minInput, maxInput, DEFAULT_MIN_OUTPUT, DEFAULT_MAX_OUTPUT);
    }

    public RangeBasedNormalization (double minInput, double maxInput, double minOutput,
        double maxOutput)
    {
        _minInput = minInput;
        _maxInput = maxInput;
        _minOutput = minOutput;
        _maxOutput = maxOutput;
    }

    public double getMaxInput ()
    {
        return _maxInput;
    }

    public void setMaxInput (double maxInput)
    {
        _maxInput = maxInput;
    }

    public double getMaxOutput ()
    {
        return _maxOutput;
    }

    public void setMaxOutput (double maxOutput)
    {
        _maxOutput = maxOutput;
    }

    public double getMinInput ()
    {
        return _minInput;
    }

    public void setMinInput (double minInput)
    {
        _minInput = minInput;
    }

    public double getMinOutput ()
    {
        return _minOutput;
    }

    public void setMinOutput (double minOutput)
    {
        _minOutput = minOutput;
    }

    @Override
    public double[] normalize (double[] inputs)
    {
        int length = inputs.length;
        double[] outputs = new double[length];

        for (int i = 0; i < length; i++) {
            outputs[i] = normalize(inputs[i]);
        }

        return outputs;
    }

    @Override
    public double normalize (double input)
    {
        // get the input value as the percentage of the
        // difference between the max and min possible inputs
        double output = (input - _minInput) / (_maxInput - _minInput);

        // Multiply this ration times the difference
        // between the max and min possible outputs.
        // This scales the value to the output range.
        output *= (_maxOutput - _minOutput);

        // Add the minimum possible output
        // to put the value correctly within
        // the output range.
        output += _minOutput;

        return output;
    }

    public static void main (String[] args)
    {
        RangeBasedNormalization normalizer = new RangeBasedNormalization(0, 10, -1, 1);
        for (double d = -10; d <= 10; d += .5) {
            double[] input = new double[] { d };
            System.out.println(d + " : " + normalizer.normalize(input)[0]);
        }
    }
}
