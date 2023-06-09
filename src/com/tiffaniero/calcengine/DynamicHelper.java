package com.tiffaniero.calcengine;

public class DynamicHelper {
    private final MathProcessing[] handlers;

    public DynamicHelper(MathProcessing[] handlers){
        this.handlers = handlers;
    }

    public void process(String statement) {
        String[] parts = statement.split(MathProcessing.SEPARATOR);
        String keyword = parts[0];
        double leftValue = Double.parseDouble(parts[1]);
        double rightValue = Double.parseDouble(parts[2]);

        MathProcessing theHandler = null;
        for (MathProcessing handler : handlers){
            if(keyword.equalsIgnoreCase(handler.getKeyWord())){
                theHandler = handler;
                break;
            }
        }

        double result = theHandler.doCalculation(leftValue, rightValue);
        String formattedOutput = theHandler.getFormattedOutput();
        if (formattedOutput != null)
            System.out.println(formattedOutput);
        else
            System.out.println("result = " + result);
    }
}
