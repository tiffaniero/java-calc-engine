package com.tiffaniero.calcengine;

public class Multiplier extends CalculateBase{
    public Multiplier() {}

    public Multiplier(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }
    @Override
    public void calculate() {
        double value = getLeftValue() * getRightValue();
        setResult(value);
    }
}
