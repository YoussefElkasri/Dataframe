package GroupeY;

<<<<<<< HEAD
public class Insertdata {
    
=======
import java.util.*;

public class Insertdata {

    String data;
   // HashMap<?, ?> datas = new HashMap<Object,Object>();
    StringBuilder sb=new StringBuilder();
    ArrayList<String> types=new ArrayList<String>();
    private HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
    public Insertdata(HashMap<String, ArrayList<String>> map){
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

    public ArrayList getData() {
        ArrayList<ArrayList<String>> data=new ArrayList<ArrayList<String>>();
        for(final String key : map.keySet()) {
            final ArrayList<String> value = map.get(key);
            data.add(value);
        }
        return data;
    }

    public ArrayList<String> getHeader(){
    	ArrayList<String> header=new ArrayList<String>();
        for(final String key : map.keySet()) {
            header.add(key);
        }
        return header;
    }
  
    	        
   
>>>>>>> 903e5c35e3ecfdf3a4bb48d65dcb0355ab994ac1
}
