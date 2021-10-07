/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;

/**
 *
 * @author greay
 */
public class Model extends Observable{
    
    public String username; 
    public TempDatabase db;
    public Data data;
    
    public Model()
    {
        this.db = new TempDatabase();
    }
    //setChanged();
    //notifyObservers("");
    
    public void checkName(String username)
    {
        
        this.username = username;
        this.data = this.db.checkName(username);
        
        if(data.loginFlag)
        {
            System.out.println("successful");
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void newName(String username)
    {
        this.username = username;
        this.data = this.db.newName(username);
        
        if(data.loginFlag)
        {
            System.out.println("successful2");
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public void finishBets()
    {
        this.data.betFinish = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    public int addFunds(int coins, int bank)
    {
        
        this.data.pot += coins;
        bank -= coins;
        return bank;
    }
    
    public ArrayList<Player> getTopScores()
    {
        ArrayList<Player> leaderboard = db.topScores();
        return leaderboard;
    }
    
    public void bust()
    {
        this.data.bust = true;
        this.data.betFinish = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
}
