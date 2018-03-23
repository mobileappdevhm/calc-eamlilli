package de.eh.emiorin.taschenrechner;

import java.util.ArrayList;

/**
 * Created by emiorin on 22.03.2018.
 */

public class Calculator {

    boolean numAdded;
    boolean oopAdded;

    Calculator(){
        numAdded = false;
        oopAdded = true;
    }


    ArrayList<Double> numbers = new ArrayList<Double>();
    ArrayList<String> operators = new ArrayList<String>();


    public void addNumber(double number){
        if(oopAdded){
            numbers.add( number);

        }
        oopAdded = false;
        numAdded = true;
    }

    public void addOp(String operator){
        if(numAdded){
            operators.add(operator);

        }
        oopAdded = true;
        numAdded = false;
    }

    public void NumbersToString() {
        for (int i = 0;i<numbers.size();i++){
            System.out.println(numbers.get(i));
        }
    }
    public void clearAll(){
        numbers.clear();
        operators.clear();
        numAdded = false;
        oopAdded = true;
    }

    public double calculate(){
        int counterOperator = 0;
        double sum = numbers.get(0);
        double tmp2;

        for(int i = 1; i < numbers.size(); i++){
            String operator;
            // ALG geht die ArrayListe durch!

            tmp2 = numbers.get(i);
            operator = operators.get(counterOperator);
            if(operator == "+"){
                sum = sum + tmp2;
            }
            if(operator == "-"){
                sum = sum - tmp2;
            }
            if(operator == "*") {
                sum = sum * tmp2;
            }
            if(operator == "/"){
                if (tmp2 == 0) {
                    // gehts nicht!!!
                    sum = 0;
                    break;
                } else {
                    sum = sum / tmp2;
                }
            }
            counterOperator++;
        }



        return sum;
    }

}
