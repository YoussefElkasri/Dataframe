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
     * Comparez les deux méthodes de construction pour voir si elles sont identiques
     * Un est ajouté manuellement et un autre est ajouté via un fichier csv.
     * @result Valid si elles sont identique
     */

@Test
    public void testDeuxConstruicteur(){
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String> list2=new ArrayList<String>();
        ArrayList<String> list3=new ArrayList<String>();

        list1.add("nom");
        list1.add("josef");
        list1.add("ran");
        list1.add("mattiche");
        map.put(0,list1);

        list2.add("annee");
        list2.add("1998");
        list2.add("1999");
        list2.add("2000");
        map.put(1,list2);


        list3.add("age");
        list3.add("24");
        list3.add("23");
        list3.add("22");
        map.put(2,list3);

        ArrayList<String> types = new ArrayList<String>();
        types.add("String");
        types.add("Integer");
        types.add("Integer");
        DataFrame d = new DataFrame(map);
        try{
            DataFrame dAfter = new DataFrame("src/test/resources/data.csv");
            assertEquals("dataAfter insert", d, dAfter);
        }catch (Exception e) {
            e.printStackTrace();
           
        }
        
        //assertTrue(true);
    }

    /**
     * @throws IOException
     * @throws FileNotFoundException
     */

    /**
     * Insert une ligne dans un dataframe
     * Comparez avec un autre fichier complet avec cette ligne déjà ajoutée
     * @result Valid si elles sont identique
    **/

    @Test
    public void testInsertLigne() throws FileNotFoundException, IOException
    {
        ArrayList<String> list1=new ArrayList<String>();
        ArrayList<String> list2=new ArrayList<String>();
        ArrayList<String> list3=new ArrayList<String>();
        ArrayList<ArrayList< String>> list=new ArrayList<ArrayList< String>>();

        list1.add("toto");
        list2.add("2001");
        list3.add("21");
        list.add(list1);
        list.add(list2);
        list.add(list3);
       try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            DataFrame dAfter = new DataFrame("src/test/resources/dataAddLigne.csv");
            d.InsertLigne(list);
            assertEquals("testInsertLigne", d, dAfter);
        }catch (Exception e) {
            e.printStackTrace();
           
        }
        
       // assertTrue( true );
    }

    /**
     * Insert une colonne dans un dataframe
     * Comparez avec un autre fichier complet avec cette colonne déjà ajoutée
     * @result Valid si elles sont identique
    **/

    @Test
        public void testInsertColonne() throws FileNotFoundException, IOException
    {
        ArrayList<String> list=new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();

        list.add("address");
        list.add("Grenoble");
        list.add("Paris");
        list.add("Lyon");
        map.put(0, list);
        ArrayList<String> types = new ArrayList<String>();
        types.add("String");
       try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            DataFrame dAfter = new DataFrame("src/test/resources/dataAddColonne.csv");
            d.InsertColonne(map, types);
            assertEquals("testInsertLigne", d, dAfter);
        }catch (Exception e) {
            e.printStackTrace();
           
        }
        
    }

    /**
     * Insert une colonne dans un dataframe mais avec une mal header
     * Comparez avec un autre fichier complet avec cette colonne déjà ajoutée
     * @result Valid si elles ne sont pas identique
    **/
    @Test
        public void testNegInsertColonne() throws FileNotFoundException, IOException
    {
        ArrayList<String> list=new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();

        list.add("addressF");
        list.add("Grenoble");
        list.add("Paris");
        list.add("Lyon");
        map.put(0, list);
        ArrayList<String> types = new ArrayList<String>();
        types.add("String");
       try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            DataFrame dAfter = new DataFrame("src/test/resources/dataAddColonne.csv");
            d.InsertColonne(map, types);
            assertFalse(d.equals(dAfter));
        }catch (Exception e) {
            e.printStackTrace();
           
        }
        
    }

    /**
     * Insert une colonne dans un dataframe mais avec une mal donne
     * Comparez avec un autre fichier complet avec cette colonne déjà ajoutée
     * @result Valid si elles ne sont pas identique
    **/

    @Test
    public void testNegInsertColonne2() throws FileNotFoundException, IOException
    {
        ArrayList<String> list=new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();

        list.add("address");
        list.add("Grenoble?");
        list.add("Paris");
        list.add("Lyon");
        map.put(0, list);
        ArrayList<String> types = new ArrayList<String>();
        types.add("String");
       try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            DataFrame dAfter = new DataFrame("src/test/resources/dataAddColonne.csv");
            d.InsertColonne(map, types);
            assertFalse(d.equals(dAfter));
        }catch (Exception e) {
            e.printStackTrace();
           
        }
        
    }

    /**
     * test pour le fonction equals qui est override dans le DataFrame
     * Comparez l'objet null avec un instance
     * @result Valid si elles ne sont pas identique
    **/

    @Test
        public void testNull() throws FileNotFoundException, IOException
    {
       try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            DataFrame dnull = null;
            assertFalse(d.equals(dnull));
        }catch (Exception e) {
            e.printStackTrace();
           
        }
        
    }

    /**
     * test pour le fonction equals qui est override dans le DataFrame
     * Comparez s'ils ont un nombre différent de lignes ou de colonnes. 
     * @result Valid si elles ne sont pas identique
    **/

    @Test
        public void testNeg() throws FileNotFoundException, IOException
    {
       try{
            DataFrame d = new DataFrame("src/test/resources/data.csv");
            DataFrame d2 = new DataFrame("src/test/resources/dataAddColonne.csv");
            DataFrame d3 = new DataFrame("src/test/resources/dataAddLigne.csv");
            assertFalse(d.equals(d2));
            assertFalse(d2.equals(d3));
            assertFalse(d.equals(d3));
        }catch (Exception e) {
            e.printStackTrace();
           
        }
        
    }

}