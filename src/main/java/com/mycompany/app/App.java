package com.mycompany.app;/*
 klasu com.mycompany.app.App koja ima main methodu koja
  parsira ulaz s konzole iz parametra args i vrši njegovu validaciju.
 */



public class App {
    /*
    This is main method of this Application
    @author Nejra Strsevic
     */
    public static void main(String[] args){

      StringBuilder str=new StringBuilder();
      for(int i=0; i<args.length; ++i){
          if(i!=0)
              str.append(" ");
          str.append(args[0]);
      }
      String result=str.toString();
        try{


            System.out.println("The result of this arithmetic expression is: "+ ExpressionEvaluator.evaluate(result));


        }catch(RuntimeException exception){
            System.out.println("This arithmetic expression is not valid.");
        }
    }

    }

