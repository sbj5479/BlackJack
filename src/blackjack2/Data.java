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
    boolean reFail = false;
    boolean newFail = false;
    
    boolean quitFlag = false;
    int pot = 0;
    User user = new User();
//    Dealer dealer = new Dealer("Dealer");
    
    boolean betFinish = false;
    boolean gameStart = false;
    boolean gameFinish = true;
    
    boolean bust = false;
    boolean blackjack = false;
    boolean stand = false;
    boolean doub = false;
    boolean showDoub = true;
    boolean startdealer = false;
    
    int win = 0;
    boolean scoreChanged = false;
    
    
    
    boolean standClicked = false;
    
    boolean restart = true;
    
    
    
    int roundCounter = 0;
    int userScore = 0;
    int dealerScore = 0;
    
    boolean hitClicked = false;
    
    
    
    
    
}
