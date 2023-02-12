package sg.edu.nus.iss.app.server;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;


public class PrintList {
    
    private List<String> obtainedList;

    public PrintList() {}
    public PrintList(List<String> obtainedList) {this.obtainedList = obtainedList;}
    
    public List<String> getObtainedList() {return obtainedList;}
    public void setObtainedList(List<String> obtainedList) {this.obtainedList = obtainedList;}

    public void printconsole(List<String> obtainedList){
        for (int i=0; i< obtainedList.size(); i++){
            System.out.printf("Word no. %d is %s.\n", i+1, obtainedList.get(i));
        }
    }

    public void print2file(List<String> obtainedList, String filename){
        File file = new File("Copy of " + filename);
  
        BufferedWriter bf = null;
  
        try {
  
            // create new BufferedWriter for the output file
            bf = new BufferedWriter(new FileWriter(file));
  
            // iterate map entries
            // List<String> words = obtainedList.keySet();   //store the set of keys in a set
            int count = 0;
            for (String w: obtainedList) {
  
                // put key and value separated by a colon
                bf.write(w);
                // new line
                bf.newLine();
            }
              
            bf.flush();
            }catch (IOException e) {
                        e.printStackTrace();
                    }
                    finally {
              
                        try {
              
                            // always close the writer
                            bf.close();
                        }
                        catch (Exception e) {
                        }
            }
    }

    




    

    
}
