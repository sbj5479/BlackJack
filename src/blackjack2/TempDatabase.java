/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

/**
 *
 * @author greay
 */
public class TempDatabase {
    String username;
    Data data;
    public TempDatabase()
    {
        data = new Data(); // Initialize an instance of Data.
    }
    
    public Data checkName(String username)
    {
        
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
            data.reFail = false;
            
            
        }
        else
        {
            data.loginFlag = false;
            data.reFail = true;
        }
        return data;
    }
    
    public Data newName(String username)
    {
//        Data data = new Data(); // Initialize an instance of Data.
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
            data.newFail = false;
        } 
        //user already exists with same name
        else
        {
            data.loginFlag = false;
            data.newFail = true;
        }
        return data;
    }
    
    
    public ArrayList topScores()
    {
         //instantiate variables
        ArrayList<Player> nameList = new ArrayList<>();
        ArrayList name = new ArrayList();
        ArrayList score = new ArrayList();
        HashMap scoreMap;
        
        //create central file components for scores.txt
        FileIO scoresinout = new FileIO("scores");
        
        //read from scores.txt and add contents to hashmap
        scoreMap = scoresinout.ReadH();
        //create entrySet for scoreMap
        Set sSet = scoreMap.entrySet();
        //loop through each object in the hashmap/set
        for(Object e : sSet)
        {
            //split the name from score and store in each arraylist
            String str[] = e.toString().split("=");
            name.add(str[0]);
            score.add(str[1]); 
        }
        
        //add players to list
        for(int i = 0 ; i < name.size(); i ++)
        {
            //convert name and score into string and int respectively
            String namev = name.get(i).toString();
            int scorev = Integer.parseInt((String) score.get(i));
            //add all players
            if(namev.equals("Dealer"))
            {
                Player dealer = new Dealer("Dealer");
                nameList.add(dealer);
            }
            else
            {
                Player user = new User(namev, scorev, false);
                nameList.add(user);
            }
        }
        //find 5 highest scores
        ArrayList<Player> topScores = new ArrayList<>();
        HashMap topPlayers = new HashMap();
        for(int i = 0; i < 5; i ++)
        {
            Player top = nameList.get(0);
            for(int j=0; j< nameList.size(); j++)
            {
                if(nameList.get(j).getCoins()> top.getCoins())
                {
                    top = nameList.get(j);
                }
            }
            //add top 5 players to arraylist and hashmap
            topScores.add(top);
            topPlayers.put(top.getName(), top.getCoins());
            nameList.remove(top);
        }
        //print out top scores
//        System.out.println("---------------------------------------------------------------");
        for(int k = 0 ; k < topScores.size(); k++)
        {
//            System.out.println(k+1 + "." + topScores.get(k).getName() + "  " + topScores.get(k).getCoins());
        }
//        System.out.println("---------------------------------------------------------------");
        
        
        //create central file components for topScores.txt
        FileIO topinout = new FileIO("topScores");
        //write to topScores.txt 
        topinout.WriteH(topPlayers);
        
        return topScores;
    }
    
    
    public void addCoins(User a)
    {
        //instantiate variables
        
        int coins = a.getCoins();
        String name = a.getName();
        HashMap scoreMap;
        
        //create central file components for each scores.txt
        FileIO scoresinout = new FileIO("scores");
        
        //read from scores.txt and add contents to hashmap
        scoreMap = scoresinout.ReadH();
        
        //remove user
        scoreMap.remove(name);
        //put in user with new coins
        scoreMap.put(name, coins);
        
        //write to scores.txt 
        scoresinout.WriteH(scoreMap);
    }
}
