package GroupeY;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.xml.crypto.Data;

public class DataFrame {

    private ArrayList<String> type;
    private ArrayList<ArrayList<String>> values;
    public DataFrame(HashMap<String, ArrayList<String>> map){
        Insertdata d = new Insertdata(map);
        values = d.getData();
        type = d.getType();
    }

    public DataFrame(String nomFichier) throws FileNotFoundException, IOException{
        Csvtodata d = new Csvtodata(nomFichier);
        values = d.getData();
        type = d.getType();

    }

    /*public DataFrame(HashMap<String, ArrayList<String>> map, ArrayList<String> type ){
        this.map = map;
        this.type = type;
    }*/


    public void InsertColonne(String [][] data){

    }

    public void InsertLigne(String [][] data){

    }

    public void AfficheDataFrame(){

    }

    public void AfficheLesPrem(int n){

    }

    public void AfficheLesDer(int n){

    }

    /**
     * fonction qui calcule la somme des elements d'une colonne
     */
    public float sum(int ind){
        float sum = 0;
        switch (type.get(ind)){
            
            case "Float" :  
                for(String s : values.get(ind)){
                    sum = Float.parseFloat(s) + sum;
                }
                break;
            case "Integer" :  
                for(String s : values.get(ind)){
                    sum = Integer.parseInt(s) + sum;
                }
                break;
            default :
                System.err.println("type de colonne non convenable");
                break;
       }

       return sum;
    }

    /**
     * fonction qui calcule la moyenne d'une colonne
     */
    public float moyenne(int ind){
        float s = sum(ind);
        return s/values.get(ind).size();
    }

    /**
     * foction qui calcule le minium d'une colonne
     */
    public float min(int ind){
        float min  = Float.parseFloat(values.get(ind).get(0));
        switch (type.get(ind)){
            
            case "Float" :  
                for(String s : values.get(ind)){
                   
                    return Math.min(Float.parseFloat(s), min);
                }
                break;
            case "Integer" :  
                for(String s : values.get(ind)){
                    
                    return Math.min(Integer.parseInt(s),min);
                }
                break;
            default :
                System.err.println("type de colonne non convenable");
                break;
    }
        return min;

    }

    /**
     * fonction qui calcule le max d'une colonne
     */
    public float max(int ind){
        float max = Float.parseFloat(values.get(ind).get(0));
        switch (type.get(ind)){
            
            case "Float" :  
                for(String s : values.get(ind)){
                    max = Math.max(Float.parseFloat(s), max);
                }
                break;
            case "Integer" :  
                for(String s : values.get(ind)){
                    max = Math.max(Integer.parseInt(s),max);
                }
                break;
            default :
                System.err.println("type de colonne non convenable");
                break;
    }
        return max;
    }

    /**
     * fonction qui calcule le nombre d'element dans une colonne
     */
    public int count(int ind){
        return values.get(ind).size();
    }

    /**
     * fonction qui calcule la valeur absolue de chaque element d'une colonne donnee
     */
    public float[] abs(int ind){
        float[] fl = new float[count(ind)];
        switch (type.get(ind)){
            
            case "Float" :  
                int i =0;
                for(String s : values.get(ind)){
                    fl[i] = Math.abs(Float.parseFloat(s));
                    i++;
                }
                break;
            case "Integer" :  
                int j =0;
                for(String s : values.get(ind)){
                    fl[j] = Math.abs(Integer.parseInt(s));
                    j++;
                }
                break;
            default :
                System.err.println("type de colonne non convenable");
                break;
    }
    return fl;
    }

    /*public DataFrame creationcol(String[] st){

    }*/
}