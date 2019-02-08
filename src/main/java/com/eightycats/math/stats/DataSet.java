package com.eightycats.math.stats;

import com.eightycats.math.functions.LinearEquation;

import java.util.ArrayList;
import java.util.List;

public class DataSet {
    protected List<Double> values = new ArrayList<>();

    public DataSet() {
    }

    public DataSet(double[] values) {
        add(values);
    }

    /**
     * Clears out the current values.
     */
    public void reset() {
        values.clear();
    }

    /**
     * Adds a new sample value.
     */
    public void add(double value) {
        values.add(value);
    }

    public void add(double[] values) {
        for (double value : values) {
            add(value);
        }
    }

    public double getValue(int index) {
        return values.get(index);
    }

    /**
     * Gets the number of values added.
     */
    public int getCount() {
        return values.size();
    }

    public double getSum() {
        double sum = 0.0;
        for (Double value : values) {
            sum += value;
        }
        return sum;
    }

    /**
     * Gets the mean of all the values added so far.
     */
    public double getAverage() {
        return  getSafeAverage(getSum());
    }

    protected double getSafeAverage(double sum) {
        int count = getCount();
        if (count == 0) {
            return 0.0;
        }
        return sum / getCount();
    }

    public double getStandardDeviation() {
        double mean = getAverage();
        double squaredDeviationTotal = 0.0;
        for (Double value : values) {
            double delta = value - mean;
            delta = Math.pow(delta, 2);
            squaredDeviationTotal += delta;
        }
        return Math.sqrt(getSafeAverage(squaredDeviationTotal));
    }

    public LinearEquation getLinearRegression() {
        double[] array = new double[values.size()];
        for (int i = 0; i < array.length; i++) {
            array[i] = values.get(i);
        }
        return LinearRegression.getRegression(array);
    }

    public static void main(String[] args) {
        DataSet data = new DataSet(new double[]{4, 9, 11, 12, 17, 5, 8, 12, 14});
        System.out.println("mean: " + data.getAverage());
        System.out.println("standard deviation: " + data.getStandardDeviation());
        System.out.println("regression: " + data.getLinearRegression());
    }

    @Override
    public String toString() {
        return "[count="+getCount()+", stats="+getAverage()+", std dev=" + getStandardDeviation() + "]";
    }

}
