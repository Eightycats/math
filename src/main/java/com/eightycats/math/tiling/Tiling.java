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

import java.util.ArrayList;
import java.util.List;

import com.eightycats.litterbox.logging.Logger;

/**
 * This class one offset tiling of a parameter.
 */
public class Tiling
{
    protected int _index;

    protected int _tilings;

    protected long _tilesPerDimension;

    protected List<TilingDimension> dimensions = new ArrayList<TilingDimension>();

    public Tiling (int tilingIndex, int totalNumberOfTilings, long tilesPerDimension)
    {
        _index = tilingIndex;
        _tilings = totalNumberOfTilings;
        _tilesPerDimension = tilesPerDimension;
    }

    /**
     * Gets the index of the tile that contains the given inputs.
     *
     * @param inputs
     *            the input values. The dimension of this array must be the same as the number of
     *            dimensions in this Tiling. For example, if this Tiling has 2 dimensions, then the
     *            inputs array must have a length of 2.
     */
    public long getTile (double[] inputs)
    {
        long index = 0;
        for (int dimension = 0; dimension < getDimensionCount(); dimension++) {
            long tile = getDimension(dimension).getTile(inputs[dimension]);
            tile = tile * (long) Math.pow(_tilesPerDimension, dimension);
            index += tile;
        }
        return index;
    }

    public long getTileCount ()
    {
        if (dimensions.size() == 0) {
            return 0;
        }

        long count = _tilesPerDimension;

        for (int i = 1; i < dimensions.size(); i++) {
            count *= _tilesPerDimension;
        }

        return count;
    }

    /**
     * This gets the number of dimensions encoded by this tiling.
     *
     * Each dimension represents one feature or parameter of the input.
     */
    public int getDimensionCount ()
    {
        return dimensions.size();
    }

    public TilingDimension getDimension (int dimensionIndex)
    {
        return dimensions.get(dimensionIndex);
    }

    public void addDimension (double minValue, double maxValue)
    {
        addDimension(_tilesPerDimension, minValue, maxValue);
    }

    public void addDimension (long tileCount, double minValue, double maxValue)
    {
        double range = maxValue - minValue;
        double tileWidth = range / tileCount;

        Logger.debug("Tiling[" + _index + "] Tile width: " + tileWidth);

        double resolution = tileWidth / _tilings;
        double offset = _index * resolution;
        // double offset = tileWidth / (double) tilings;

        Logger.debug("Tiling[" + _index + "] Offset: " + offset);

        TilingDimension dimension = new TilingDimension(_tilesPerDimension, offset, minValue,
            maxValue);

        dimensions.add(dimension);
    }
}
