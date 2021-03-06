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
