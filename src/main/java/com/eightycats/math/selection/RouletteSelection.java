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

package com.eightycats.math.selection;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
 * A random, weighted selection.
 *
 * For example, if two objects are added, and one is given a weight of 10 and the other a weight of
 * 50, then the second object should be selected 5 times more often than the first..
 */
public class RouletteSelection<T>
{
    protected double _totalWeight = 0;

    protected Map<T, Possibility> _options = new HashMap<T, Possibility>();

    public void add (T option, int weight)
    {
        add(option, (double) weight);
    }

    public void add (T option, double weight)
    {
        _totalWeight += weight;
        _options.put(option, new Possibility(option, weight));
    }

    public T remove (T object)
    {
        T removed = null;
        Possibility possibility = _options.remove(object);
        if (possibility != null) {
            _totalWeight -= possibility.getWeight();
            removed = possibility.getItem();
        }
        return removed;
    }

    public double getProbability (T option)
    {
        double result = 0.0;
        Possibility item = _options.get(option);
        if (item != null) {
            result = item.getProbability();
        }
        return result;
    }

    public double getWeight (T option)
    {
        double result = 0.0;
        Possibility item = _options.get(option);
        if (item != null) {
            result = item.getWeight();
        }
        return result;
    }

    /**
     * This randomly picks an Object from the list of added objects. The odds of a particular object
     * being returned are proportional to the weight value that was given when the object was added.
     */
    public T select ()
    {
        double probability = 0.0;
        double selected = Math.random();

        for (Possibility possibility : _options.values()) {
            probability += possibility.getProbability();
            if (selected < probability) {
                return possibility.getItem();
            }
        }
        // should not get here
        throw new RuntimeException("Roulette Selection ran out of possible options.");
    }

    @Override
    public String toString ()
    {
        StringBuilder result = new StringBuilder();
        for (Entry<T, Possibility> entry : _options.entrySet()) {
            result.append(entry.getKey());
            result.append(" : [");
            Possibility possibility = entry.getValue();
            result.append(possibility.getProbability());
            result.append("]\n");
        }
        return result.toString();
    }

    protected class Possibility
    {
        protected T _item;

        protected double _weight = 0.0;

        public Possibility (T item, double weight) {
            _item = item;
            _weight = weight;
        }

        public T getItem () {
            return _item;
        }

        public double getWeight () {
            return _weight;
        }

        public double getProbability () {
            return _weight / _totalWeight;
        }
    }
}
