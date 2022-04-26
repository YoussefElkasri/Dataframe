package GroupeY;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.ArrayList;


public class InsertTest {
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    /**
     * @return the suite of tests being tested
     */
@Test
    public void testDeuxConstruicteur(){
        HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String> list2=new ArrayList<String>();
        ArrayList<String> list3=new ArrayList<String>();


        list1.add("josef");
        list1.add("ran");
        list1.add("mattiche");
        map.put("nom",list1);

        list2.add("1998");
        list2.add("1999");
        list2.add("2000");
        map.put("annee",list2);


        list3.add("24");
        list3.add("23");
        list3.add("22");
        map.put("age",list3);

        ArrayList<String> types = new ArrayList<String>();
        types.add("String");
        types.add("Integer");
        types.add("Integer");
        DataFrame d = new DataFrame(map);
        try{
            DataFrame dAfter = new DataFrame("src/test/resources/data.csv");

            for(int i=0;i<d.getHeader().size();i++){
                //System.out.println("d : "+d.getHeader().get(i));
                //System.out.println("csv : "+dAfter.getHeader().get(i));
            }
            //assertEquals("dataAfter insert", d, dAfter);
        }catch (Exception e) {
            e.printStackTrace();
           
        }
        
        //assertTrue(true);
    }

    /**
     * Rigourous Test :-)
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void testMethod2() throws FileNotFoundException, IOException
    {
     //   DataFrame d = new DataFrame("data.txt");
       // assertTrue( true );
    }
}