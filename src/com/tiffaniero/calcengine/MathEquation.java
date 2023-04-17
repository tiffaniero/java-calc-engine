package com.tiffaniero.calcengine;

public class MathEquation {
    private double leftValue;
    private double rightValue;
    private char opCode;
    private double result;

    private static int numberOfCalculations;
    private static double sumOfResults;

    public MathEquation(){}

    public MathEquation(char opCode){
        this.opCode = opCode;
    }

    public MathEquation(char opCode, double leftValue, double rightValue){
        this(opCode);
        this.leftValue = leftValue;
        this.rightValue = rightValue;
    }

    public double getLeftValue() {
        return this.leftValue;
    }
    public void setLeftValue(double leftValue) {
        this.leftValue = leftValue;
    }

    public double getRightValue() {
        return this.rightValue;
    }
    public void setRightValue(double rightValue) {
        this.rightValue = rightValue;
    }

    public double getResult() {
        return result;
    }

    public static double getAverageResult() {
        return sumOfResults / numberOfCalculations;
    }

    public double getOpcode() {
        return opCode;
    }
    public void setOpCode(char opCode) {
        this.opCode = opCode;
    }


    void execute() {
        switch (opCode) {
            case 'a':
                result = leftValue + rightValue;
                break;
            case 's':
                result = leftValue - rightValue;
                break;
            case 'm':
                result = leftValue * rightValue;
                break;
            case 'd':
                result = rightValue != 0 ? leftValue / rightValue : 0.0d;
                break;
            default:
                System.out.println("Invalid opCode: " + opCode);
                result = 0.0d;
                break;
        }

        numberOfCalculations++;
        sumOfResults += result;
    }

    public void execute(double leftValue, double rightValue) {
        this.leftValue = leftValue;
        this.rightValue = rightValue;

        execute();

        result = (int) result;
    }

}
