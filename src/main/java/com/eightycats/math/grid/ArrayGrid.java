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

import java.util.Arrays;

/**
 * Grid implemented by a 2D int array.
 */
public class ArrayGrid
    implements Grid
{
    protected int[][] _grid;

    protected int _width;

    protected int _height;

    public ArrayGrid(int width, int height)
    {
       this(width, height, 0);
    }

    public ArrayGrid(int width, int height, int defaultValue)
    {
       _grid = new int[width][height];
       _width = width;
       _height = height;
       reset( defaultValue );
    }

    public void reset( int value )
    {
        for (int x = 0; x < getWidth(); x++) {
            Arrays.fill( _grid[x], value );
        }
    }

    @Override
    public int get(int x, int y)
    {
        return _grid[x][y];
    }

    @Override
    public void set(int x, int y, int value)
    {
        _grid[x][y] = value;
    }

    @Override
    public int getWidth()
    {
        return _width;
    }

    @Override
    public int getHeight()
    {
        return _height;
    }

    @Override
    public boolean contains(int x, int y)
    {
        return x > 0 && x < getWidth() && y > 0 && y < getHeight();
    }

    /**
     * TODO
     * @return Grid
     */
    @Override
    public Grid copy()
    {
        return null;
    }

    /**
     * TODO
     * @return Grid
     */
    @Override
    public String serialize()
    {
        return "";
    }
}
