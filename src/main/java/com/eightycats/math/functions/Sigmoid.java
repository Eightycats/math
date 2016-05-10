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
