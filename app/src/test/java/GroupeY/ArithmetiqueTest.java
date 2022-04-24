package GroupeY;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


/**
 * Unit test for simple App.
 */
public class ArithmetiqueTest 
{
    // DataFrame d;
    // @Before


    @Test
    public void sumTest(){
        try{
            DataFrame d = new DataFrame("/Users/cr/M1/DevOp/Dataframe/annual_precipitation.csv");
            float res = d.sum(3);
            assertEquals(res, 23430.5, 0.5);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
    @Test
    public void moyenneTest(){
        try{
            DataFrame d = new DataFrame("/Users/cr/M1/DevOp/Dataframe/annual_precipitation.csv");
            float res = d.moyenne(3);
            assertEquals(res, 36.6, 0.2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Test
    public void minTest(){
        try{
            DataFrame d = new DataFrame("/Users/cr/M1/DevOp/Dataframe/annual_precipitation.csv");
            float res = d.min(3);
            assertEquals(res, 4, 0.1);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void maxTest(){
        try{
            DataFrame d = new DataFrame("/Users/cr/M1/DevOp/Dataframe/annual_precipitation.csv");
            float res = d.max(3);
            assertEquals(res, 112.9, 0.1);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countTest(){
        try{
            DataFrame d = new DataFrame("/Users/cr/M1/DevOp/Dataframe/annual_precipitation.csv");
            float res = d.count(3);
            assertEquals(res, 640, 0);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


}
