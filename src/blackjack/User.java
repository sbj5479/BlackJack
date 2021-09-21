/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author greay
 */
public class User extends Player{
    
    private boolean creation;
    private int coins;
    
    public User()
    {
        super();
    }
    
    public User(String name, int coins,boolean creation)
    {
        super(name);
        setCreation(creation);
        setCoins(coins);
    }


    /**
     * @return the creation
     */
    public boolean isCreation() {
        return creation;
    }

    /**
     * @param creation the creation to set
     */
    public void setCreation(boolean creation) {
        this.creation = creation;
    }

   
    
}
