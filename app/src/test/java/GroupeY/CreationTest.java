package GroupeY;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;
import java.io.File;

public class CreationTest 
{
    // DataFrame d;
    // @Before
    @Test
    public void CreationFromColTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            DataFrame newData = d.CreationFromCol("id", "city");
			newData.AfficheDataFrame();
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void CreationFromlineTest(){
        try{
            DataFrame d = new DataFrame("src/test/resources/annual_precipitation.csv");
            DataFrame newData = d.CreationFromline(1, 2, 3, 4, 5);
            newData.AfficheDataFrame();

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

}