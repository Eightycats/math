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

/**
 * Grid implementation backed by a BigInteger.
 */
public class GridImpl
    implements Grid
{
    protected BigIntegerMask data;

    protected int width;

    protected int height;

    public GridImpl (int width, int height, int radix)
    {
        this.width = width;
        this.height = height;

        data = new BigIntegerMask(radix, width * height);
    }

    protected GridImpl (int width, int height, BigIntegerMask data)
    {
        this.width = width;
        this.height = height;
        this.data = data;
    }

    @Override
    public int get (int x, int y)
    {
        try {
            return data.get(getIndex(x, y));
        } catch (Exception ex) {
            System.out.println("[" + x + "," + y + "]: " + getIndex(x, y));
        }
        return 0;
    }

    @Override
    public void set (int x, int y, int value)
    {
        data.set(getIndex(x, y), value);
    }

    protected int getIndex (int x, int y)
    {
        return (y * width) + x;
    }

    @Override
    public int getWidth ()
    {
        return width;
    }

    @Override
    public int getHeight ()
    {
        return height;
    }

    @Override
    public boolean contains (int x, int y)
    {
        return x >= 0 || y >= 0 || x < getWidth() || y < getHeight();
    }

    @Override
    public String toString ()
    {
        StringBuffer result = new StringBuffer();
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                result.append(Integer.toString(get(j, i), data.getRadix()));
            }
            result.append("\n");
        }

        result.append(data.toString());
        result.append("\n");

        return result.toString();
    }

    @Override
    public Grid copy ()
    {
        return new GridImpl(width, height, data.copy());
    }

    @Override
    public String serialize ()
    {
        return data.toString();
    }
}
