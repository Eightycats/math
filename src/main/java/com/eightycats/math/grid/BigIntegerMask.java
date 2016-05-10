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

package com.eightycats.math.grid;

import java.math.BigInteger;

public class BigIntegerMask
{
    public static final int NO_MAX_SIZE = -1;

    /**
     * Basically the number of possible values allowed for each slot.
     */
    protected BigInteger _radix;

    /**
     * Stores values.
     */
    protected BigInteger _data;

    protected int _maxSize = NO_MAX_SIZE;

    public BigIntegerMask (int radix)
    {
        this(radix, NO_MAX_SIZE);
    }

    public BigIntegerMask (int radix, int maxSize)
    {
        this(radix, maxSize, BigInteger.valueOf(0));
    }

    protected BigIntegerMask (int radix, int maxSize, BigInteger data)
    {
        _radix = BigInteger.valueOf(radix);
        _maxSize = maxSize;
        _data = data;
    }

    public void set (int offset, int value)
    {
        validateOffset(offset);

        if (value < 0 || value >= getRadix()) {
            throw new IllegalArgumentException("The given value [" + value
                + "] must be between [0] and [" + getRadix() + "]");
        }

        // zero-out the current value at the given offset
        BigInteger currentValue = BigInteger.valueOf(get(offset));

        BigInteger shift = _radix.pow(offset);

        BigInteger shiftedCurrentValue = shift.multiply(currentValue);

        BigInteger temp = new BigInteger(_data.toByteArray());
        temp = temp.subtract(shiftedCurrentValue);

        BigInteger shiftedValue = shift.multiply(BigInteger.valueOf(value));

        _data = temp.add(shiftedValue);
    }

    public int get (int offset)
    {
        validateOffset(offset);

        BigInteger shift = _radix.pow(offset);

        // right-shift the digits so that the digit at the given
        // offset is now in the ones' column
        BigInteger shiftedData = _data.divide(shift);

        // get the mod of the shifted value. The remainder '
        // (the value in the ones' column) is the value
        // at the requested offset
        return shiftedData.mod(_radix).intValue();
    }

    protected void validateOffset (int offset)
    {
        if (offset < 0) {
            throw new IndexOutOfBoundsException("Offset [" + offset
                + "] must be greater or equal to zero.");
        }

        if (hasMaxSize() && offset >= _maxSize) {
            throw new IndexOutOfBoundsException("Offset [" + offset + "] must be less than ["
                + _maxSize + "]");
        }
    }

    public int getRadix ()
    {
        return _radix.intValue();
    }

    public int getMaxSize ()
    {
        return _maxSize;
    }

    public boolean hasMaxSize ()
    {
        return _maxSize != NO_MAX_SIZE;
    }

    @Override
    public String toString ()
    {
        return _data.toString(getRadix());
    }

    public BigInteger bigIntegerValue ()
    {
        return _data;
    }

    public BigIntegerMask copy ()
    {
        return new BigIntegerMask(_radix.intValue(), _maxSize, _data);
    }
}
