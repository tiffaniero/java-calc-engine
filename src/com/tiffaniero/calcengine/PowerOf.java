package com.tiffaniero.calcengine;

public class PowerOf implements MathProcessing{
    private String formattedOutput;

    @Override
    public String getKeyWord() {
        return "power";
    }

    @Override
    public String getFormattedOutput(){
        return formattedOutput;
    }

    @Override
    public double doCalculation(double leftValue, double rightValue) {
        double product = Math.pow(leftValue, rightValue);
        formattedOutput = leftValue + " to the power of " + rightValue + " is " + product;
        return product;
    }
}
