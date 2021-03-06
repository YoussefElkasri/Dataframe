package GroupeY;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.io.PrintStream;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.xml.crypto.Data;

/**
 * Classe principale du dataframe
 */
public class DataFrame {

    private ArrayList<String> type;
    private ArrayList<ArrayList<String>> values;
    private ArrayList<String> header;

    /**
     * Constructeur à partir de données entrées manuellement
     * @param map : map contenant les données
     */
    public DataFrame(HashMap<Integer, ArrayList<String>> map){
        Insertdata d = new Insertdata(map);
        values = d.getData();
        type = d.getType();
        header = d.getHeader();
    }

    /**
     * Constructeur à partir d'un fichier csv
     * @param nomFichier path vers le fichier csv
     * @throws FileNotFoundException
     * @throws IOException
     */
    public DataFrame(String nomFichier) throws FileNotFoundException, IOException{
        Csvtodata d = new Csvtodata(nomFichier);
        values = d.getData();
        type = d.getType();
        header = d.getHeader();

    }

    /**
     * Constructeur 
     * @param map map contenant les données
     * @param type arraylist contenant le type de chaque colonne
     * @param header arraylist contenant le nom de chaque colonne
     */
    public DataFrame(HashMap<Integer, ArrayList<String>> map, ArrayList<String> type, ArrayList<String> header ){
        this.values = new ArrayList<ArrayList<String>>(map.values());
        this.type = type;
        this.header = header;
    }


    @Override
    public boolean equals(Object object){
        DataFrame d = (DataFrame) object;
        if(this!=null && d==null){
            return false;
        }
        if(this.getHeader().size()!= d.getHeader().size()){
            return false;
        }
        for(int i=0;i<header.size();i++){
            if(!this.header.get(i).equals(d.getHeader().get(i))){
                return false;
            }
        }
        for(int i=0;i<header.size();i++){
            if(this.getValues().get(i).size()!= d.getValues().get(i).size()){
                return false;
            }
            for(int j=0;j<this.values.get(i).size();j++){
                if(!this.values.get(i).get(j).equals(d.getValues().get(i).get(j))){
                    return false;
                }
            }   
        }
        return true;
    }
  

    /**
     * Fonction qui insert une colonne dans le dataframe
     * @param hmap map contenant les données qu'on veut ajouté
     * @param types arraylist contenant le type de chaque colonne qu'on veut ajouté
     */
    public void InsertColonne(HashMap<Integer, ArrayList<String>> hmap, ArrayList<String> types) {

        for(int i=0;i<types.size();i++){
            type.add(types.get(i));
        }
      
        for(final Integer key : hmap.keySet()) {
            final ArrayList<String> value = hmap.get(key);
            for(ArrayList<String> ar : hmap.values()){
                header.add(ar.get(0));
            }
            ArrayList<String> list;
            for(ArrayList<String> a2 : hmap.values()){
                list = new ArrayList<>(a2);
                list.remove(0);
                values.add(list);
            }
            //data.add(value);
        }
    }

    /**
     * Fonction qui insert une ligne dans le dataframe
     * @param datas map contenant les données qu'on veut ajouté
     */
    public void InsertLigne(ArrayList<ArrayList<String>> datas){

        System.out.println(" datas"+datas.toString());
      
        for(int i=0;i<datas.get(0).size();i++){     
                for(int j=0;j<header.size();j++){                   
                    values.get(j).add(datas.get(j).get(i));                
                }
            }
    }
  
    /**
     * Fonction qui affiche le dataframe
     */
    public void AfficheDataFrame(){

        for(int i=0;i<values.size();i++){
            System.out.printf("%-30s",header.get(i));
        }
        System.out.format("\n");
        for(int i=0;i<values.get(0).size();i++){
            for(int j=0;j<values.size();j++){
                System.out.printf("%-30s", values.get(j).get(i));
            }
            System.out.format("\n");
        }

        System.out.println("Affiche les types");
        if(type!=null){
            for(int i=0;i<values.size();i++){
                System.out.printf("%-30s",type.get(i));
            }
            System.out.format("\n");
        }

    }

    /**
     * Fonction qui affiche les n premiéres lignes
     * @param n : nombres de lignes à afficher
     */
    public void AfficheLesPrem(int n){

        for(int i=0;i<values.size();i++){
            System.out.printf("%-30s",header.get(i));
        }
        System.out.format("\n");
        for(int i=0;i<n;i++){
            for(int j=0;j<values.size();j++){
                System.out.printf("%-30s", values.get(j).get(i));
            }
            System.out.format("\n");
        }
    }

    /**
     * Fonction qui affiche les n dérnieres lignes
     * @param n : nombre de lignes à afficher
     */
    public void AfficheLesDer(int n){
        for(int i=0;i<values.size();i++){
            System.out.printf("%-30s",header.get(i));
        }
        System.out.format("\n");
        for(int i=0;i<n;i++){
            for(int j=0;j<values.size();j++){
                System.out.printf("%-30s", values.get(j).get(this.count(0)-1-i));
            }
            System.out.format("\n");
        }
    }


    /**
     * fonction qui calcule la somme des elements d'une colonne
     * @param ind indice de la colonne
     * @return la somme des éléments de la colonne
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
     * @param ind : indice de la colonne
     * @return la moyenne des éléments de la colonne
     */
    public float moyenne(int ind){
        float s = sum(ind);
        return s/values.get(ind).size();
    }


    /**
     * foction qui calcule le minium d'une colonne 
     * @param ind indice de la colonne
     * @return minimum des éléments de la colonne
     */
    public float min(int ind){
        float min  = Float.parseFloat(values.get(ind).get(0));
        switch (type.get(ind)){
            
            case "Float" :  
                for(String s : values.get(ind)){
                   
                    min = Math.min(Float.parseFloat(s), min);
                }
                break;
            case "Integer" :  
                for(String s : values.get(ind)){
                    
                    min = Math.min(Integer.parseInt(s),min);
                }
                break;
            default :
                System.err.println("type de colonne non convenable");
                break;
    }
        return min;

    }


    /**
     * Fonction qui calcule le max d'une colonne
     * @param ind indice de la colonne
     * @return le maximum des éléments de la colonne
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
     * Fonction qui calcule le nombre d'elements dans une colonne
     * @param ind indice de la colonne
     * @return le nombre d'éléments de la colonne
     */
    public int count(int ind){
        return values.get(ind).size();
    }


    /**
     * fonction qui calcule la valeur absolue de chaque element d'une colonne 
     * @param ind indice de la colonne
     * @return tableau contenant les valeurs absolues de chaque colonne
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

    /**
     * 
     * @return retourn les noms de chaque colonne
     */
    public ArrayList<String> getHeader(){
        return this.header;
    }

    /**
     * 
     * @return retourn le type de chaque colonne
     */
    public ArrayList<String> getType(){
        return this.type;
    }

    /**
     * 
     * @return retourn les données du dataframe
     */
    public ArrayList<ArrayList<String>> getValues(){
        return this.values;
    }

    
    /**
     * Creation d'un nouveau dataframe a partie de noms de colonnes
     * @param noms tableau des noms des colonnes
     * @return nouveau dataframe
     */    
    public DataFrame CreationFromCol(String ... noms){
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> type = new ArrayList<String>();
        ArrayList<String> header = new ArrayList<String>();
        int j =0;
        int counter =0;
        for(String s : this.header){
            for(int i =0 ; i<noms.length; i++){
                if(s.equals(noms[i])){
                    map.put(j, values.get(counter));
                    type.add(this.type.get(counter));
                    header.add(this.header.get(counter));
                    j++;
                }
            }
            counter++;
        }
        return new DataFrame(map,type, header);

    }

 
    /**
     * creation d'un nouveau dataframe à partir d'indices de lignes
     * @param i tableau des indices de lignes
     * @return nouveau dataframe
     */
    public DataFrame CreationFromline(int ... i){
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer, ArrayList<String>>();
        ArrayList<String> type = new ArrayList<String>();
        ArrayList<String> header = new ArrayList<String>();


        for(int j=0; j<this.header.size(); j++){
            ArrayList<String> val =   new ArrayList<String>();
            for(int in : i){
                val.add(values.get(j).get(in));
            }
            map.put(j, val);
        }   


        type = this.type;
        header = this.header;
        return new DataFrame(map,type, header);
    }





}