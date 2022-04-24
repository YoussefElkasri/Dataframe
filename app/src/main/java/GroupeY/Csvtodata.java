package GroupeY;

import java.io.*;
import java.util.*;
public class Csvtodata {

	private HashMap<String, ArrayList<String>> map1 = new HashMap<String,ArrayList<String>>();
    private HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
    private ArrayList<String> types = new ArrayList<String>();    
    private ArrayList<ArrayList<String>> ar = new ArrayList<ArrayList<String>>();
    
    
    
    /*Constructeur de CSVtodata
     * 
     * On lit un fichier csv graçe à son path 
     * Et on stock les données dans une hashmap qui as comme key le numéro de colonne et value la ligne entant qu'arraylist de string
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

    	        
    	        
    //fonction qui vérfie si l'element est un int
     private boolean isInt(String str) {

        try {
            Integer.parseInt(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    
    
     //fonction qui vérfie si l'element est float
    private boolean isFloat(String str) {

        try {
           Float.parseFloat(str);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    	
    
    //fonction qui vérifie si l'element est bool
    private boolean isBool(String str) {
    	if(str.toLowerCase().equals("true") || str.toLowerCase().equals("false")) {
    		return true;
    	}else {
    		return false;
    	}
    }
    
    
    //fonction qui retourn les données
    public HashMap getData() {
    	HashMap<Integer, ArrayList<String>> map2 = new HashMap<Integer, ArrayList<String>>(map);
		int i =0;
    	for(ArrayList<String> a2 : map.values()){
			a2.remove(0);
			map2.put(i,a2);
			i++;
		}
		System.out.println(map2.get(0).toString());
    	return map2;
    }
    
    
    //fonction qui retourn les types de chaque colonne
    public ArrayList<String> getType(){
    	return this.types;
    }
    
    
    //fonction qui retourne le nom de chaque colonne
    public ArrayList<String> nomColonne(){
    	return this.map.get(0);
    }
     
}