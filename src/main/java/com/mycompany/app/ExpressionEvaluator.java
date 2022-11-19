package com.mycompany.app;



import java.lang.reflect.Array;
import java.util.Stack;
/**
* ExpressionEvaluator class uses two Stacks to implement Dijkstra algorithm
* @author Nejra Strsevic
 */
public class ExpressionEvaluator {

    /**
     * Method evaluate() calculates value of expression using Dijkstra algorithm
     * @param s parametar
     * @return double vrijednost
     */
    public static double evaluate(String s) {

    /**
     * two Stacks for implementation, one for operators and one stack for values
     */
    Stack<String> operators = new Stack<String>();
    Stack<Double> values = new Stack<Double>();
    /**
     * The string split() method breaks a given string around matches of the given regular expression

     */
    String[] array = s.split(" ");
    for (String s1 : array) {
        /**
         * The Java String class equals() method compares the two given strings based on the content of the string
         * push(E element) method is used to push an element into the Stack
         * The pop() method removes the last element from an array and returns that value to the caller
         */
        if (s1.equals("(")) {
        } else if (s1.equals("+")) operators.push(s1);
        else if (s1.equals("-")) operators.push(s1);
        else if (s1.equals("*")) operators.push(s1);
        else if (s1.equals("/")) operators.push(s1);
        else if (s1.equals("sqrt")) operators.push(s1);
        else if (s1.equals(")")) {
            String operations = operators.pop();
            Double value = values.pop();
            if (operations.equals("+")) value = values.pop() + value;
            else if (operations.equals("-")) value = values.pop() - value;
            else if (operations.equals("*")) value = values.pop() * value;
            else if (operations.equals("/")) value = values.pop() / value;
            else if (operations.equals("sqrt")) value = Math.sqrt(value);
            values.push(value);

        } else {
            try {
                values.push(Double.parseDouble(s1));

            } catch (RuntimeException ex) {
                throw new RuntimeException();
            }
        }
    }
    return values.pop();

}

}
