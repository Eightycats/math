package com.eightycats.math.selection;

/**
 *
 * TODO: not implemented.
 *
 *
 */
public class Softmax
{
    private double temperature;

    public Softmax()
    {
        this( .25 );
    }

    public Softmax( double temperature )
    {
        setTemperature( temperature );
    }

    public void setTemperature(double temperature)
    {
        this.temperature = temperature;
    }

    public double getTemperature()
    {
        return temperature;
    }

    public void add( Object object, double value )
    {

    }

}
