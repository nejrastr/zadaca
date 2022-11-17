/*
 klasu App koja ima main methodu koja
  parsira ulaz s konzole iz parametra args i vrši njegovu validaciju.
 */

import com.mycompany.app.ExpressionEvaluator;
import org.w3c.dom.ls.LSInput;

public class App {
    /*
    This is main method of this Application
    @author Nejra Strsevic
     */
    public static void main(String[] args){

        String s=args[0];
        /*
        This method trim() eliminates leading and trailing spaces.
         */
        s.trim();
        try{
            ExpressionEvaluator expression=new ExpressionEvaluator();
            Double result=expression.evaluate(s);
            System.out.println("The result of this arithmetic expression is: ");
            System.out.println(result);

        }catch(RuntimeException e){
            System.out.println("This arithmetic expression is not valid.");
        }
    }

    }

