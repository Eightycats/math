package com.eightycats.math.stats;

import com.eightycats.math.functions.LinearEquation;

import java.awt.geom.Point2D;

public class LinearRegression {

    public static LinearEquation getRegression(double[] values) {
        return getRegression(1, values.length, values);
    }

    public static LinearEquation getRegression(int startX, int endX, double[] values) {
        Point2D[] pairs = new Point2D[endX - startX + 1];
        for (int x = startX; x <= endX; x++) {
            pairs[x - startX] = new Point2D.Double(x, values[x - 1]);
        }
        return getRegression(pairs);
    }

    public static LinearEquation getRegression(double[][] values) {
        Point2D[] pairs = new Point2D[values.length];
        for (int i = 0; i <= values.length; i++) {
            pairs[i] = new Point2D.Double(values[i][0], values[i][1]);
        }
        return getRegression(pairs);
    }

    public static LinearEquation getRegression(Point2D[] values) {
        int count = values.length;
        double totalX = 0.0;
        double totalY = 0.0;
        for (int i = 0; i < count; i++) {
            totalX += values[i].getX();
            totalY += values[i].getY();
        }
        double avgX = totalX / count;
        double avgY = totalY / count;
        double deviationSum = 0.0;
        double squaredDeviationSum = 0.0;
        for (int i = 0; i < count; i++) {
            double deviation = values[i].getX() - avgX;
            deviationSum += deviation * (values[i].getY() - avgY);
            squaredDeviationSum += Math.pow(deviation, 2.0);
        }

        double slope = deviationSum / squaredDeviationSum;
        double offset = avgY - slope * avgX;
        return new LinearEquation(slope, offset);
    }
}
