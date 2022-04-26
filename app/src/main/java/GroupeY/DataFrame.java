package GroupeY;

import java.util.ArrayList;
import java.util.HashMap;

public class DataFrame {

    private HashMap<Integer, ArrayList<String>> map;
    private ArrayList<String> type=new ArrayList<String>();
    private ArrayList<ArrayList<String>> data=new ArrayList<ArrayList<String>>();
    private ArrayList<String> header=new ArrayList<String>();
    public DataFrame(HashMap<Integer, ArrayList<String>> mapdata){
       Insertdata d = new Insertdata(mapdata);
        data = d.getData();
        type = d.getType();
        header = d.getHeader();
        this.map=mapdata;
    }

    public DataFrame(String nomFichier){
   //    Csvtodata d = new Csvtodata("nomFichier");
//        map = d.getData();
//        type = d.getType();
    }
  

    public void InsertColonne(HashMap<Integer, ArrayList<String>> hmap, ArrayList<String> types) {

        for(int i=0;i<types.size();i++){
            type.add(types.get(i));
        }
        //System.out.println(" datas"+datas.toString());
      
        for(final Integer key : hmap.keySet()) {
            final ArrayList<String> value = hmap.get(key);
            map.put(key,value);
            for(ArrayList<String> ar : hmap.values()){
                header.add(ar.get(0));
            }
            ArrayList<String> list;
            for(ArrayList<String> a2 : hmap.values()){
                list = new ArrayList<>(a2);
                list.remove(0);
                data.add(list);
            }
            //data.add(value);
        }
    }

    public void InsertLigne(ArrayList<ArrayList<String>> datas){

        System.out.println(" datas"+datas.toString());
      
        for(int i=0;i<datas.get(0).size();i++){     
                for(int j=0;j<header.size();j++){                   
                    data.get(j).add(datas.get(j).get(i));                
                }
            }
    }

    public void AfficheDataFrame(){
        int l=0;
        String key="    ";
        String value="    ";

       for (int i=0;i<header.size();i++) {
        key=key.concat("    "+header.get(i));   
        }
        System.out.println("  "+key);

        for(int i=0;i<data.get(0).size();i++){
            
                value="";
                
                for(int j=0;j<data.size();j++){    
                    value=value.concat("    "+data.get(j).get(i));
             
                }
                System.out.println("  "+l+value);
                l++;
            }

    }

    public void AfficheLesPrem(int n){

        int l=0;
        String key="    ";
        String value="    ";
        

       for (int i=0;i<header.size();i++) {
        key=key.concat("    "+header.get(i));   
        }
        System.out.println("    "+key);

        for(int i=0;i<n;i++){           
                value="     ";
                for(int j=0;j<data.size();j++){    
                    value=value.concat("    "+data.get(j).get(i));
             
                }
                System.out.println(" "+l+value);
                l++;
            }


    }

    public void AfficheLesDer(int n){

        int l=header.size()-n;
        String key="    ";
        String value="    ";

       for (int i=0;i<header.size();i++) {
        key=key.concat("    "+header.get(i));   
        }
        System.out.println("    "+key);
    
            value="     ";
            for(int i=data.get(0).size()-n;i<data.get(0).size();i++){
                    value="     ";
                    for(int j=0;j<header.size();j++){  
                     
                            value=value.concat("    "+data.get(j).get(i));
                
                    }
                    System.out.println(" "+l+value);
                    l++;
                    
                }
            

    }



    public void groupby(ArrayList<String> criteres, String op){

        
    }

}