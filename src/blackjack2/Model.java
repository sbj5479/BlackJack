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
        data.gameFinish = false;
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

        data.userScore = 0;
        data.dealerScore = 0;
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
                System.out.println("Card : " + deck.getS());
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
                System.out.println("Card  : " + deck.getS());
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
            stand();
        } //if bust
        else if (data.userScore > 21) {
            System.out.println("You have: " + data.userScore);
            System.out.println("BUST");
//            setWin(2);
            data.win = 2;
            bust();

//            return;
        }

    }

    public void dealerGame() {
        System.out.println("---------------------------------------------------------------");
        System.out.println("Dealers score: " + data.dealerScore);
        deck.draw();
        switch (deck.getN()) {
            case 11:
                System.out.println("Dealers first card: " + deck.getS());
                if (data.dealerScore > 10) {
                    data.dealerScore = (data.dealerScore + 1);

                } else {
                    data.dealerScore = (data.dealerScore + deck.getN());
                    DealerAce1 = true;
                }
                break;

            default:
                System.out.println("Dealers first card: " + deck.getS());
                data.dealerScore = (data.dealerScore + deck.getN());
                break;

        }

        System.out.println("Dealer has: " + data.dealerScore);

        if (data.dealerScore > 21 && DealerAce1) {
            System.out.println("MINUS 10 from ACE");
            data.dealerScore = (data.dealerScore - 10);
            DealerAce1 = false;
        }

        if (data.dealerScore == 21 && data.userScore == 21) {
            System.out.println("DEALER BLACKJACK");
//            System.out.println("DRAW");
            data.win = 3;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
        } else if (data.dealerScore == 21) {
            System.out.println("DEALER BLACKJACK");
//            System.out.println("YOU LOSE");
            data.win = 2;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);

        } else if (data.dealerScore > data.userScore) {
//            System.out.println("YOU LOSE");
            data.win = 2;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
        } else if (data.blackjack && data.dealerScore < 21) {
//            System.out.println("YOU WIN");
            data.win = 1;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);

        } else if (data.dealerScore == data.userScore && data.userScore != 21) {
//            System.out.println("DRAW");
            data.win = 3;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
        } else {
//            while(getbScore() <= getaScore() && getbScore() < 21)

            int j = 2;
            while (data.dealerScore < 17) {
                j++;
                deck.draw();
                switch (deck.getN()) {
                    case 11:
                        System.out.println("Card " + j + ": " + deck.getS());
                        if (data.dealerScore > 10) {
                            data.dealerScore = (data.dealerScore + 1);

                        } else {
                            data.dealerScore = (data.dealerScore + deck.getN());
                            DealerAce1 = true;
                        }
                        break;

                    default:
                        System.out.println("Card " + j + ": " + deck.getS());
                        data.dealerScore = (data.dealerScore + deck.getN());
                        break;

                }

                System.out.println("Dealer has: " + data.dealerScore);

                if (data.dealerScore > 21 && DealerAce1) {
                    System.out.println("MINUS 10 from ACE");
                    data.dealerScore = (data.dealerScore - 10);
                    DealerAce1 = false;
                }

            }

            if (data.dealerScore > data.userScore && data.dealerScore < 22) {
//                System.out.println("YOU LOSE");
                data.win = 2;
                this.data.gameFinish = true;
                this.setChanged();
                this.notifyObservers(this.data);
            } else if (data.dealerScore > 21) {
                System.out.println("DEALER BUST");
//                System.out.println("YOU WIN ");
                data.win = 1;
                this.data.gameFinish = true;
                this.setChanged();
                this.notifyObservers(this.data);
            } else if (data.dealerScore == data.userScore) {
//                System.out.println("DRAW");
                data.win = 3;
                this.data.gameFinish = true;
                this.setChanged();
                this.notifyObservers(this.data);
            } else if (data.userScore > data.dealerScore) {
//                System.out.println("YOU WIN");
                data.win = 1;
                this.data.gameFinish = true;
                this.setChanged();
                this.notifyObservers(this.data);
            }
        }

    }

    public void bust() {
        this.data.bust = true;
        this.data.gameFinish = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void blackjack() {
        this.data.blackjack = true;
        this.data.gameFinish = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void stand() {
        this.data.stand = true;
        dealerGame();
//    this.data.gameFinish = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void doub() {
        this.data.doub = true;
        drawCard();
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void restart() {
        this.data.restart = true;
        this.data.bust = false;
        this.data.blackjack = false;
        this.data.stand = false;
        this.data.betFinish = false;
        this.data.pot = 0;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void quit() {
        this.data.restart = false;
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }

}
