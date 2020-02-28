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

/**
 * Utility functions to generate all the different permutations of items in a list.
 */
public class Permutations
{

    public static <T> List<List<T>> generate (List<T> items)
    {
        List<List<T>> results = new ArrayList<List<T>>();
        generate(items.size(), items, results);
        return results;
    }

    /**
     * Heap's algorithm.
     */
    protected static <T> void generate (int index, List<T> items, List<List<T>> results)
    {
        if (index <= 1) {
            // create a snapshot of the current permutation and add it to the results
            List<T> snapshot = new ArrayList<T>(items);
            results.add(snapshot);
        } else {
            for (int i = 0; i < index - 1; i++) {
                generate(index - 1, items, results);
                T temp = items.get(index - 1);
                int swapIndex;
                if (index % 2 == 0) {
                    swapIndex = i;
                } else {
                    swapIndex = 0;
                }
                // swap items
                items.set(index - 1, items.get(swapIndex));
                items.set(swapIndex, temp);
            }
            generate(index - 1, items, results);
        }
    }

    public static List<Long> generate (long digits)
    {
        List<Integer> items = new ArrayList<Integer>();
        // shift right by multiples of 10. chomp off last digit and add to the list of input values
        while (digits > 0) {
            items.add((int)(digits % 10));
            digits /= 10;
        }
        List<List<Integer>> permutations = generate(items);
        // recombine each list of digits into a long
        List<Long> results =  new ArrayList<>();
        for (List<Integer> permutation : permutations) {
            long output = 0L;
            for (Integer digit : permutation) {
                output *= 10;
                output += digit;
            }
            results.add(output);
        }
        return results;
    }

    public static void main (String[] args)
    {
        List<Integer> test = new ArrayList<>();
        for (int n = 1; n <= 4; n++) {
            test.add(n);
        }

        List<List<Integer>> results = generate(test);
        int count = 1;
        for (List<Integer> permutation : results) {
            System.out.println("[" + count + "] : " + permutation);
            count++;
        }
    }

}
