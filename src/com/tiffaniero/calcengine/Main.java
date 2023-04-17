package com.tiffaniero.calcengine;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        performCalculation();

        Divider divider = new Divider();
        doCalcultation(divider, 100.0d, 50.0d);
        Adder adder = new Adder();
        doCalcultation(adder, 25.0d, 92.0d);

        performMoreCalculation();

        executeInteractively();

        dynamicInteractivity();
    }

    private static void dynamicInteractivity() {
        DynamicHelper helper = new DynamicHelper(new MathProcessing[]{
                new Adder(),
                new PowerOf()
        });

        System.out.println("Enter an operation and two numbers: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();

        helper.process(userInput);
    }


    private static CalculateBase createCalculation(MathOperation operation, double leftValue, double rightValue){
        CalculateBase calculation = null;
        switch (operation){
            case ADD:
                calculation = new Adder(leftValue, rightValue);
                break;
            case SUBSTRACT:
                calculation = new Substracter(leftValue, rightValue);
                break;
            case MULTIPLY:
                calculation = new Multiplier(leftValue, rightValue);
                break;
            case DIVIDE:
                calculation = new Divider(leftValue, rightValue);
                break;
        }
        return calculation;
    }

    

    private static void doCalcultation(CalculateBase calculation, double leftValue, double rightValue){
        calculation.setLeftValue(leftValue);
        calculation.setRightValue(rightValue);
        calculation.calculate();
        System.out.println("Calculation result = " + calculation.getResult());
    }

    static void performCalculation(){
        MathEquation[] equations = new MathEquation[4];
        equations[0] = new MathEquation('d', 50.0d, 100.0);
        equations[1] = new MathEquation('a', 92.0d,25.0d);
        equations[2] = new MathEquation('m', 17.0d,225.0d);
        equations[3] = new MathEquation('s', 11.0d,3.0d);


        for (MathEquation equation : equations) {
            equation.execute();
            System.out.println("Result = " + equation.getResult());
        }

        System.out.println("Average result = " + MathEquation.getAverageResult());

        System.out.println();
        System.out.println("Using execute overloads");
        System.out.println();

        MathEquation equationOverload = new MathEquation('d');
        double leftDouble = 9.0d;
        double rightDouble = 4.0d;
        equationOverload.execute(leftDouble, rightDouble);
        System.out.println("Overload result with doubles: " + equationOverload.getResult());

        int leftInt = 9;
        int rightInt = 4;
        equationOverload.execute(leftInt, rightInt);
        System.out.println("Overloaded result with ints: " + equationOverload.getResult());
    }

    private static void performMoreCalculation(){
        CalculateBase[] calculations = {
                new Divider(100.d, 50.0d),
                new Adder(25.0d, 92.0d),
                new Substracter(225.0d, 17.0d),
                new Multiplier(11.0d, 3.0d)
        };

        System.out.println();
        System.out.println("Array Calculations");

        for (CalculateBase calculation : calculations){
            calculation.calculate();
            System.out.println("result = " + calculation.getResult());
        }

    }

    static void executeInteractively(){
        System.out.println("Enter an operation and two numbers: ");
        Scanner sc = new Scanner(System.in);
        String userInput = sc.nextLine();
        String[] parts = userInput.split(" ");
        performOperation(parts);
    }

    private static void performOperation(String[] parts) {
        MathOperation operation = MathOperation.valueOf(parts[0].toUpperCase());
        double leftValue = Double.parseDouble(parts[1]);
        double rightValue = Double.parseDouble(parts[2]);
        CalculateBase calculation = createCalculation(operation, leftValue, rightValue);
        calculation.calculate();
        System.out.println("Operation performed: " + operation);
        System.out.println(calculation.getResult());
    }
}