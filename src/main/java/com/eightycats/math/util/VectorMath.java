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

package com.eightycats.math.util;

/**
 * Some vector operations for a vector of double values.
 */
public abstract class VectorMath
{
    /**
     * Get the length (magnitude) of the given vector.
     */
    public static double vectorLength (double[] values)
    {
        double sum = 0.0;
        int dimension = values.length;
        for (int i = 0; i < dimension; i++) {
            // add the square of each value
            sum += Math.pow(values[i], 2);
        }
        return Math.sqrt(sum);
    }

    /**
     * Normalize the given vector to length 1.0 (unit vector).
     */
    public static void normalize (double[] vector)
    {
        ArrayUtils.scale(vector, 1.0 / vectorLength(vector));
    }

    /**
     * This returns the dot product of the given vectors.
     *
     * @exception IndexOutOfBoundsException
     *                if the vectors are not the same length.
     */
    public static double dot (double[] vector, double[] vector2)
        throws IndexOutOfBoundsException
    {
        double sum = 0.0;
        int dimension = vector.length;
        for (int i = 0; i < dimension; i++) {
            sum += vector[i] * vector2[i];
        }
        return sum;
    }

}
