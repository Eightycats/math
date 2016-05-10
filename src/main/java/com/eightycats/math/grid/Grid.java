package com.eightycats.math.grid;

public interface Grid
{
    public int get (int x, int y);

    public void set (int x, int y, int value);

    public int getWidth ();

    public int getHeight ();

    public boolean contains (int x, int y);

    public Grid copy ();

    public String serialize ();
}
