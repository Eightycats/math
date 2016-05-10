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
