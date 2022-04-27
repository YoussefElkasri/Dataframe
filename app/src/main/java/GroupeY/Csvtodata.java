package GroupeY;

import java.io.*;
import java.lang.reflect.Method;
import java.util.*;
/**
*Class Csvtodata 
* La deuxiéme methode d'insertion des donnees 
*/
public class Csvtodata {

	private ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    private HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
    private ArrayList<String> types = new ArrayList<String>();    
    private ArrayList<ArrayList<String>> ar = new ArrayList<ArrayList<String>>();

    /**
     * Constructeur de CSVtodata
     * On lit un fichier csv graçe à son path 
     * Et on stock les données dans une hashmap qui a comme key le numéro de colonne et value la ligne entant qu'arraylist de string
     * @param nom : le path vers le fichier csv 
     * @throws FileNotFoundException
     * @throws IOException
     */

    public Csvtodata(String nom) throws FileNotFoundException, IOException{
    	String l = "";

    	        try{
    	            BufferedReader reader = new BufferedReader(new FileReader(nom));
    	            int i = 0;
    	            while((l = reader.readLine())!= null){
    	                String[] values = l.split(",");
    	                ar.add( new ArrayList<String>(Arrays.asList(values)));
    	                }
    	           
    	            int j =0;
    	            while(j < ar.get(0).size()) {
    	            	ArrayList<String> inte = new ArrayList<String>();
    	            for(ArrayList<String> st : ar) {
    	            	inte.add(st.get(j));
    	            }
    	            map.put(i, inte);
    	            i++;
    	            j++;
    	           }
    	        }catch (Exception e) {
    	            e.printStackTrace();
    	        }

    	        
    
    	        /**
    	         * On stocke les types de chaque colonne dans un arraylist
    	         * le type de chaque colonne est déterminé par le type du premier element de celle-ci
    	         */
    	       
				for(int i =0; i< ar.get(0).size(); i++) {

				
    	        String value = map.get(i).get(1);
    	        	
    	                	if(isInt(value)) {
    	                		types.add("Integer");
    	   
    	                	}else {
        	                	if(isFloat(value)) {
        	                		types.add("Float");

        	                	}else {
        	                		if(isBool(value)) {
        	                			types.add("boolean");

        	                		}else{
        	                			types.add("String");

        	                		}
        	                	}
    	                	}
    	                
					}
				

    }


	    
    /**
     *
     * @return le nom de chaque colonne 
     */
	public ArrayList<String> getHeader(){
		ArrayList<String> header = new ArrayList<String>();
		for(ArrayList<String> ar : map.values()){
			header.add(ar.get(0));
		}
		return header;
	}
		 
    	        
    	        
    /**
     * fonction qui vérfie si l'element est un int
     * @param str : le string qu'on veut tester
     * @return true si le string est un int et false sinon
     */
     private boolean isInt(String str) {

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    
    
    /**
     * fonction qui vérfie si l'element est float 
     * @param str : le string qu'on veut tester
     * @return true si le string est un float et false sinon
     */
    private boolean isFloat(String str) {

        try {
           Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    	
    
    
    /**
     * fonction qui vérifie si l'element est boolean 
     * @param str le string qu'on veut tester
     * @return true si le string est un boolean et false sinon
     */
    private boolean isBool(String str) {
    	if(str.toLowerCase().equals("true") || str.toLowerCase().equals("false")) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    
    /**
     * 
     * @return les données du csv
     */
    public ArrayList<ArrayList<String>> getData() {
		ArrayList<String> a3;
		int i =0;
    	for(ArrayList<String> a2 : map.values()){
			a3 = new ArrayList<>(a2);
			a3.remove(0);
			data.add(a3);
		}
    	return data;
    }
    
    
    /**
     * 
     * @return le type de donnée de chaque colonne
     */
    public ArrayList<String> getType(){
    	return this.types;
    }    

}