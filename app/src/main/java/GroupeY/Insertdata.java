package GroupeY;

import java.util.*;
import java.util.Map.Entry;

public class Insertdata {


    ArrayList<String> types=new ArrayList<String>();
    ArrayList<ArrayList<String>> data=new ArrayList<ArrayList<String>>();
    ArrayList<String> header=new ArrayList<String>();
    private HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
    public Insertdata(HashMap<Integer, ArrayList<String>> map){
        this.map = map;
    }


    public Insertdata(){
        
    }


    public void setType(ArrayList<String> types){
        this.types = types;
    }
    
    public ArrayList getType(){
        return this.types;
    }

    public ArrayList<String> getHeader(){
        //ArrayList<String> header = new ArrayList<String>();
        for(ArrayList<String> ar : map.values()){
            header.add(ar.get(0));
        }
        return this.header;
    }
    
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
