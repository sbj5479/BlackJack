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
public class Model extends Observable {

    public String username;
    public TempDatabase db;
    public Data data;
    public Deck deck;
    boolean Ace1;
    boolean DealerAce1;
    boolean Blackjack;

    public Model() {
        this.db = new TempDatabase();
        deck = new Deck();
        Ace1 = false;
        DealerAce1 = false;
        Blackjack = false;
    }
    //setChanged();
    //notifyObservers("");

    public void checkName(String username) {

        this.username = username;
        this.data = this.db.checkName(username);

        if (data.loginFlag) {
            System.out.println("successful");
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void newName(String username) {
        this.username = username;
        this.data = this.db.newName(username);

        if (data.loginFlag) {
            System.out.println("successful2");
        }
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void finishBets() {
        this.data.betFinish = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public int addFunds(int coins, int bank) {

        this.data.pot += coins;
        bank -= coins;
        return bank;
    }

    public ArrayList<Player> getTopScores() {
        ArrayList<Player> leaderboard = db.topScores();
        return leaderboard;
    }

    public void startGame() {
        //new deck, cards are avaialble to be drawn
        deck.shuffle();

        //draw a random card
        deck.draw();

//        System.out.println(deck.getN());
        switch (deck.getN()) {
            //if ace
            case 11:
                System.out.println("Card 2: " + deck.getS());

                data.dealerScore = data.dealerScore + deck.getN();
                DealerAce1 = true;

                break;
            //normal case
            default:
                System.out.println("Card 2: " + deck.getS());
                data.dealerScore = data.dealerScore + deck.getN();
                break;

        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("You draw: ");
        //draw a card
        deck.draw();
        switch (deck.getN()) {
            case 11:
                System.out.println("Card 1: " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                Ace1 = true;
                break;

            default:
                System.out.println("Card 1: " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                break;

        }

        //draw a card
        deck.draw();
        switch (deck.getN()) {
            case 11:
                System.out.println("Card 2: " + deck.getS());
                //act as a 1
                if (data.userScore > 10) {
                    data.userScore = data.userScore + 1;

                } //act as an 11
                else {
                    data.userScore = data.userScore + deck.getN();
                    Ace1 = true;
                }
                break;

            default:
                System.out.println("Card 2: " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                break;

        }

        //if score is a bust but have an ace acting as an 11
        if (data.userScore > 21 && Ace1) {
            System.out.println("MINUS 10 from ACE");
            data.userScore = data.userScore - 10;
            Ace1 = false;
        }

        //blackjack
        if (data.userScore == 21) {
            System.out.println("You have: " + data.userScore);
            System.out.println("BLACKJACK");
            Blackjack = true;
        }
    }

    public void drawCard() {
        deck.draw();
        switch (deck.getN()) {
            case 11:
//                System.out.println("Card " + i + ": " + deck.getS());
                //act as a 1
                if (data.userScore > 10) {
                    data.userScore = (data.userScore + 1);

                } //act as an 11
                else {
                    data.userScore = data.userScore + deck.getN();
                    Ace1 = true;
                }
                break;
            //normal case
            default:
//                System.out.println("Card " + i + ": " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                break;

        }
        //if score is bust but have an ace acting as an 11
        if (data.userScore > 21 && Ace1) {
            System.out.println("MINUS 10 from ACE");
            data.userScore = data.userScore - 10;
            Ace1 = false;
        }
        //print final score (21) before dealers cards are revealed
        if (data.userScore == 21) {
            System.out.println("You have: " + data.userScore);
        } //if bust
        else if (data.userScore> 21) {
            System.out.println("You have: " + data.userScore);
            System.out.println("BUST");
//            setWin(2);
            bust();
            
            return;

        }

    }

        

public void bust() {
        this.data.bust = true;
        this.data.betFinish = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }

}
