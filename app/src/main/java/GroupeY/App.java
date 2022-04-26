package GroupeY;


import java.io.Console;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.Iterator;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {   

        boolean exit=false;
        boolean exit_colonne=false;
        boolean exit_donnee=false;
       
        Insertdata id=new Insertdata();
        ArrayList<String> list=new ArrayList<String>();
        ArrayList<ArrayList<String>> list2=new ArrayList<ArrayList<String>>();
        ArrayList<String> types = new ArrayList<String>();
        HashMap<Integer, ArrayList<String>> map = new HashMap<Integer,ArrayList<String>>();
        //Insertdata Insdata=new Insertdata();
        System.out.println( "menu !" );
        System.out.println( "b- ajouter data !" );
        System.out.println( "q- quitter !" );
        Scanner sc=new Scanner(System.in);
        int i=0;
        while(!exit){
            String t=sc.nextLine();
                if(t.toString().equals("q")){
                    exit=true;
                    System.out.println("exit");
                }
                if(t.toString().equals("b")){
                  
                    while(!exit_donnee){
                        System.out.println("Add donnee sous format : nomCol1:[data1..dataN];nomCol2:[data1..dataN].. :");
                                   
                                int p=0;
                                Scanner input=new Scanner(System.in);                                                
                                String to=input.nextLine();
                                String[] data = to.split(";");
                                for (String tmp : data) {
                                    list=new ArrayList<String>();;
                                    String[] data2 = tmp.split(":");
                                    String cle=data2[0];
                                    list.add(cle);
                                    String[] data3 = data2[1].split(",");
                            
                                    String mot="";
                                    for(int l=1;l<data3[0].length();l++){
                                       
                                         mot += data3[0].charAt(l);
                                         
                                    }
                                    
                                    list.add(mot);
                                  
                                    for (int j=1;j<data3.length-1;j++){
                                            list.add(data3[j]);
                                    }
                                    mot="";
                                    for(int l=0;l<data3[data3.length-1].length()-1;l++){
                                        
                                        mot += data3[data3.length-1].charAt(l);
                                   }                                 
                                   list.add(mot);
                                   System.out.println("cle  "+cle+"  list :"+list.toString());
                                   map.put(p,list);  
                                   p++; 
        
                                }    
                                //prenom:[josef,othmane,ran,emma];nom:[elkasri,mattiche,cheng,patricia];age:[20,21,22,19];age2:[20,21,22,09];age3:[20,21,22,09];xss:[smsm,ss,ss,w]
                                System.out.println("ajoutez les types de colonnes sous format type1,type2,.. :");
                                String ty=input.nextLine();
                                String[] type = ty.split(",");
                                for (String tmp : type) {
                                    types.add(tmp);
                                }
                               
                                exit_donnee=true;
                                id=new Insertdata(map);
                                id.setType(types);
                                
                                 DataFrame datafr = new DataFrame(map);
                                 System.out.println(id.getHeader().toString());
                                 System.out.println(id.getData());
                                 datafr.AfficheDataFrame();
                                 //datafr.AfficheLesPrem(3);
                                 //datafr.AfficheLesDer(3);
                                 System.out.println("----------");
                                 list=new ArrayList<String>();
                                 list.add("test");
                                 list.add("1");
                                 //list2.add(list);
                                 //list=new ArrayList<String>();
                                 list.add("2");
                                 //list2.add(list);
                                 //list=new ArrayList<String>();
                                 list.add("3");
                                 //list2.add(list);
                                 //list=new ArrayList<String>();
                                 list.add("4");
                                 //list2.add(list);
                                 //list=new ArrayList<String>();
                                 //list.add("5");
                                 //list2.add(list);
                                 //list=new ArrayList<String>();
                                 //list.add("6");
                                 list2.add(list);
                                 
                                 HashMap<Integer, ArrayList<String>> hmap = new HashMap<Integer,ArrayList<String>>();
                                 hmap.put(6,list);
                                 datafr.InsertColonne(hmap, types);
                                 datafr.AfficheDataFrame();
                                //System.out.println(id.getHeader());
                                // System.out.println(id.getData());
                                
                                              
                    
                    }
                     
                }
               
            
            

        }
        
        
    }
}
