package com.tiffaniero.calcengine;

public interface MathProcessing {

    String SEPARATOR = " ";
    String getKeyWord();
    double doCalculation(double leftValue, double rightValue);
    default String getFormattedOutput(){
        return null;
    }

}
