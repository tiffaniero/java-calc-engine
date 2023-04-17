package com.tiffaniero.calcengine;

public class Adder extends CalculateBase implements MathProcessing{
    public Adder() {}

    public Adder(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public void calculate() {
        double value = getLeftValue() + getRightValue();
        setResult(value);
    }

    @Override
    public String getKeyWord() {
        return "add";
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        setLeftValue(leftValue);
        setRightValue(rightValue);
        calculate();
        return getResult();
    }
}
