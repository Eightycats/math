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
