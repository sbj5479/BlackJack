/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

/**
 *
 * @author greay
 */
public class FileIO {
    
    String file;
    public FileIO(String file) 
    {
        this.file = file;
    }
    
    //read file
    //put contents in an arraylist
    public ArrayList ReadL() 
    {
        ArrayList list = new ArrayList();
        try{
            FileReader fr = new FileReader("./resources/" + file + ".txt");
            BufferedReader bf = new BufferedReader(fr);
            String line = null;
            //read from names.txt
            while((line=bf.readLine())!=null)
            {
                //add names to array list
                list.add(line);
            }
            bf.close();
            

            
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch(IOException e){
            System.out.println("Error reading from file " + file + ".txt");
        }
        return list;
    }
    
    //read from file
    //put contents in a hashmap
    public HashMap ReadH()
    {
        HashMap map = new HashMap();
        
        try{
            FileReader fr = new FileReader("./resources/" + file + ".txt");
            BufferedReader bf = new BufferedReader(fr);

            String line = null;
            //read from file
            while((line=bf.readLine())!=null)
            {
                //split the name from coins 
                String str[] = line.split("=");
                //add to hashmap
                map.put(str[0], str[1]);
            }
            bf.close();
            

        }
        //catch errors 
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch(IOException e){
            System.out.println("Error reading from file " + file + ".txt");
        }
        
        return map;
        
    }
    
    //write to file with an arraylist
    public void WriteL(ArrayList list)
    {
        try{
            PrintWriter pw = new PrintWriter("./resources/" + file + ".txt");
            //write to file
            for(Object e : list)
            {
                //add new list of names
                pw.println(e);
            }
            pw.close();
            
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch(IOException e){
        System.out.println("Error reading from file " + file + ".txt");
        }
        
    }
    
    //write to file with a hashmap
    public void WriteH(HashMap map)
    {
        Set sSet = map.entrySet();
        Iterator it = sSet.iterator();
        try{
            PrintWriter pw = new PrintWriter("./resources/" + file + ".txt");
            while(it.hasNext())
            {
                //add new list of names and scores
                pw.println(it.next());
            }
            pw.close();
           
        }
        catch(FileNotFoundException e){
            System.out.println("File not found.");
        }
        catch(IOException e){
        System.out.println("Error reading from file " + file + ".txt");
        }
        
    }
}
