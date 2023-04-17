package com.tiffaniero.calcengine;

public class Divider extends CalculateBase implements MathProcessing{
    public Divider() {}

    public Divider(double leftValue, double rightValue) {
        super(leftValue, rightValue);
    }

    @Override
    public void calculate() {
        if (getLeftValue() > getRightValue()){
            double value = getLeftValue() /  getRightValue();
            setResult(value);
        } else {
            setResult(0.0d);
        }
    }

    @Override
    public String getKeyWord() {
        return "divide";
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        setLeftValue(leftValue);
        setRightValue(rightValue);
        calculate();
        return getResult();
    }
}
