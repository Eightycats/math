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
 * Generates sine wave data.
 */
public class Wave
{
    protected double _period = 30;

    protected double _base;

    protected double _amplitude;

    protected double _count = 365;

    public void run ()
    {
        for (int i = 0; i < _count; i++) {
            double radians = Math.PI * 2 * (((i % _period) + 1) / _period);

            double sine = Math.sin(radians);
            sine *= _amplitude;
            sine += _base;

            System.out.println(i + "," + Math.toDegrees(radians) + "," + sine);
        }
    }

    public double getPeriod ()
    {
        return _period;
    }

    public void setPeriod (double period)
    {
        _period = period;
    }

    public double getBase ()
    {
        return _base;
    }

    public void setBase (double base)
    {
        _base = base;
    }

    public double getAmplitude ()
    {
        return _amplitude;
    }

    public void setAmplitude (double amplitude)
    {
        _amplitude = amplitude;
    }

    public void setCount (int count)
    {
        _count = count;
    }

    public static void main (String[] args)
    {
        Wave wave = new Wave();
        wave.setBase(0);
        wave.setAmplitude(1);
        wave.setCount(10000);
        wave.run();
    }
}
