/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.util.ArrayList;
import java.util.HashMap;

/**
 *
 * @author greay
 */
public class TempDatabase {
    String username;
    
    public TempDatabase()
    {
        
    }
    
    public Data checkName(String username)
    {
        Data data = new Data(); // Initialize an instance of Data.
        this.username = username;
        ArrayList nameList;
        HashMap scoreMap;
        int counter = 0;
        
        //create central file components for each file
        FileIO namesinout = new FileIO("names");
        FileIO scoresinout = new FileIO("scores");
        //read from names.txt and add contents to arraylist
        nameList = namesinout.ReadL();
        //read from scores.txt and add contents to hashmap
        scoreMap = scoresinout.ReadH();
        
        //search for name
        for(Object e : nameList)
        {
            //if name is found
            if(e.equals(username))
            {
                counter++;
            }
        }
        //if found
        if(counter == 1)
        {
            
            int pCoins = Integer.valueOf((String)scoreMap.get(username)); 
            data.user = new User(username, pCoins, true);
            data.loginFlag = true;
            
            
        }
        else
        {
            data.loginFlag = false;
        }
        return data;
    }
    
    public Data newName(String username)
    {
        Data data = new Data(); // Initialize an instance of Data.
        this.username = username;
        ArrayList nameList;
        HashMap scoreMap;
        int counter = 0;
        
        
        //create central file components for each file
        FileIO namesinout = new FileIO("names");
        FileIO scoresinout = new FileIO("scores");
        
        //read from names.txt and add contents to arraylist
        nameList = namesinout.ReadL();
        //read from scores.txt and add contents to hashmap
        scoreMap = scoresinout.ReadH();
        
        
            
        //loop and search for existing user with name input
        for(Object e : nameList)
        {
            //if already exists
            if(e.equals(username))
            {
                
                counter++;
            } 
        }
        //if user does not exist
        if(counter == 0)
        {
            
            nameList.add(username);
            scoreMap.put(username, 1000);
            data.user = new User(username, 1000,true);
            System.out.println("a " + data.user.getCoins());
            //write new list of names to names.txt 
            namesinout.WriteL(nameList);
            //write new hashmap of names with scores to scores.txt
            scoresinout.WriteH(scoreMap);
            //return created user
            data.loginFlag = true;
        } 
        //user already exists with same name
        else
        {
            data.loginFlag = false;
        }
        return data;
    }
}
