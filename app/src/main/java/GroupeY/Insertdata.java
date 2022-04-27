package GroupeY;

import java.util.*;
import java.util.Map.Entry;


/** Class Insertdata 
     * La premiere methode d'insertion des donnees 
     */

public class Insertdata {


    ArrayList<String> types=new ArrayList<String>();
    ArrayList<ArrayList<String>> data=new ArrayList<ArrayList<String>>();
    ArrayList<String> header=new ArrayList<String>();
    private HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();

    /** Constructeur de Insertdata
     * @param : une hashmap qui a comme key : le numéro de colonne et value : la ligne de arraylist de string
     */
    public Insertdata(HashMap<Integer, ArrayList<String>> map){
        this.map = map;
    }

    /** Constructeur de Insertdata 2
     * ce constructeur est fait pour initialiser InsertData dans le main 
     * @param : il prend aucun parametre
     */
    public Insertdata(){
        
    }


    /**  fonction setType de type void : c'est pour enregistrer les types des donnees inserees
     * @param : elle prend en parametre une arraylist de string de stype
     */
    public void setType(ArrayList<String> types){
        this.types = types;
    }
    
    /** fonction getType c'est pour recuperer les types de dataframe
     * @param : elle prend aucun parametre 
     * @return : elle retourne une arraylist de types 
     */
    public ArrayList getType(){
        return this.types;
    }

    /** recuperer les nom de colonnes de dataframe
     */
    public ArrayList<String> getHeader(){
        //ArrayList<String> header = new ArrayList<String>();
        for(ArrayList<String> ar : map.values()){
            header.add(ar.get(0));
        }
        return this.header;
    }
    
     /** recuperer les donnees de dataframe
      * @param : elle prend aucun parametre 
     * @return : elle retourne une arraylist de donnees 
     */
    public ArrayList<ArrayList<String>> getData() {
        ArrayList<String> list;
        int i =0;
        for(ArrayList<String> a2 : map.values()){
            list = new ArrayList<>(a2);
            list.remove(0);
            data.add(list);
        }
        return data;
    }
   	        
   
}
