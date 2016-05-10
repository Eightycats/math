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
 * A threshold function. Once a value makes it past a certain value, this will return the success
 * signal value. Otherwise, it will return the failue value.
 */
public class Threshold
    implements Function
{
    protected double _threshold;

    protected double _successValue = 1.0;

    protected double _failureValue = 0.0;

    public Threshold ()
    {
        this(0.0);
    }

    public Threshold (double threshold)
    {
        _threshold = threshold;
    }

    /**
     * Applies this function checking
     */
    @Override
    public double apply (double value)
    {
        if (value > _threshold) {
            return _successValue;
        }
        return _failureValue;
    }

    public double getFailureValue ()
    {
        return _failureValue;
    }

    public void setFailureValue (double failureValue)
    {
        _failureValue = failureValue;
    }

    public double getSuccessValue ()
    {
        return _successValue;
    }

    public void setSuccessValue (double successValue)
    {
        _successValue = successValue;
    }

    public double getThreshold ()
    {
        return _threshold;
    }

    public void setThreshold (double threshold)
    {
        _threshold = threshold;
    }

}
