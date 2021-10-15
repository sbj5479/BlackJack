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
        
        String instructions = "Welcome to Blackjack.\n"
                + "If you are new type your name in the box above and click create.\n"
                + "If you have an exisitng accoutn click 'LOGIN' to switch screen.\n"
                +"You will then  be on the betting screen. There you can click the corresponding button to make a bet."
                +"When you are ready press play to start the game.\n"
                +"Both you and the dealer will be dealt two cards, and the aim of the game is to beat his score.\n"
                +"However, he will hide one of his cards, so it is up to you to test your luck and get a higher combined score.\n"
                +"While doing this you must keep your score at 21 or under.\n"
                +"Click HIT for another card, or STAND if you are happy with your hand.\n"
                +"DOUBLE will increase your pot by 2x, but you are given one more card before automatically standing. Increase in risk but double the reward.\n"
                +"BUST results in an automatic loss, and means your cards sum over 21.\n"
                +"PUSH (tie) is where your cards equal the dealers and your cash is refunded.\n"
                +"WIN means your total has beaten the dealer or the dealer has BUST.\n" 
                +"Finally BLACKJACK is where your two starting cards equal 21 and you win a nice 1.5x bonus on your pot, unless the dealer matches you.\n";
        
        return instructions;
    }

}
