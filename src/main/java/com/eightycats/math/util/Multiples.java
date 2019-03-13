/**
 * Copyright 2018 Matthew A Jensen <eightycats@gmail.com>
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

public class Multiples
{
    /**
     * Checks to see if the given factor evenly divides the value.
     * @param value the value to check.
     * @param factor the factor.
     * @return true if factor divides the value with no remainder.
     */
    public static boolean isMultiple (int value, int factor)
    {
        return value % factor == 0;
    }
}
