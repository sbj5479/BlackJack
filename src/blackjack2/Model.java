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
    
}
