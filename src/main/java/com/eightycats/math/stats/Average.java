package com.eightycats.math.stats;

public interface Average {
    void add(double value);

    default void add(double[] values) {
        for (double value : values) {
            add(value);
        }
    }

    int getCount();

    double getAverage();

    void reset();
}
