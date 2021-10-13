/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Observable;
import java.util.Queue;

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
//        Ace1 = false;
//        DealerAce1 = false;
//        Blackjack = false;
    }
    //setChanged();
    //notifyObservers("");

    public void checkName(String username) {

        this.username = username;
        this.data = this.db.checkName(username);

        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void newName(String username) {
        this.username = username;
        this.data = this.db.newName(username);

        this.setChanged();
        this.notifyObservers(this.data);
    }
    
//    public void newLogin()
//    {
////        Data dataOne = new Data();
////        data.newFlag = true;
//        this.setChanged();
//        this.notifyObservers(this.data);
//        
//    }
//    
//    public void reLogin()
//    {
////        Data dataTwo = new Data();
////        data.reFlag = true;
//        this.setChanged();
//        this.notifyObservers(this.data);
//        
//    }

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

    public Queue<String> startGame() {
        Queue<String> cardQueue = new LinkedList();
        
        Ace1 = false;
        DealerAce1 = false;
        Blackjack = false;
        
        data.userScore = 0;
        data.dealerScore = 0;
        //new deck, cards are avaialble to be drawn
        deck.shuffle();

        //users first card
        deck.draw();
        switch (deck.getN()) {
            case 11:
                System.out.println("Your Card 1: " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                Ace1 = true;
                break;

            default:
                System.out.println("Your Card 1: " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                break;

        }
        cardQueue.offer(deck.getS());
        
        
        //dealers first card (hidden)
        cardQueue.offer("random");
        
        
        
        //users second card
        deck.draw();
        switch (deck.getN()) {
            case 11:
                System.out.println("Your Card 2(ACE): " + deck.getS());
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
                System.out.println("Your Card 2: " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                break;

        }
        cardQueue.offer(deck.getS());
        
        
        //dealers second card
        deck.draw();

//        System.out.println(deck.getN());
        switch (deck.getN()) {
            //if ace
            case 11:
                System.out.println("Dealer Card 2: " + deck.getS());

                data.dealerScore = data.dealerScore + deck.getN();
                DealerAce1 = true;

                break;
            //normal case
            default:
                System.out.println("Dealer Card 2: " + deck.getS());
                data.dealerScore = data.dealerScore + deck.getN();
                break;

        }
        
        cardQueue.offer(deck.getS());
        
        
        
        //draw a card
        
        
        System.out.println("Current score: " + data.userScore);
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
            data.blackjack = true;
            Blackjack = true;
            Queue<String> endgameQueue = dealerGame();
            int queueSize = endgameQueue.size();
            for(int i = 0 ; i < queueSize; i ++)
            {
                String card = endgameQueue.poll();
                cardQueue.offer(card);
            }
        }
        
        return cardQueue;
    }
    
    public Queue<String> startGame2() {
        Queue<String> cardQueue = new LinkedList();
        data.userScore = 0;
        data.dealerScore = 0;
        //new deck, cards are avaialble to be drawn
        deck.shuffle();
        
        return cardQueue;
    }
    
    public void showDoub()
    {
        data.showDoub = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public String dealerCard()
    {
        deck.draw();
        switch (deck.getN()) {
            case 11:
                System.out.println("Card : " + deck.getS());
                //act as a 1
                if (data.dealerScore > 10) {
                    data.dealerScore = (data.dealerScore + 1);

                } //act as an 11
                else {
                    data.dealerScore = data.dealerScore + deck.getN();
                    DealerAce1 = true;
                }
                break;
            //normal case
            default:
                System.out.println("Card  : " + deck.getS());
                data.dealerScore = data.dealerScore + deck.getN();
                break;

        }
        
        //print final score (21) before dealers cards are revealed
        if (data.dealerScore == 21) {
            System.out.println("Dealer has: " + data.dealerScore);
            data.win = 3;
            
        } //if bust
        else if (data.dealerScore > 21) {
            System.out.println("Dealer has: " + data.dealerScore);
            System.out.println("BUST");
//            setWin(2);
            data.win = 1;
            

//            return;
        }
        return deck.getS();
    }
    
    public String drawCard() {
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
            System.out.println("SCORE AFTER ACE: " + data.userScore);
        }
        //print final score (21) before dealers cards are revealed
        else if (data.userScore == 21) {
            System.out.println("You have: " + data.userScore);
            data.startdealer = true;
            System.out.println("STARTING DEALER");
//            stand();
        } //if bust
        else if (data.userScore > 21) {
            System.out.println("You have: " + data.userScore);
            System.out.println("BUST");
//            setWin(2);
            data.win = 2;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);

//            return;
        }
        return deck.getS();

    }

    public Queue<String> dealerGame() {
        Queue<String> cardQueue = new LinkedList();
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
        cardQueue.offer(deck.getS());
        System.out.println("Dealer has: " + data.dealerScore);
//        this.data.scoreChanged = true;
//        this.setChanged();
//        this.notifyObservers(this.data);
//        try {
//            Thread.sleep(1000);
//        } catch (InterruptedException ex) {
//            Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
//        }

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

        } else if (data.dealerScore == data.userScore && data.userScore != 21 && data.dealerScore > 16) {
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
                cardQueue.offer(deck.getS());
                System.out.println("Dealer has: " + data.dealerScore);
//                this.data.scoreChanged = true;
//                this.setChanged();
//                this.notifyObservers(this.data);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
//                }

                if (data.dealerScore > 21 && DealerAce1) {
                    System.out.println("MINUS 10 from ACE");
                    data.dealerScore = (data.dealerScore - 10);
                    DealerAce1 = false;
                }
                //stop after 1st card drawn
                if(data.blackjack)
                {
                    data.win = 1;
                    this.data.gameFinish = true;
                    this.setChanged();
                    this.notifyObservers(this.data);
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
        return cardQueue;
    }

//    public void bust() {
//        this.data.bust = true;
//        this.data.gameFinish = true;
//        this.setChanged();
//        this.notifyObservers(this.data);
//    }

//    public void blackjack() {
//        this.data.blackjack = true;
//        this.data.gameFinish = true;
//        this.setChanged();
//        this.notifyObservers(this.data);
//    }

//    public void stand() {
////        this.data.stand = true;
//        dealerGame();
////    this.data.gameFinish = true;
////        this.setChanged();
////        this.notifyObservers(this.data);
//    }

    public void doub() {
        this.data.doub = true;
        
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
    
    
    public void addCoins()
    {
        
        this.db.addCoins(data.user);
        
        
        
        
    }
    
    public void checkWin()
    {
        if(data.dealerScore < data.userScore)
        {
            data.win = 1;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
        }
        else if(data.dealerScore == 21)
        {
            data.win = 3;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
        }
    }

}
