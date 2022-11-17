package com.mycompany.app;



import java.util.Stack;

public class ExpressionEvaluator {

public static double evaluate(String s) {
    /*
    two stacks for implementation one for operations and another one for values that are going to be used
    in operations
     */
    Stack<Character> operations = new Stack<Character>();
    Stack<Double> values = new Stack<Double>();

    char [] c=s.toCharArray();

    for(int i=0; i<c.length; i++){
        if(c[i]==' ')
            continue;
        /*
        if current simbol is whitespace,that it should be skipped
         */
        if(c[i]>='0' && c[i]<='9') {
            StringBuffer buff= new StringBuffer();
            /*
            if current simbol is number, push it to stack for numbers
             */
/*
It is also possible to have numbers with more than one digit
 */
            while (i < c.length && c[i] >= '0' && c[i] <= '9'){
                buff.append(c[i++]);
                values.push(Double.parseDouble(buff.
                        toString()));
                i--;

            }
        }
        /*
        if current simbol is opening brace push it to operations stack
         */
        else if(c[i]=='('){
            operations.push( c[i]);


        }
        /*
        current simbol can also be closing brace
         */
        else if(c[i]==')'){
            while (operations.peek() != '(')
                values.push(applyOperation(operations.pop(),
                        values.pop(),
                        values.pop()));
            operations.pop();


        }
        /*
        and the last possible scenario is that the simbol is one of four arithmetic operations
         */
        else if(c[i] == '+' || c[i] == '-' || c[i] == '*' || c[i] == '/'){
            while (!operations.empty() &&
                    hasPriority(c[i],
                            operations.peek()))
                values.push(applyOperation(operations.pop(),
                        values.pop(),
                        values.pop()));

            operations.push(c[i]);
        }

        }

    while(!operations.empty())
        values.push(applyOperation(operations.pop(),
                values.pop(),
                values.pop()));

    return values.pop();
}
/*
method that defines priority of operations
 */
    public static boolean hasPriority(
            double operation1, double operation2)
    {
        if (operation1 == '(' || operation2 == ')')
            return false;
        if ((operation1 == '*' || operation1 == '/') &&
                (operation2 == '+' || operation2 == '-'))
            return false;
        else
            return true;
    }
    /*
    method for applying operations on paramethers
     */
    public static double applyOperation(char operation,
                              double b, double a)
    {
        switch (operation)
        {
            case '+':
                return a + b;
            case '-':
                return a - b;
            case '*':
                return a * b;
            case '/':
                if (b == 0)
                    throw new
                            UnsupportedOperationException(
                            "Can't divide by zero");
                return a / b;
        }
        return  0;
    }
}
