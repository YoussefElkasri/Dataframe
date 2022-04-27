package GroupeY;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.File;

/**
 * Unit test for simple App.
 */
public class ArithmetiqueTest 
{
    @Test
    public void sumTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            float res = d.sum(3);
            assertEquals(res, 23430.5, 0.5);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

        @Test
    public void sumIntTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            int res = (int)d.sum(2);
            assertEquals(res, 69);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void moyenneTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            float res = d.moyenne(3);
            assertEquals(res, 36.6, 0.2);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Test
    public void minTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            float res = d.min(3);
            assertEquals(res, 4, 0.1);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

            @Test
    public void minIntTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            int res = (int)d.min(2);
            assertEquals(res, 22);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void maxTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            float res = d.max(3);
            assertEquals(res, 112.9, 0.1);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

        @Test
    public void maxIntTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            int res = (int)d.max(2);
            assertEquals(res, 24);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void countTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            float res = d.count(3);
            assertEquals(res, 640, 0);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void absTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            float[] res = d.abs(5);
            for(int i=0;i<res.length;i++){
                assertTrue(res[i]>=0);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void absIntTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            float[] res = d.abs(2);
            for(int i=0;i<res.length;i++){
                assertTrue(res[i]>=0);
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }


    @Test
    public void afficheTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            d.AfficheDataFrame();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void afficheLesPreTest(){
        System.out.println("############## afficheLesPreTest ##############");
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            d.AfficheLesPrem(3);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void afficheLesDerTest(){
        try{
            System.out.println("############## afficheLesDerTest ##############");

            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            d.AfficheLesDer(10);
        }catch (Exception e) {
            e.printStackTrace();
        }
    }
}
