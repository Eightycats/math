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

package com.eightycats.math.tiling;

/**
 * Represents one feature or dimension of the input to be encoded by tile coding.
 */
public class TilingDimension
{
    protected long tileCount;

    protected double offset;

    protected double minValue;

    protected double maxValue;

    protected double tileWidth;

    /**
     *
     * @param tileCount
     *            the number of tiles that this dimension should be divided up into.
     * @param offset
     *            the offset of the first tile from the minValue.
     * @param minValue
     *            the minimum possible value for input values.
     * @param maxValue
     *            the maximum possible value for input values.
     */
    public TilingDimension (long tileCount, double offset, double minValue, double maxValue)
    {
        this.tileCount = tileCount;
        this.offset = offset;
        this.minValue = minValue;
        this.maxValue = maxValue;

        tileWidth = maxValue - minValue / tileCount;
    }

    public long getTile (double value)
    {
        if (value < minValue || value > maxValue) {
            throw new IllegalArgumentException("The value [" + value + "] is not in range ["
                + minValue + ", " + maxValue + "]");
        }

        // shift value over by the offset
        value -= offset;

        // if the offset value is less than the
        // minimum possible value, then add
        // the value range to it so as to
        // wrap the value around
        while (value < minValue) {
            value += (maxValue - minValue);
        }

        // get the value as a percentage
        // of the possible value range
        double percent = (value - minValue) / (maxValue - minValue);

        // multiply this percentage times the
        // tile count to get the index of the
        // tile that contains the given value
        int index = (int) Math.floor(percent * tileCount);

        return index;
    }

    public double getMaxValue ()
    {
        return maxValue;
    }

    public double getMinValue ()
    {
        return minValue;
    }

    public double getOffset ()
    {
        return offset;
    }

    public long getTileCount ()
    {
        return tileCount;
    }

    public double getTileWidth ()
    {
        return tileWidth;
    }
}
