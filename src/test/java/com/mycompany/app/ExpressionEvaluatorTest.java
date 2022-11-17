package com.mycompany.app;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
ExpressionEvaluator is class that check our algorithm and its logic
 */
public class ExpressionEvaluatorTest {

    ExpressionEvaluator expression=new ExpressionEvaluator();


    @Test
    void Test1(){
        String str="( ( 1 + 1 ) * ( 2 + 2 ) )";
        assertEquals(8D, expression.evaluate(str));
    }






}
