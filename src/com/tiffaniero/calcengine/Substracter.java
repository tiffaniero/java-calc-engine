package com.tiffaniero.calcengine;

public class Substracter extends CalculateBase{
    public Substracter() {}

    public Substracter(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public void calculate() {
        double value = getLeftValue() - getRightValue();
        setResult(value);
    }
}
