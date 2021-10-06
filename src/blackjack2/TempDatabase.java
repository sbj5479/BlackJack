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
            data.loginFlag = true;
            int pCoins = Integer.valueOf((String)scoreMap.get(username));
            blackjack.User a = new blackjack.User(username, pCoins, true);
            
            
        }
        else
        {
            data.loginFlag = false;
        }
        return data;
    }
}
