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
 * Hyperbolic tangent function. S shaped function.
 *
 */
public class Tanh implements Function, Derivable
{
    private static final Tanh instance = new Tanh();

    public TanhDerivative derivative = TanhDerivative.getInstance();

    public static double tanh (double value)
    {
        /*
         // this is the long version
         return ( Math.pow( Math.E, value ) - Math.pow( Math.E, -value) ) /
                ( Math.pow( Math.E, value ) + Math.pow( Math.E, -value ) );
         */

        double e2x = Math.exp(2 * value);
        return (e2x - 1) / (e2x + 1);
    }

    public static Tanh getInstance ()
    {
        return instance;
    }

    /**
     * Apply the tanh function to the given input value and return the result. This defines the
     * Function interface.
     */
    @Override
    public double apply (double value)
    {
        return tanh(value);
    }

    @Override
    public Function getDerivative ()
    {
        return derivative;
    }

    public static void main (String[] args)
    {
        FunctionProcessor.dump(getInstance());
    }
}
