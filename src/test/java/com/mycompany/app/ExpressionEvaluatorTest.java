package com.mycompany.app;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
/*
ExpressionEvaluator is class that check our algorithm and its logic
 */
 class ExpressionEvaluatorTest {


    ExpressionEvaluator expression=new ExpressionEvaluator();



    @Test
    /*
    Test for multiplication
     */
    void TestMnozenje(){
        String str="( ( 1 + 1 ) * ( 2 + 2 ) )";
        assertEquals(8D, expression.evaluate(str));
    }
    @Test
    /*
    Test for sqrt()
     */
    void TestSqrt(){
        String str="( ( sqrt 49 ) * 5 )";
        assertEquals(35D, expression.evaluate(str));

    }
    @Test
    /*
    Test for checking if there is incorrect number of operands
     */
    void TestOperands(){
        String str="( 8 * ( 5 + ( - ) ) - 5)";
        assertThrows(RuntimeException.class,()-> expression.evaluate(str));
    }
@Test
/*
Test for empty strings
 */
    void TestEmpty(){
        String str=("");
        assertThrows(RuntimeException.class,() -> expression.evaluate(str));

}

@Test
/*
division testing

 */
    void TestEvaluate(){
        String str="( ( ( 2 / 2 ) * 10 ) + 5 ) ";
        assertEquals(15, expression.evaluate(str));

}

@Test
/*
This test tests if operands are not used correctly
 */
    void TestIncorrectUsage(){
        String str="( 19 * 2 + () )";
        assertThrows(RuntimeException.class, ()->expression.evaluate(str));
}

 }
