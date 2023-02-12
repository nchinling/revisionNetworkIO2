package sg.edu.nus.iss.app;

import java.io.BufferedReader;
import java.io.Console;
import java.io.IOException;
import java.util.*;

public class ListDS {
    private BufferedReader br;

    public ListDS(){}
    public ListDS(BufferedReader br) {this.br = br;}

    // @Override 
    // public String toString(){
    //     return "List of words"
    // }

    public List<String> storelist (BufferedReader br){
        List<String> al = new ArrayList<String>();

        String line;

        int numWords = 0;
        
        try {
            while ((line = br.readLine()) != null) {    //store line as strings as a string
                String[] words = line.split(" ");
                for (String w: words) {
                    String t = w.trim().toLowerCase();
                    if (t.length() <= 0) {           //if no word, proceed back to for loop to find next word
                        continue;
                    }
                    al.add(t);
                }
                
                   
            }
        } catch (IOException e){
            e.printStackTrace();
        } 

        //print list
        for (int i=0; i< al.size(); i++){
            System.out.printf("Word no. %d is %s.\n", i+1, al.get(i));
        }

        return al;
    }

    public List<String> listWordSort (List<String> al){

        //Sort the list.
        Collections.sort(al);

        System.out.println("List after the use of" +
        " Collection.sort() :\n" + al);
        
            
        return al;
    }

    public List<String> addToList (List<String> al){

        
        Console cons = System.console();
       
        String newMember = cons.readLine(">>Enter name of new member:");
        al.add(newMember.toLowerCase());
        return al;
    }

    
    
}
