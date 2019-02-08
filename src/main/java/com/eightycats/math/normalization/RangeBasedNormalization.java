/**
 * Copyright 2016 Matthew A Jensen <eightycats@gmail.com>
 *
 * Licensed under the Apache License, Version 2.0 (the "License"); you may not use this file except
 * in compliance with the License. You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software distributed under the License
 * is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express
 * or implied. See the License for the specific language governing permissions and limitations under
 * the License.
 */

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

    public double[] normalize (double[] inputs)
    {
        int length = inputs.length;
        double[] outputs = new double[length];

        for (int i = 0; i < length; i++) {
            outputs[i] = normalize(inputs[i]);
        }

        return outputs;
    }

    public double normalize (double input)
    {
        // get the input value as the percentage of the
        // difference between the max and min possible inputs
        double output = (input - _minInput) / (_maxInput - _minInput);

        // Multiply this ratio times the difference
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
        for (double d = -10; d <= 15; d += .5) {
            double[] input = new double[] { d };
            System.out.println(d + " : " + normalizer.normalize(input)[0]);
        }
    }
}
