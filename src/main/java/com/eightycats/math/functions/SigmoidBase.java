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
