package GroupeY;


import java.io.Console;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws FileNotFoundException, IOException
    {   

        boolean exit=false;
        boolean exit_colonne=false;
        boolean exit_donnee=false;
       
        Insertdata id=new Insertdata();

        ArrayList<String> list=new ArrayList<String>();;
        ArrayList<String> types = new ArrayList<String>();
        HashMap<String, ArrayList<String>> map = new HashMap<String,ArrayList<String>>();
        //Insertdata Insdata=new Insertdata();
        System.out.println( "menu !" );
        System.out.println( "b- ajouter data !" );
        System.out.println( "n- cree un dataframe a partire d'un csv !");
        System.out.println( "q- quitter !" );
        Scanner sc=new Scanner(System.in);
        int i=0;
        while(!exit){
            String t=sc.nextLine();

                if(t.toString().equals("n")){
                    System.out.println("donner le path vers le csv");
                    DataFrame df = new DataFrame(sc.nextLine());
                }
                if(t.toString().equals("q")){

                    exit=true;
                    System.out.println("exit");
                }
                if(t.toString().equals("b")){
                   
                    while(!exit_donnee){
                        System.out.println("Add donnee sous format : nomCol1:[data1..dataN];nomCol2:[data1..dataN].. :");
                                   
             
                                Scanner input=new Scanner(System.in);                                                
                                String to=input.nextLine();
                                  
                                String[] data = to.split(";");
                                for (String tmp : data) {

                                    list=new ArrayList<String>();;
                                    String[] data2 = tmp.split(":");
                                    String cle=data2[0];
                                    String[] data3 = data2[1].split(",");
                            
                                    String mot="";
                                    for(int l=1;l<data3[0].length();l++){
                                         mot += data[0].charAt(l);
                                    }
                                    
                                    list.add(mot);
                                  
                                    for (int j=1;j<data3.length-1;j++){
                                            list.add(data3[j]);
                                    }
                                    for(int l=0;l<data3[0].length()-1;l++){
                                        mot += data[0].charAt(l);
                                   }                                 
                                   list.add(mot);
                                    
                                   map.put(cle,list);
         
                                }    
                                //nom:[aa,jj,bb];age:[qq,oi,kk]
                                System.out.println("ajoutez les types de colonnes sous format type1,type2,.. :");
                                String ty=input.nextLine();
                                String[] type = ty.split(",");
                                for (String tmp : type) {
                                    types.add(tmp);
                                }
                                exit_donnee=true;
                                id=new Insertdata(map);
                                id.setType(types);
                                //System.out.println(id.getData());
                                //System.out.println(id.getHeader());
                                
                                              
                    
                    }
                     
                }
               
            
            

        }
        
        
    }
}
