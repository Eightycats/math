package com.eightycats.math.functions;

public class LinearEquation implements Function {
    protected double slope;

    protected double intercept;

    public LinearEquation(double slope, double intercept) {
        this.slope = slope;
        this.intercept = intercept;
    }

    public double getSlope() {
        return slope;
    }

    public void setSlope(double slope) {
        this.slope = slope;
    }

    public double getIntercept() {
        return intercept;
    }

    public void setIntercept(double intercept) {
        this.intercept = intercept;
    }

    @Override
    public double apply(double x) {
        return slope * x + intercept;
    }

    public String toString() {
        return "y = " + slope + " * x + " + intercept;
    }
}
