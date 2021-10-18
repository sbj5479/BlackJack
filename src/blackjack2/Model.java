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
    public Database db;
    public Data data;
    public Deck deck;
    boolean Ace1;
    boolean DealerAce1;
    boolean Blackjack;

    public Model() {
        //instantiate databse and deck
        this.db = new Database();
        this.db.dbsetup();
        deck = new Deck();      
    }
    

    public void checkName(String username) {
        //call database checkname
        this.username = username;
        this.data = this.db.checkName(username);
//        System.out.println("old name here");
        //notify view
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void newName(String username) {
        //call database new name
        this.username = username;
//        System.out.println("new name here");
        this.data = this.db.newName(username);

        this.setChanged();
        this.notifyObservers(this.data);
    }
    


    public void finishBets() {
        //start game
        this.data.betFinish = true;
        data.gameStart = true;
        data.gameFinish = false;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public int addFunds(int coins, int bank) {
        //add coins to pot
        this.data.pot += coins;
        bank -= coins;
        return bank;
    }
    
    public int resetFunds(int bank)
    {
        //reset pot and bank
        bank += this.data.pot;
        this.data.pot = 0;
        return bank;
    }

    public ArrayList<Player> getTopScores() {
        //call database topScores
        ArrayList<Player> leaderboard = db.topScores();
        return leaderboard;
    }

    public Queue<String> startGame() {
        //start the game
        Queue<String> cardQueue = new LinkedList();
        data.gameStart = false;
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
//                System.out.println("Your Card 1: " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                Ace1 = true;
                break;

            default:
//                System.out.println("Your Card 1: " + deck.getS());
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
//                System.out.println("Dealer Card 2: " + deck.getS());

                data.dealerScore = data.dealerScore + deck.getN();
                DealerAce1 = true;

                break;
            //normal case
            default:
//                System.out.println("Dealer Card 2: " + deck.getS());
                data.dealerScore = data.dealerScore + deck.getN();
                break;

        }
        
        cardQueue.offer(deck.getS());
        
        
        
        //users second card
        deck.draw();
        switch (deck.getN()) {
            case 11:
//                System.out.println("Your Card 2(ACE): " + deck.getS());
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
//                System.out.println("Your Card 2: " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                break;

        }
        cardQueue.offer(deck.getS());
        
        
        //dealers second card (hidden)
        cardQueue.offer("random");
        
        
        
        
       
        
        
//        System.out.println("Current score: " + data.userScore);
        //if score is a bust but have an ace acting as an 11
        if (data.userScore > 21 && Ace1) {
//            System.out.println("MINUS 10 from ACE");
            data.userScore = data.userScore - 10;
            Ace1 = false;
        }

        //blackjack
        if (data.userScore == 21) {
//            System.out.println("You have: " + data.userScore);
//            System.out.println("BLACKJACK");
            data.blackjack = true;
//            data.startdealer = true;
            Blackjack = true;

        }
        
        return cardQueue;
    }
    
    

    public String dealerCard()
    {
        //draw a card
        deck.draw();
        switch (deck.getN()) {
            case 11:
//                System.out.println("Card : " + deck.getS());
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
//                System.out.println("Card  : " + deck.getS());
                data.dealerScore = data.dealerScore + deck.getN();
                break;

        }
        
        //print final score (21) before dealers cards are revealed
        if (data.dealerScore == 21) {
//            System.out.println("Dealer has: " + data.dealerScore);
            data.win = 3;
            
        } 
        else if (data.dealerScore > 21 && DealerAce1) {
//            System.out.println("MINUS 10 from ACE");
            data.dealerScore = data.dealerScore - 10;
            DealerAce1 = false;
//            System.out.println("SCORE AFTER ACE: " + data.dealerScore);
        }//if bust
        else if (data.dealerScore > 21) {
//            System.out.println("Dealer has: " + data.dealerScore);
//            System.out.println("BUST");
//            setWin(2);
            data.win = 1;
            

//            return;
        }
        return deck.getS();
    }
    
    public String drawCard() {
        //user draw card
        deck.draw();
        switch (deck.getN()) {
            case 11:
//                System.out.println("Card : " + deck.getS());
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
//                System.out.println("Card  : " + deck.getS());
                data.userScore = data.userScore + deck.getN();
                break;

        }
        //if score is bust but have an ace acting as an 11
        if (data.userScore > 21 && Ace1) {
//            System.out.println("MINUS 10 from ACE");
            data.userScore = data.userScore - 10;
            Ace1 = false;
//            System.out.println("SCORE AFTER ACE: " + data.userScore);
        }
        //print final score (21) before dealers cards are revealed
        else if (data.userScore == 21) {
//            System.out.println("You have: " + data.userScore);
            data.startdealer = true;
//            System.out.println("STARTING DEALER");
//            stand();
        } //if bust
//        else if (data.userScore > 21) {
//            System.out.println("You have: " + data.userScore);
//            System.out.println("BUST");
////            setWin(2);
//            data.win = 2;
//            this.data.gameFinish = true;
//            this.setChanged();
//            this.notifyObservers(this.data);

//            return;
        
        return deck.getS();

    }

    public Queue<String> dealerGame() {
        //dealer plays until hitting at least 17
        Queue<String> cardQueue = new LinkedList();
//        System.out.println("---------------------------------------------------------------");
//        System.out.println("Dealers score: " + data.dealerScore);
        deck.draw();
        switch (deck.getN()) {
            case 11:
//                System.out.println("Dealers first card: " + deck.getS());
                if (data.dealerScore > 10) {
                    data.dealerScore = (data.dealerScore + 1);

                } else {
                    data.dealerScore = (data.dealerScore + deck.getN());
                    DealerAce1 = true;
                }
                break;

            default:
//                System.out.println("Dealers first card: " + deck.getS());
                data.dealerScore = (data.dealerScore + deck.getN());
                break;

        }
        cardQueue.offer(deck.getS());
//        System.out.println("Dealer has: " + data.dealerScore);


        if (data.dealerScore > 21 && DealerAce1) {
//            System.out.println("MINUS 10 from ACE");
            data.dealerScore = (data.dealerScore - 10);
            DealerAce1 = false;
        }

        if (data.dealerScore == 21 && data.userScore == 21) {
//            System.out.println("DEALER BLACKJACK");
//            System.out.println("DRAW");
            data.win = 3;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
        } else if (data.dealerScore == 21) {
//            System.out.println("DEALER BLACKJACK");
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
//                        System.out.println("Card " + j + ": " + deck.getS());
                        if (data.dealerScore > 10) {
                            data.dealerScore = (data.dealerScore + 1);

                        } else {
                            data.dealerScore = (data.dealerScore + deck.getN());
                            DealerAce1 = true;
                        }
                        break;

                    default:
//                        System.out.println("Card " + j + ": " + deck.getS());
                        data.dealerScore = (data.dealerScore + deck.getN());
                        break;

                }
                cardQueue.offer(deck.getS());
//                System.out.println("Dealer has: " + data.dealerScore);
//                this.data.scoreChanged = true;
//                this.setChanged();
//                this.notifyObservers(this.data);
//                try {
//                    Thread.sleep(1000);
//                } catch (InterruptedException ex) {
//                    Logger.getLogger(Model.class.getName()).log(Level.SEVERE, null, ex);
//                }

                if (data.dealerScore > 21 && DealerAce1) {
//                    System.out.println("MINUS 10 from ACE");
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
//                System.out.println("DEALER BUST");
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

    public void doub() {
        //if double is clicked
        this.data.doub = true;
        
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    //QUIT RIGHT AWAY
    public void quitGame() {
        data = new Data();
        this.data.quitFlag = true; // Mark quitFlag as false.
        this.setChanged();
        this.notifyObservers(this.data);
    }

    public void restart() {
        //restart game to bet
        this.data.restart = true;
        this.data.bust = false;
        this.data.blackjack = false;
        this.data.startdealer = false;
        this.data.stand = false;
        this.data.betFinish = false;
        this.data.gameStart = false;
        this.data.gameFinish = true;
        
        
        
        this.data.pot = 0;
        this.setChanged();
        this.notifyObservers(this.data);
    }

    
    
    //quit after a game is played
    public void quit() {
        
        this.data.restart = false;
        this.data.quitFlag = true;
        this.setChanged();
        this.notifyObservers(this.data);
    }
    
    
    public void addCoins()
    {
        //add coins using database
        this.db.addCoins(data.user);
        
    }
    
    public void checkWin()
    {
        //win conditions
        if(data.dealerScore < data.userScore)
        {
            data.win = 1;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
        }
        else if(data.dealerScore == 21 && data.userScore == data.dealerScore)
        {
            data.win = 3;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
        }
        
    }


    

    public void checkBust()
    {
        //bust conditions
        if(data.userScore > 21)
        {
            data.win = 2;
            data.bust = true;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
            
        }
        if(data.dealerScore > 21)
        {
            data.win = 1;
            this.data.gameFinish = true;
            this.setChanged();
            this.notifyObservers(this.data);
        }
    }
            

}
