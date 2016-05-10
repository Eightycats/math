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

package com.eightycats.math.util;

import com.eightycats.math.normalization.UnitNormalization;

/**
 * This represents a range of double values from a minimum value to a max (inclusive of both).
 */
public class Range
{
    /**
     * A constant range from 0.0 to 1.0.
     */
    public static final Range UNIT_RANGE = new Range(0.0, 1.0);

    protected double _min;

    protected double _max;

    protected UnitNormalization normalizer;

    public Range (double minimum, double maximum)
    {
        _min = minimum;
        _max = maximum;
        normalizer = new UnitNormalization(getMin(), getMax());
    }

    public boolean contains (double value)
    {
        return value >= getMin() && value <= getMax();
    }

    /**
     * Throws an IllegalArgumentException if the value is not in range.
     */
    public void check (double value)
        throws IllegalArgumentException
    {
        if (!contains(value)) {
            throw new IllegalArgumentException("Value [" + value + "] is not in range " + this);
        }
    }

    public double getMin ()
    {
        return _min;
    }

    public double getMax ()
    {
        return _max;
    }

    /**
     * Returns the difference between the minimum and maximum values.
     */
    public double getLength ()
    {
        return _max - _min;
    }

    /**
     * This returns the given value as a percentage of this range. This is useful for normalizing
     * values to a range of 0.0 to 1.0. The given input value must be within this range.
     */
    public double getPercentOfRange (double value)
    {
        check(value);
        return normalizer.normalize(value);
    }

    @Override
    public String toString ()
    {
        return "[" + getMin() + "-" + getMax() + "]";
    }
}
