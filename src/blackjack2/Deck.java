/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

/**
 *
 * @author greay
 */
public class Deck {
    private String[] suitArray;
    private String[] valueArray;
    private Random rand;
    private int n = 0;
    private String s = "";
    HashMap myMap = new HashMap();
    private ArrayList<String> cards;
    
    
    //single deck
    public Deck(){
        valueArray = new String[]{"2","3","4","5","6","7","8","9","10","J","Q","K","A"};
        suitArray = new String[]{"Spades", "Hearts", "Clubs", "Diamonds"};
        
    }
    
    //add all cards to a list
    public void shuffle()
    {
        //add one of each card into an arraylist
        cards = new ArrayList<>();
        for(String s : suitArray)
        {
            for(String v : valueArray)
            {
                cards.add(v + " of " + s);
            }
            
        }
//        System.out.println("Shuffling deck");
    }
    //draw a random card
    public void draw(){
        //pick a random number within cards
        rand = new Random();
        int num = rand.nextInt(cards.size()-1);
        //get that card
        String randstr = cards.get(num);
        //remove from available cards
        cards.remove(randstr);
        
        //WORKING OUT VALUES
        //select only the number 
        String value = randstr.substring(0, 2);
        value = value.trim();
        //special cases
        if(value.equals("A"))
        {
            setN(11);
        }
        else if(value.equals("K"))
        {
            setN(10);
        }
        else if(value.equals("Q"))
        {
            setN(10);
        }
        else if(value.equals("J"))
        {
           setN(10);
        }
        //normal case
        else
        {
            int number = Integer.parseInt(value);
            
            setN(number);
        }
        setS(randstr);
    }
    

    /**
     * @return the n
     */
    public int getN() {
        return n;
    }

    /**
     * @param n the n to set
     */
    public void setN(int n) {
        this.n = n;
    }
    
    public String getS()
    {
        return s;
    }

    /**
     * @param s the s to set
     */
    public void setS(String s) {
        this.s = s;
    }

    
}
