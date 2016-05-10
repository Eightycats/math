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

package com.eightycats.math.average;

/**
 * Calculates an average of added values.
 */
public class IncrementalAverage
{
    /**
     * Number of values added so far.
     */
    protected double _count;

    /**
     * The current calculated average.
     */
    protected double _average;

    /**
     * Clears out the current average.
     */
    public void reset()
    {
        _count = 0.0;
        _average = 0.0;
    }

    /**
     * Adds a new sample value. Recalculates the average.
     */
    public void add( double value )
    {
        _count++;
        _average = _average + ( 1.0 / _count ) * (value - _average);
    }

    /**
     * Gets the number of values added.
     */
    public int getCount()
    {
        return (int) _count;
    }

    /**
     * Gets the average of all the values added so far.
     */
    public double getAverage()
    {
        return _average;
    }

    @Override
    public String toString()
    {
        return "[count="+getCount()+", average="+getAverage()+"]";
    }
}
