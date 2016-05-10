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

/**
 * Implements simple Tile Coding functionality. Each tiling basically divides the ranges of input
 * values (dimensions) into a number of tiles. If a given input value falls within the width of a
 * tile, then that tile is said to contain that values. This class can be used to get the indices of
 * all tiles that contain an array of input values. Multiple, overlapping, slightly-offset tilings
 * are used in order to create generalization.
 *
 * @see http://www.cs.ualberta.ca/~sutton/book/8/node6.html
 */
public class TileCoding
{
    /**
     * The tilings used to encode input values.
     */
    private List<Tiling> _tilings = new ArrayList<Tiling>();

    public TileCoding (int tilingCount, long tilesPerDimension)
    {
        for (int i = 0; i < tilingCount; i++) {
            Tiling tiling = new Tiling(i, tilingCount, tilesPerDimension);
            _tilings.add(tiling);
        }
    }

    public void addDimension (double minValue, double maxValue)
    {
        for (int i = 0; i < getTilingCount(); i++) {
            getTiling(i).addDimension(minValue, maxValue);
        }
    }

    public int getTilingCount ()
    {
        return _tilings.size();
    }

    public Tiling getTiling (int index)
    {
        return _tilings.get(index);
    }

    public long[] getTiles (double[] inputs)
    {
        long[] tileIndices = new long[_tilings.size()];
        long tilingOffset = 0;
        for (int i = 0; i < getTilingCount(); i++) {
            tileIndices[i] = tilingOffset;
            Tiling tiling = getTiling(i);
            tileIndices[i] += tiling.getTile(inputs);
            tilingOffset += tiling.getTileCount();
        }
        return tileIndices;
    }

    public long getTileCount ()
    {
        long count = 0;
        for (int i = 0; i < getTilingCount(); i++) {
            count += getTiling(i).getTileCount();
        }
        return count;
    }
}
