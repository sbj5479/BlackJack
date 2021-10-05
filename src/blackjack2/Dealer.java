/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

/**
 *
 * @author greay
 */
public class Dealer extends Player{
    public Dealer(String name)
    {
        super(name);
        setCoins(50000);
    }
    
    @Override 
    public String toString(){
        
        String instructions = "I am the dealer.\n"
                + "To start, place a bet by using the corresponding number on your keyboard.\n"
                +"When you are ready press and enter 8 to start the game.\n"
                +"You will be dealt two cards, and the aim of the game is to beat my score.\n"
                +"However, I hide one of my cards, so it is up to you to test your luck and get a higher combined score.\n"
                +"While doing this you must keep your score at 21 or under.\n"
                +"Select DEAL for another card, or STAND if you are happy with your hand.\n"
                +"DOUBLE will increase your pot by 2x, but you are given one more card before automatically standing. Increase in risk but double the reward.\n"
                +"BUST results in an automatic loss, and means your cards sum over 21.\n"
                +"PUSH (tie) is where your cards equal mine and your cash is refunded.\n"
                +"WIN means your total has beaten mine or I have BUST.\n" 
                +"Finally BLACKJACK is where your two starting cards equal 21 and you win a nice 1.5x bonus on your pot, unless I match you.\n";
        
        return instructions;
    }

}
