package com.kdotj.githookssample;

class CalculatorModel {

    String [] getSpinnerOptions(){
        return new String[] {"Add", "Subtract", "Multiply", "Divide"};
    }

    double addNumbers(double number1, double number2) {
        return number1 + number2;
    }

    double subtractNumbers(double number1, double number2) {
        return number1 - number2;
    }

    double multiplyTwoNumbers(double number1, double number2) {
        return number1 * number2;
    }

    double divideTwoNumbers(double number1, double number2) {
        return number1 / number2;
    }
}
