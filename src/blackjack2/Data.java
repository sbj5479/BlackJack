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
public class Data {
    boolean loginFlag = false;
    boolean quitFlag = false;
    int pot = 0;
    User user = new User();
    
    boolean betFinish = false;
    boolean standClicked = false;
    boolean bust = false;
    
    
    int roundCounter = 0;
    int userScore = 0;
    int dealerScore = 0;
    
    boolean hitClicked = false;
    
    
    
    
    
}
