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

import java.util.ArrayList;
import java.util.List;

public class Combinations
{

    public static <T> List<List<T>> generate (List<T> values,  int k)
    {
        List<List<T>> results = new ArrayList<List<T>>();
        List<T> currentCombo = new ArrayList<T>(k);
        for (int i = 0; i < k; i++) {
            currentCombo.add(values.get(i));
        }
        generate(values, 0, values.size() - 1, currentCombo, 0, k, results);
        return results;
    }

    protected static <T> void generate (List<T> input,  int inputStart,
        int inputEnd, List<T> currentCombo, int currentIndex, int k, List<List<T>> results)
    {
        if (currentIndex == k) {
            // make a copy and add it to the results
            results.add(new ArrayList<T>(currentCombo));
        } else {
            for (int i = inputStart; i <= inputEnd && inputEnd - i + 1 >= k - currentIndex; i++) {
                currentCombo.set(currentIndex, input.get(i));
                generate(input, i + 1, inputEnd, currentCombo, currentIndex + 1, k, results);
            }
        }
    }

    public static <T> List<List<T>> generate2 (List<T> values, int k)
    {
        List<List<T>> results = new ArrayList<List<T>>();
        if (k == 1) {
            for (int i = 0; i < values.size(); i++) {
                List<T> result = new ArrayList<T>();
                result.add(values.get(i));
                results.add(result);
            }
        } else {
            while (!values.isEmpty()) {
                // remove current element, so we are no longer a candidate
                T current = values.remove(0);
                List<List<T>> sublists = generate2(new ArrayList<T>(values), k - 1);
                for (List<T> result : sublists) {
                    result.add(current);
                    results.add(result);
                }
            }
        }
        return results;
    }

    public static long getCombinationCount (int n, int k)
    {
        return Factorial.factorial(n) /
            (Factorial.factorial(k) *
                Factorial.factorial(n - k));
    }

    public static void main (String[] args)
    {
        List<Character> test = new ArrayList<Character>();
        for (char n = 'A'; n <= 'A' + 5; n++) {
            test.add(n);
        }

        int k = 3;
        List<List<Character>> results = generate(test, k);
        int count = 1;
        for (List<Character> combo : results) {
            System.out.println("[" + count + "] : " + combo);
            count++;
        }
        System.out.println("Expected: " + getCombinationCount(test.size(), k));
    }
}
