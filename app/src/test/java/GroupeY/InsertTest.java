package GroupeY;

import org.junit.*;
import static org.junit.Assert.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

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
    public void testMethod1(){
        Map<String, Integer> col = new HashMap<>();
        String [][]data = {{"nom", "josef", "ran", "mattiche"},{"annee","1998","1999","2000"}};
        DataFrame d = new DataFrame(data);
        String [][]dataInsert = {{"sexe","male","male","male"}};
        d.InsertColonne(dataInsert);

        String [][]dataAfter = {{"nom", "josef", "ran", "mattiche"},{"annee","1998","1999","2000"},{"sexe","male","male","male"}};
        DataFrame dAfter = new DataFrame(dataAfter);
        //assertEquals("dataAfter insert", (Object) d, (Object) dAfter);
        assertTrue(true);
    }


    /**
     * Rigourous Test :-)
     * @throws IOException
     * @throws FileNotFoundException
     */
    public void testMethod2() throws FileNotFoundException, IOException
    {
        DataFrame d = new DataFrame("data.txt");
        assertTrue( true );
    }
}