/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author greay
 */
public class Game {

    private int aScore;
    private int bScore;
    private Random rand;
    private int win;
    private boolean blackjack;
    private boolean selectDouble;
    HashMap shuffledMap = new HashMap();

    View view;
    Data data;

    Scanner scan = new Scanner(System.in);
    private int playCount;
    Deck deck;

    //start of game with a new deck
    public Game(View view, Data data) {
        setPlayCount(0);
        deck = new Deck();
        this.view = view;
        this.data = data;
    }

    //play a hand
    public void play(Player a, Player b) {
        int input = 1;
        boolean ace1 = false;
        boolean dealerAce1 = false;
        setBlackjack(false);
        setSelectDouble(false);

        //new deck, cards are avaialble to be drawn
        deck.shuffle();

        System.out.println("---------------------------------------------------------------");
        System.out.println("Dealer draws: ");
        System.out.println("Card 1: HIDDEN");
        //draw a random card
        deck.draw();

//        System.out.println(deck.getN());
        switch (deck.getN()) {
            //if ace
            case 11:
//                view.userScore.setText(text);
                System.out.println("Card 2: " + deck.getS());

                setbScore(getbScore() + deck.getN());
                view.dealerScore.setText("" + getbScore());
                dealerAce1 = true;

                break;
            //normal case
            default:
                System.out.println("Card 2: " + deck.getS());
                setbScore(getbScore() + deck.getN());
                view.dealerScore.setText("" + getbScore());
                break;

        }

        System.out.println("---------------------------------------------------------------");
        System.out.println("You draw: ");
        //draw a card
        deck.draw();
        switch (deck.getN()) {
            case 11:
                System.out.println("Card 1: " + deck.getS());
                setaScore(getaScore() + deck.getN());
                view.userScore.setText("" + getaScore());
                ace1 = true;
                break;

            default:
                System.out.println("Card 1: " + deck.getS());
                setaScore(getaScore() + deck.getN());
                view.userScore.setText("" + getaScore());
                break;

        }

        //draw a card
        deck.draw();
        switch (deck.getN()) {
            case 11:
                System.out.println("Card 2: " + deck.getS());
                //act as a 1
                if (getaScore() > 10) {
                    setaScore(getaScore() + 1);
                    view.userScore.setText("" + getaScore());

                } //act as an 11
                else {
                    setaScore(getaScore() + deck.getN());
                    view.userScore.setText("" + getaScore());
                    ace1 = true;
                }
                break;

            default:
                System.out.println("Card 2: " + deck.getS());
                setaScore(getaScore() + deck.getN());
                view.userScore.setText("" + getaScore());
                break;

        }

        //if score is a bust but have an ace acting as an 11
        if (getaScore() > 21 && ace1) {
            System.out.println("MINUS 10 from ACE");
            setaScore(getaScore() - 10);
            view.userScore.setText("" + getaScore());
            ace1 = false;
        }

        //blackjack
        if (getaScore() == 21) {
            System.out.println("You have: " + getaScore());
            System.out.println("BLACKJACK");
            setBlackjack(true);
        }
        //i acts as card number
        int i = 2;
        
        
//        data.bust = true;
        
    }

//        
//        //while not bust and not selected to stand
//        while(getaScore() < 21 && input == 1)
//        {
//            i++;
//            //if third card DOUBLE is available
//            if(i == 3)
//            {
//                try{
//                    System.out.println("You have: " + getaScore());
//                    System.out.println("1.HIT    2.STAND    3.DOUBLE    0.EXIT");
//                    //ask for input
//                    input = scan.nextInt();
//                    //hit
//                    if(input == 1)
//                    {
//                        //draw a card
//                        deck.draw();
//                        switch(deck.getN())
//                        {
//                            case 11:
//                                System.out.println("Card " + i + ": " + deck.getS());
//                                //act as a 1
//                                if(getaScore() > 10)
//                                {
//                                    setaScore(getaScore() + 1);
//                                    view.dealerScore.setText("" + getaScore());
//                                    
//                                }
//                                //act as an 11
//                                else
//                                {
//                                    setaScore(getaScore() + deck.getN());
//                                    view.dealerScore.setText("" + getaScore());
//                                    ace1 = true;
//                                }
//                                break;
//                            //normal case
//                            default:
//                                System.out.println("Card " + i + ": " + deck.getS());
//                                setaScore(getaScore() + deck.getN());
//                                view.dealerScore.setText("" + getaScore());
//                                break;
//
//                        }
//                        //if score is bust but have an ace acting as an 11
//                        if(getaScore() > 21 && ace1)
//                        {
//                            System.out.println("MINUS 10 from ACE");
//                            setaScore(getaScore() - 10);
//                            view.dealerScore.setText("" + getaScore());
//                            ace1 = false;
//                        }
//                        //print final score (21) before dealers cards are revealed
//                        if(getaScore() == 21)
//                        {
//                            System.out.println("You have: " + getaScore());
//                        }
//                        //if bust
//                        else if(getaScore() > 21)
//                        {
//                            System.out.println("You have: " + getaScore());
//                            System.out.println("BUST");
//                            setWin(2);
//                            return;
//
//                        }
//                    }
//                    //stand
//                    else if(input ==2)
//                    {
//                        System.out.println("You hold ");
//                    }
//                    //double
//                    else if(input == 3)
//                    {
//                        System.out.println("Doubling");
//                        setSelectDouble(true);
//                        //draw a card
//                        deck.draw();
//                        switch(deck.getN())
//                        {
//                            case 11:
//                                System.out.println("Card " + i + ": " + deck.getS());
//                                if(getaScore() > 10)
//                                {
//                                    setaScore(getaScore() + 1);
//                                    view.dealerScore.setText("" + getaScore());
//                                    
//                                }
//                                else
//                                {
//                                    setaScore(getaScore() + deck.getN());
//                                    view.dealerScore.setText("" + getaScore());
//                                    ace1 = true;
//                                }
//                                break;
//
//                            default:
//                                System.out.println("Card " + i + ": " + deck.getS());
//                                setaScore(getaScore() + deck.getN());
//                                view.dealerScore.setText("" + getaScore());
//                                break;
//
//                        }
//                        if(getaScore() > 21 && ace1)
//                        {
//                            System.out.println("MINUS 10 from ACE");
//                            setaScore(getaScore() - 10);
//                            view.dealerScore.setText("" + getaScore());
//                            ace1 = false;
//                        }
//
//                        System.out.println("You have: " + getaScore());
//                        
//                        if(getaScore() > 21)
//                        {
//                            System.out.println("BUST");
//                            setWin(2);
//                            return;
//                        }
//                    }
//                    //exit
//                    else if(input == 0)
//                    {
//                        System.out.println("EXITING");
//                        System.exit(0);
//                    }
//                    else
//                    {
//                        System.out.println("Invalid number");
//                        System.out.println("Please select 1, 2, 3 or 0");
//                        input = 1;
//                        //still 3rd card
//                        i = 2;
//                    }
//                }
//
//                catch(InputMismatchException e)
//                {
//                    System.out.println("Invalid input");
//                    System.out.println("Please select 1, 2, 3 or 0");
//                    //still 3rd card
//                    i = 2;
//                    scan.nextLine();
//                }
//            }
//            //if 4th card or more
//            else{
//                try{
//                    System.out.println("You have: " + getaScore());
//                    System.out.println("1.HIT   2.STAND   0.EXIT");
//                    input = scan.nextInt();
//                    if(input == 1)
//                    {
//                        deck.draw();
//                        switch(deck.getN())
//                        {
//                            case 11:
//                                System.out.println("Card " + i + ": " + deck.getS());
//                                if(getaScore() > 10)
//                                {
//                                    setaScore(getaScore() + 1);
//                                    view.dealerScore.setText("" + getaScore());
//                                    
//                                }
//                                else
//                                {
//                                    setaScore(getaScore() + deck.getN());
//                                    view.dealerScore.setText("" + getaScore());
//                                    ace1 = true;
//                                }
//                                break;
//
//                            default:
//                                System.out.println("Card " + i + ": " + deck.getS());
//                                setaScore(getaScore() + deck.getN());
//                                view.dealerScore.setText("" + getaScore());
//                                break;
//
//                        }
//                        if(getaScore() > 21 && ace1)
//                        {
//                            System.out.println("MINUS 10 from ACE");
//                            setaScore(getaScore() - 10);
//                            view.dealerScore.setText("" + getaScore());
//                            ace1 = false;
//                        }
//                        if(getaScore() == 21)
//                        {
//                            System.out.println("You have: " + getaScore());
//                        }
//                        else if(getaScore() > 21)
//                        {
//                            System.out.println("You have: " + getaScore());
//                            System.out.println("BUST");
//                            setWin(2);
//                            return;
//
//                        }
//                    }
//                    else if(input ==2)
//                    {
//                        System.out.println("You hold ");
//                    }
//                    else if(input == 0)
//                    {
//                        System.out.println("EXITING");
//                        System.exit(0);
//                    }
//                    else
//                    {
//                        System.out.println("Invalid number");
//                        System.out.println("Please select 1, 2 or 0");
//                        input = 1;
//                    }
//                }
//
//                catch(InputMismatchException e)
//                {
//                    System.out.println("Invalid input");
//                    System.out.println("Please select 1, 2 or 0");
//                    scan.nextLine();
//                }
//            }
//        }
//
//        
//        
//        
//        System.out.println("---------------------------------------------------------------");
//        System.out.println("Dealers score: " + getbScore());
//        deck.draw();
//        switch(deck.getN())
//        {
//            case 11:
//                System.out.println("Dealers first card: " + deck.getS());
//                if(getbScore() > 10)
//                {
//                    setbScore(getbScore() + 1);
//                    view.dealerScore.setText("" + getbScore());
//                    
//                }
//                else
//                {
//                    setbScore(getbScore() + deck.getN());
//                    view.dealerScore.setText("" + getbScore());
//                    dealerAce1 = true;
//                }
//                break;
//            
//            default:
//                System.out.println("Dealers first card: " + deck.getS());
//                setbScore(getbScore() + deck.getN());
//                view.dealerScore.setText("" + getbScore());
//                break;
//            
//        }
//        
//        
//        
//        System.out.println("Dealer has: " + getbScore());
//
//        if(getbScore() > 21 && dealerAce1)
//        {
//            System.out.println("MINUS 10 from ACE");
//            setbScore(getbScore() - 10);
//            view.dealerScore.setText("" + getbScore());
//            dealerAce1 = false;
//        }
//        
//        
//        if(getbScore() == 21 && getaScore() == 21)
//        {
//            System.out.println("DEALER BLACKJACK");
////            System.out.println("DRAW");
//            setWin(3);
//        }
//        else if(getbScore() == 21)
//        {
//            System.out.println("DEALER BLACKJACK");
////            System.out.println("YOU LOSE");
//            setWin(2);
//            
//        }
//        else if(getbScore() > getaScore())
//        {
////            System.out.println("YOU LOSE");
//            setWin(2);
//        }
//        else if(isBlackjack()& getbScore() < 21)
//        {
////            System.out.println("YOU WIN");
//            setWin(1);
//           
//        }
//        else if(getbScore() == getaScore() && getaScore() != 21)
//        {
////            System.out.println("DRAW");
//            setWin(3);
//        }
//        else 
//        {
////            while(getbScore() <= getaScore() && getbScore() < 21)
//            
//            int j = 2;
//            while(getbScore() < 17)
//            {
//                j++;
//                deck.draw();
//                switch(deck.getN())
//                {
//                    case 11:
//                        System.out.println("Card " + j + ": " + deck.getS());
//                        if(getbScore() > 10)
//                        {
//                            setbScore(getbScore() + 1);
//                            view.dealerScore.setText("" + getbScore());
//                            
//                        }
//                        else
//                        {
//                            setbScore(getbScore() + deck.getN());
//                            view.dealerScore.setText("" + getbScore());
//                            dealerAce1 = true;
//                        }
//                        break;
//                    
//                    default:
//                        System.out.println("Card " + j + ": " + deck.getS());
//                        setbScore(getbScore() + deck.getN());
//                        view.dealerScore.setText("" + getbScore());
//                        break;
//
//                }
//                
//                
//                System.out.println("Dealer has: " + getbScore());
//                
//                if(getbScore() > 21 && dealerAce1)
//                {
//                    System.out.println("MINUS 10 from ACE");
//                    setbScore(getbScore() - 10);
//                    dealerAce1 = false;
//                }
//
//            }
//            
//            
//            
//            if(getbScore() > getaScore() && getbScore() < 22)
//            {
////                System.out.println("YOU LOSE");
//                setWin(2);
//            }
//            else if(getbScore() > 21)
//            {
//                System.out.println("DEALER BUST");
////                System.out.println("YOU WIN ");
//                setWin(1);
//            }
//            else if(getbScore()==getaScore())
//            {
////                System.out.println("DRAW");
//                setWin(3);
//            }
//            else if(getaScore() > getbScore())
//            {
////                System.out.println("YOU WIN");
//                setWin(1);
//            }
//        }
//        
//    }
    /**
     * @return the aScore
     */
    public int getaScore() {
        return aScore;
    }

    /**
     * @param aScore the aScore to set
     */
    public void setaScore(int aScore) {
        this.aScore = aScore;
    }

    /**
     * @return the bScore
     */
    public int getbScore() {
        return bScore;
    }

    /**
     * @param bScore the bScore to set
     */
    public void setbScore(int bScore) {
        this.bScore = bScore;
    }

    /**
     * @return the win
     */
    public int getWin() {
        return win;
    }

    /**
     * @param win the win to set
     */
    public void setWin(int win) {
        this.win = win;
    }

    /**
     * @return the blackjack
     */
    public boolean isBlackjack() {
        return blackjack;
    }

    /**
     * @param blackjack the blackjack to set
     */
    public void setBlackjack(boolean blackjack) {
        this.blackjack = blackjack;
    }

    /**
     * @return the playCount
     */
    public int getPlayCount() {
        return playCount;
    }

    /**
     * @param playCount the playCount to set
     */
    public void setPlayCount(int playCount) {
        this.playCount = playCount;
    }

    /**
     * @return the selectDouble
     */
    public boolean isSelectDouble() {
        return selectDouble;
    }

    /**
     * @param selectDouble the selectDouble to set
     */
    public void setSelectDouble(boolean selectDouble) {
        this.selectDouble = selectDouble;
    }

}
