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

import java.math.BigInteger;
import java.util.HashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class Primes
{
    /**
     * Cache of known prime values.
     */
    protected static final Set<Long> PRIMES = new HashSet<>();

    static {
        // seed with a couple small known primes
        PRIMES.add(2L);
        PRIMES.add(3L);
        PRIMES.add(5L);
    }

    public static void initCache (long max)
    {
        // skip even numbers
        for (long i = 3; i <= max; i += 2) {
            // checking isPrime() will cache any successes
            isPrime(i);
            /*
            if (isPrime(i) != isReallyPrime(i)) {
                System.out.println("Discrepancy: " + i);
            }
            */
        }
    }

    public static void dumpCache ()
    {
        SortedSet<Long> sortedPrimes = new TreeSet<>(PRIMES);
        for (long prime : sortedPrimes) {
            System.out.println(prime);
        }
    }

    public static boolean isPrime (long value)
    {
        if (PRIMES.contains(value)) {
            return true;
        }

        BigInteger bigValue = new BigInteger(Long.toString(value));
        if (bigValue.isProbablePrime(100)) {
            PRIMES.add(value);
            return true;
        }
        return false;
    }

    /**
     * Brute force check to see is the given value is prime.
     */
    protected static boolean isReallyPrime (long value)
    {
        if (value <= 1) {
            return false;
        }

        if (value == 2) {
            return true;
        }

        // we only have to check up to the square root
        long maxCheck = (long)Math.ceil(Math.sqrt(value));

        // check for any factors that divide evenly into the value
        for (long check = 2; check <= maxCheck; check++) {
            if (value % check == 0) {
                return false;
            }
        }
        return true;
    }

    public static void main (String[] args)
    {
        initCache(100000);
        dumpCache();
    }
}
