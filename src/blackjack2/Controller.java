/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 *
 * @author greay
 */
public class Controller implements ActionListener {

    View view;
    Model model;
    Queue cardQueue;
    boolean cardTracker;
    public BufferedImage randomImage = null;
    public JLabel randomLabel = null;

    public Controller(View view, Model model) {
        //instantiate view, model and actionlistener for view
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);

    }

    
    @Override
    public void actionPerformed(ActionEvent e) {
        //get button
        String command = e.getActionCommand(); 
        
        //define variables
        String username;
        String text;
        String number;
        int bank;
        String suit;

        //if button is:
        switch (command) {
            //home screen
            case "New Player":
                //new login screen
                this.view.newLoginScreen();
                break;
                
            case "Returning Player":
                //old user login screen
                this.view.reLoginScreen();
                break;
            
                
            case "Exit":
                //quit screen
                model.quitGame();
                break;

            case "Leaderboard":
                //get top 5 scores and names
                ArrayList<Player> top5 = this.model.getTopScores();
                //set labels to names + scores
                view.getFirst().setText(top5.get(0).getName() + " " + top5.get(0).getCoins());
                view.getSecond().setText(top5.get(1).getName() + " " + top5.get(1).getCoins());
                view.getThird().setText(top5.get(2).getName() + " " + top5.get(2).getCoins());
                view.getFourth().setText(top5.get(3).getName() + " " + top5.get(3).getCoins());
                view.getFifth().setText(top5.get(4).getName() + " " + top5.get(4).getCoins());
                //leaderboard screen
                this.view.leaderboardScreen();
                break;
                
            case "close":
                //back to home screen after leaderboard
                this.view.homeScreen();
                break;
                
            

            
            //login pages
            case "login":
                //check if name in field is contained in database
                username = this.view.getNameField().getText();
                this.model.checkName(username);
                break;
                
            case "create":
                //check if name is not in database
                username = this.view.getNameField().getText();
                this.model.newName(username);
                break;
                
            case "Instructions":
                //instructions message
                this.view.showInstructions();
                break;

            //switch to new login screen
            case "CREATE":
                //new login screen
                this.view.newLoginScreen();
                break;

            //switch to old login screen
            case "LOGIN":
                //old login screen
                this.view.reLoginScreen();
                break;
                
            case "back":
                //back to home screen from either login screen
                this.view.homeScreen();
                break;

            //betting
            case "$1":
                //get string of old bank value
                text = view.getBank().getText();
                //keep only numbers
                number = text.replaceAll("[^0-9]", "");
                //convert to an integer
                bank = Integer.valueOf(number);

                //set text of new bank and new pot after button click
                this.view.getBank().setText("Bank: $" + this.model.addFunds(1, bank));
                this.view.getPot().setText("Pot: $" + model.data.pot);
                //disable buttons if insufficient funds
                if (bank - 1 < 100) {
                    view.getAdd100().setEnabled(false);
                }
                if (bank - 1 < 50) {
                    view.getAdd50().setEnabled(false);
                }
                if (bank - 1 < 25) {
                    view.getAdd25().setEnabled(false);
                }
                if (bank - 1 < 10) {
                    view.getAdd10().setEnabled(false);
                }
                if (bank - 1 < 5) {
                    view.getAdd5().setEnabled(false);
                }
                if (bank - 1 == 0) {
                    view.getAdd1().setEnabled(false);
                    view.getAllIn().setEnabled(false);
                }
                break;
                
            case "$5":
                text = view.getBank().getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.getBank().setText("Bank: $" + this.model.addFunds(5, bank));
                this.view.getPot().setText("Pot: $" + model.data.pot);

                if (bank - 5 < 100) {
                    view.getAdd100().setEnabled(false);
                }
                if (bank - 5 < 50) {
                    view.getAdd50().setEnabled(false);
                }
                if (bank - 5 < 25) {
                    view.getAdd25().setEnabled(false);
                }
                if (bank - 5 < 10) {
                    view.getAdd10().setEnabled(false);
                }
                if (bank - 5 < 5) {
                    view.getAdd5().setEnabled(false);
                }
                if (bank - 5 == 0) {
                    view.getAdd1().setEnabled(false);
                    view.getAllIn().setEnabled(false);
                }
                break;
                
            case "$10":
                text = view.getBank().getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.getBank().setText("Bank: $" + this.model.addFunds(10, bank));
                this.view.getPot().setText("Pot: $" + model.data.pot);

                if (bank - 10 < 100) {
                    view.getAdd100().setEnabled(false);
                }
                if (bank - 10 < 50) {
                    view.getAdd50().setEnabled(false);
                }
                if (bank - 10 < 25) {
                    view.getAdd25().setEnabled(false);
                }
                if (bank - 10 < 10) {
                    view.getAdd10().setEnabled(false);
                }
                if (bank - 10 < 5) {
                    view.getAdd5().setEnabled(false);
                }
                if (bank - 10 == 0) {
                    view.getAdd1().setEnabled(false);
                    view.getAllIn().setEnabled(false);
                }
                break;
                
            case "$25":
                text = view.getBank().getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.getBank().setText("Bank: $" + this.model.addFunds(25, bank));
                this.view.getPot().setText("Pot: $" + model.data.pot);

                if (bank - 25 < 100) {
                    view.getAdd100().setEnabled(false);
                }
                if (bank - 25 < 50) {
                    view.getAdd50().setEnabled(false);
                }
                if (bank - 25 < 25) {
                    view.getAdd25().setEnabled(false);
                }
                if (bank - 25 < 10) {
                    view.getAdd10().setEnabled(false);
                }
                if (bank - 25 < 5) {
                    view.getAdd5().setEnabled(false);
                }
                if (bank - 25 == 0) {
                    view.getAdd1().setEnabled(false);
                    view.getAllIn().setEnabled(false);
                }
                break;
                
            case "$50":
                text = view.getBank().getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.getBank().setText("Bank: $" + this.model.addFunds(50, bank));
                this.view.getPot().setText("Pot: $" + model.data.pot);

                if (bank - 50 < 100) {
                    view.getAdd100().setEnabled(false);
                }
                if (bank - 50 < 50) {
                    view.getAdd50().setEnabled(false);
                }
                if (bank - 50 < 25) {
                    view.getAdd25().setEnabled(false);
                }
                if (bank - 50 < 10) {
                    view.getAdd10().setEnabled(false);
                }
                if (bank - 50 < 5) {
                    view.getAdd5().setEnabled(false);
                }
                if (bank - 50 == 0) {
                    view.getAdd1().setEnabled(false);
                    view.getAllIn().setEnabled(false);
                }
                break;
                
            case "$100":
                text = view.getBank().getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.getBank().setText("Bank: $" + this.model.addFunds(100, bank));
                this.view.getPot().setText("Pot: $" + model.data.pot);

                if (bank - 100 < 100) {
                    view.getAdd100().setEnabled(false);
                }
                if (bank - 100 < 50) {
                    view.getAdd50().setEnabled(false);
                }
                if (bank - 100 < 25) {
                    view.getAdd25().setEnabled(false);
                }
                if (bank - 100 < 10) {
                    view.getAdd10().setEnabled(false);
                }
                if (bank - 100 < 5) {
                    view.getAdd5().setEnabled(false);
                }
                if (bank - 100 == 0) {
                    view.getAdd1().setEnabled(false);
                    view.getAllIn().setEnabled(false);
                }
                break;
                
            case "ALL IN":
                text = view.getBank().getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.getBank().setText("Bank: $" + this.model.addFunds(bank, bank));
                this.view.getPot().setText("Pot: $" + model.data.pot);
                
                //starting game automatically
                cardTracker = false;
                model.finishBets();
                cardQueue = model.startGame();

                try {
                    updateScores(cardQueue, 1);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;
            
            case "reset":
                text = view.getBank().getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.getBank().setText("Bank: $" + this.model.resetFunds(bank));
                this.view.getPot().setText("Pot: $" + model.data.pot);
                

                //set all buttons to enabled
                view.getAdd100().setEnabled(true);

                view.getAdd50().setEnabled(true);


                view.getAdd25().setEnabled(true);

                view.getAdd10().setEnabled(true);

                view.getAdd5().setEnabled(true);

                view.getAdd1().setEnabled(true);
                view.getAllIn().setEnabled(true);
                
                //check if they should be disabled again
                    
                if (bank - 100 < 100) {
                view.getAdd100().setEnabled(false);
                }
                if (bank - 100 < 50) {
                    view.getAdd50().setEnabled(false);
                }
                if (bank - 100 < 25) {
                    view.getAdd25().setEnabled(false);
                }
                if (bank - 100 < 10) {
                    view.getAdd10().setEnabled(false);
                }
                if (bank - 100 < 5) {
                    view.getAdd5().setEnabled(false);
                }
                if (bank - 100 == 0) {
                    view.getAdd1().setEnabled(false);
                    view.getAllIn().setEnabled(false);
                }
                break;
                    
                   
                
             
            case "PLAY":
                //must have coins in the pot
                if(model.data.pot == 0)
                    view.getNoPotMessage().showMessageDialog(null, "No coins added to pot", "Cannot Play", JOptionPane.WARNING_MESSAGE);
                else
                {
                    //start the game
                    cardTracker = false;
                    model.finishBets();
                    cardQueue = model.startGame();
                    //draw first 4 cards
                    try {
                        updateScores(cardQueue, 1);
                    } catch (IOException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                
                
                
            //game screen
            case "HIT":
                //draw a card
                suit = model.drawCard();
                //disabled double button
                view.getDoubleButton().setEnabled(false);
                cardQueue.offer(suit);
                //draw next card
                 {
                    try {
                        updateScores(cardQueue, 2);
                    } catch (IOException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;

            case "STAND":
                //start dealers game
                cardQueue = model.dealerGame();
                //draw cards from dealer game
                try {
                    updateScores(cardQueue, 3);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "DOUBLE":
                //draw last card
                suit = model.drawCard();
                model.data.doub = true;
                //start dealer game
                model.data.startdealer = true;
                cardQueue.offer(suit);
                //draw user thrid card and dealers cards
                 {
                    try {
                        updateScores(cardQueue, 2);
                    } catch (IOException ex) {
                        Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                break;
                
            case "Main Menu":
                //access back to main screen
                //add current coins
                model.addCoins();
                model.restart();
                view.homeScreen();
                break;

            //end of game
            case "play again":
                //go to betting
                //add current coins
                model.addCoins();
                model.restart();
                view.getStatusLabel().setText("");
                break;

            case "end game":
                //add current coins
                model.addCoins();
                //quit screen
                model.quit();
                break;

        }
    }
    
    
    //draw cards, draw updated scores
    public void updateScores(Queue<String> queue, int status) throws IOException {
        
        //update dealer and user score text
        view.getDealerScore().setText("Dealer: " + model.data.dealerScore);
        view.getUserScore().setText("User: " + model.data.userScore);
        BufferedImage cardImage = null;
        int origSize = queue.size();
        
        //normal game
        if (!model.data.startdealer) {
//            System.out.println("START OF GAME \n");
            for (int i = 0; i < origSize; i++) {
                //get top card
                String card = queue.poll();
                //get suit and number
                String subSuit = card.substring(5);
                String subNum = card.substring(0, 2);
                //get rid of spaces
                subSuit = subSuit.strip();
                subNum = subNum.strip();

                //m = random card (after substring)
                if (subSuit.equals("m")) {
                    //hidden card of dealer
                    randomImage = ImageIO.read(new File("./resources/random.jpg"));
                    randomLabel = new JLabel(new ImageIcon(randomImage));
                    
                    view.getTopCardPanel().add(randomLabel);
                } else if (subSuit.equals("Diamonds")) {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/diamondsA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/diamondsK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/diamondsQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/diamondsJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/diamonds10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/diamonds9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/diamonds8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/diamonds7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/diamonds6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/diamonds5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/diamonds4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/diamonds3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/diamonds2.jpg"));
                            break;

                    }

                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    //status  = 1 start of game
                    //2 = player hit
                    //3 dealer
                    //add card to top or bottom
                    if (status == 1) {
                        //add to dealers cards
                        if (cardTracker) {
                            view.getTopCardPanel().add(picLabel);
                        } 
                        //add to users cards
                        else {
                            view.getBottomCardPanel().add(picLabel);
                        }
                    } else if (status == 2) {
                        //add to users cards
//                        System.out.println("ADDING CARD HERE");
                        view.getBottomCardPanel().add(picLabel);
                    } else {
                        //remove hidden card and place new card
                        view.getTopCardPanel().remove(randomLabel);
                        view.getTopCardPanel().add(picLabel);
                    }
                } else if (subSuit.equals("Spades")) {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/spadesA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/spadesK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/spadesQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/spadesJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/spades10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/spades9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/spades8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/spades7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/spades6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/spades5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/spades4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/spades3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/spades2.jpg"));
                            break;

                    }
                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    if (status == 1) {
                        if (cardTracker) {
                            view.getTopCardPanel().add(picLabel);
                        } else {
                            view.getBottomCardPanel().add(picLabel);
                        }
                    } else if (status == 2) {
                        view.getBottomCardPanel().add(picLabel);
                    } else {
                        view.getTopCardPanel().remove(randomLabel);
                        view.getTopCardPanel().add(picLabel);
                    }
                } else if (subSuit.equals("Clubs")) {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/clubsA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/clubsK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/clubsQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/clubsJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/clubs10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/clubs9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/clubs8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/clubs7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/clubs6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/clubs5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/clubs4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/clubs3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/clubs2.jpg"));
                            break;

                    }
                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    if (status == 1) {
                        if (cardTracker) {
                            view.getTopCardPanel().add(picLabel);
                        } else {
                            view.getBottomCardPanel().add(picLabel);
                        }
                    } else if (status == 2) {
                        view.getBottomCardPanel().add(picLabel);
                    } else {
                        view.getTopCardPanel().remove(randomLabel);
                        view.getTopCardPanel().add(picLabel);
                    }
                } else {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/heartsA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/heartsK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/heartsQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/heartsJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/hearts10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/hearts9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/hearts8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/hearts7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/hearts6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/hearts5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/hearts4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/hearts3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/hearts2.jpg"));
                            break;

                    }
                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    if (status == 1) {
                        if (cardTracker) {
                            view.getTopCardPanel().add(picLabel);
                        } else {
                            view.getBottomCardPanel().add(picLabel);
                        }
                    } else if (status == 2) {
                        view.getBottomCardPanel().add(picLabel);
                    } else {
                        view.getTopCardPanel().remove(randomLabel);
                        view.getTopCardPanel().add(picLabel);
                    }

                }
                //flip cardTracker
                if (cardTracker) {
                    cardTracker = false;
                } else {
                    cardTracker = true;
                }
            }
            //check for bust
            model.checkBust();
        } 

        
//        
           
        
        //if blackjack
        if (model.data.blackjack) {
//            System.out.println("BLACKJACK START \n");
            //dealer has 1 last card to equal
            String dealerFlip = model.dealerCard();
            String subSuit = dealerFlip.substring(5);
            String subNum = dealerFlip.substring(0, 2);
            subSuit = subSuit.strip();
            subNum = subNum.strip();

            if (subSuit.equals("Diamonds")) {
                switch (subNum) {
                    case "A":
                        cardImage = ImageIO.read(new File("./resources/diamondsA.jpg"));
                        break;
                    case "K":
                        cardImage = ImageIO.read(new File("./resources/diamondsK.jpg"));
                        break;
                    case "Q":
                        cardImage = ImageIO.read(new File("./resources/diamondsQ.jpg"));
                        break;
                    case "J":
                        cardImage = ImageIO.read(new File("./resources/diamondsJ.jpg"));
                        break;
                    case "10":
                        cardImage = ImageIO.read(new File("./resources/diamonds10.jpg"));
                        break;
                    case "9":
                        cardImage = ImageIO.read(new File("./resources/diamonds9.jpg"));
                        break;
                    case "8":
                        cardImage = ImageIO.read(new File("./resources/diamonds8.jpg"));
                        break;
                    case "7":
                        cardImage = ImageIO.read(new File("./resources/diamonds7.jpg"));
                        break;
                    case "6":
                        cardImage = ImageIO.read(new File("./resources/diamonds6.jpg"));
                        break;
                    case "5":
                        cardImage = ImageIO.read(new File("./resources/diamonds5.jpg"));
                        break;
                    case "4":
                        cardImage = ImageIO.read(new File("./resources/diamonds4.jpg"));
                        break;
                    case "3":
                        cardImage = ImageIO.read(new File("./resources/diamonds3.jpg"));
                        break;
                    default:
                        cardImage = ImageIO.read(new File("./resources/diamonds2.jpg"));
                        break;

                }
                JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                view.getTopCardPanel().remove(randomLabel);
                view.getTopCardPanel().add(picLabel);

            } else if (subSuit.equals("Spades")) {
                switch (subNum) {
                    case "A":
                        cardImage = ImageIO.read(new File("./resources/spadesA.jpg"));
                        break;
                    case "K":
                        cardImage = ImageIO.read(new File("./resources/spadesK.jpg"));
                        break;
                    case "Q":
                        cardImage = ImageIO.read(new File("./resources/spadesQ.jpg"));
                        break;
                    case "J":
                        cardImage = ImageIO.read(new File("./resources/spadesJ.jpg"));
                        break;
                    case "10":
                        cardImage = ImageIO.read(new File("./resources/spades10.jpg"));
                        break;
                    case "9":
                        cardImage = ImageIO.read(new File("./resources/spades9.jpg"));
                        break;
                    case "8":
                        cardImage = ImageIO.read(new File("./resources/spades8.jpg"));
                        break;
                    case "7":
                        cardImage = ImageIO.read(new File("./resources/spades7.jpg"));
                        break;
                    case "6":
                        cardImage = ImageIO.read(new File("./resources/spades6.jpg"));
                        break;
                    case "5":
                        cardImage = ImageIO.read(new File("./resources/spades5.jpg"));
                        break;
                    case "4":
                        cardImage = ImageIO.read(new File("./resources/spades4.jpg"));
                        break;
                    case "3":
                        cardImage = ImageIO.read(new File("./resources/spades3.jpg"));
                        break;
                    default:
                        cardImage = ImageIO.read(new File("./resources/spades2.jpg"));
                        break;

                }

                JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                view.getTopCardPanel().remove(randomLabel);
                view.getTopCardPanel().add(picLabel);
            } else if (subSuit.equals("Clubs")) {
                switch (subNum) {
                    case "A":
                        cardImage = ImageIO.read(new File("./resources/clubsA.jpg"));
                        break;
                    case "K":
                        cardImage = ImageIO.read(new File("./resources/clubsK.jpg"));
                        break;
                    case "Q":
                        cardImage = ImageIO.read(new File("./resources/clubsQ.jpg"));
                        break;
                    case "J":
                        cardImage = ImageIO.read(new File("./resources/clubsJ.jpg"));
                        break;
                    case "10":
                        cardImage = ImageIO.read(new File("./resources/clubs10.jpg"));
                        break;
                    case "9":
                        cardImage = ImageIO.read(new File("./resources/clubs9.jpg"));
                        break;
                    case "8":
                        cardImage = ImageIO.read(new File("./resources/clubs8.jpg"));
                        break;
                    case "7":
                        cardImage = ImageIO.read(new File("./resources/clubs7.jpg"));
                        break;
                    case "6":
                        cardImage = ImageIO.read(new File("./resources/clubs6.jpg"));
                        break;
                    case "5":
                        cardImage = ImageIO.read(new File("./resources/clubs5.jpg"));
                        break;
                    case "4":
                        cardImage = ImageIO.read(new File("./resources/clubs4.jpg"));
                        break;
                    case "3":
                        cardImage = ImageIO.read(new File("./resources/clubs3.jpg"));
                        break;
                    default:
                        cardImage = ImageIO.read(new File("./resources/clubs2.jpg"));
                        break;

                }

                JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                view.getTopCardPanel().remove(randomLabel);
                view.getTopCardPanel().add(picLabel);
            } else {
                switch (subNum) {
                    case "A":
                        cardImage = ImageIO.read(new File("./resources/heartsA.jpg"));
                        break;
                    case "K":
                        cardImage = ImageIO.read(new File("./resources/heartsK.jpg"));
                        break;
                    case "Q":
                        cardImage = ImageIO.read(new File("./resources/heartsQ.jpg"));
                        break;
                    case "J":
                        cardImage = ImageIO.read(new File("./resources/heartsJ.jpg"));
                        break;
                    case "10":
                        cardImage = ImageIO.read(new File("./resources/hearts10.jpg"));
                        break;
                    case "9":
                        cardImage = ImageIO.read(new File("./resources/hearts9.jpg"));
                        break;
                    case "8":
                        cardImage = ImageIO.read(new File("./resources/hearts8.jpg"));
                        break;
                    case "7":
                        cardImage = ImageIO.read(new File("./resources/hearts7.jpg"));
                        break;
                    case "6":
                        cardImage = ImageIO.read(new File("./resources/hearts6.jpg"));
                        break;
                    case "5":
                        cardImage = ImageIO.read(new File("./resources/hearts5.jpg"));
                        break;
                    case "4":
                        cardImage = ImageIO.read(new File("./resources/hearts4.jpg"));
                        break;
                    case "3":
                        cardImage = ImageIO.read(new File("./resources/hearts3.jpg"));
                        break;
                    default:
                        cardImage = ImageIO.read(new File("./resources/hearts2.jpg"));
                        break;

                }

                JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                view.getTopCardPanel().remove(randomLabel);
                view.getTopCardPanel().add(picLabel);

            }
            //update scores text
            view.getDealerScore().setText("Dealer: " + model.data.dealerScore);
            view.getUserScore().setText("User: " + model.data.userScore);
            //check for win
            model.checkWin();
        } 



        //auto stands (21 or double)
        //(startdealer == true)
        
        else if (model.data.startdealer){
            for (int i = 0; i < origSize; i++) {
//                System.out.println("DEALER STARTS HERE");

                String card = queue.poll();
                String subSuit = card.substring(5);
                String subNum = card.substring(0, 2);
                subSuit = subSuit.strip();
                subNum = subNum.strip();


                if (subSuit.equals("Diamonds")) {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/diamondsA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/diamondsK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/diamondsQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/diamondsJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/diamonds10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/diamonds9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/diamonds8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/diamonds7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/diamonds6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/diamonds5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/diamonds4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/diamonds3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/diamonds2.jpg"));
                            break;

                    }

                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    view.getBottomCardPanel().add(picLabel);
                } else if (subSuit.equals("Spades")) {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/spadesA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/spadesK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/spadesQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/spadesJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/spades10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/spades9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/spades8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/spades7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/spades6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/spades5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/spades4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/spades3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/spades2.jpg"));
                            break;

                    }

                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    view.getBottomCardPanel().add(picLabel);
                } else if (subSuit.equals("Clubs")) {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/clubsA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/clubsK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/clubsQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/clubsJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/clubs10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/clubs9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/clubs8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/clubs7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/clubs6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/clubs5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/clubs4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/clubs3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/clubs2.jpg"));
                            break;

                    }

                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    view.getBottomCardPanel().add(picLabel);
                } else {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/heartsA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/heartsK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/heartsQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/heartsJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/hearts10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/hearts9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/hearts8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/hearts7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/hearts6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/hearts5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/hearts4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/hearts3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/hearts2.jpg"));
                            break;

                    }

                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    view.getBottomCardPanel().add(picLabel);

                }

            }
            
            //dealer plays
            Queue<String> dealerHand = model.dealerGame();
            int dealerhandSize = dealerHand.size();
            //for each card in dealers hand
            for (int i = 0; i < dealerhandSize; i++) {
                String dealerCard = dealerHand.poll();

                String subDealer = dealerCard.substring(5);
                String subNum = dealerCard.substring(0, 2);
                subDealer = subDealer.strip();
                subNum = subNum.strip();
                
                //update dealers score
                view.getDealerScore().setText("Dealer: " + model.data.dealerScore);

                if (subDealer.equals("Diamonds")) {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/diamondsA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/diamondsK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/diamondsQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/diamondsJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/diamonds10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/diamonds9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/diamonds8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/diamonds7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/diamonds6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/diamonds5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/diamonds4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/diamonds3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/diamonds2.jpg"));
                            break;

                    }

                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    view.getTopCardPanel().remove(randomLabel);
                    view.getTopCardPanel().add(picLabel);

                } else if (subDealer.equals("Spades")) {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/spadesA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/spadesK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/spadesQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/spadesJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/spades10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/spades9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/spades8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/spades7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/spades6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/spades5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/spades4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/spades3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/spades2.jpg"));
                            break;

                    }

                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    view.getTopCardPanel().remove(randomLabel);
                    view.getTopCardPanel().add(picLabel);
                } else if (subDealer.equals("Clubs")) {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/clubsA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/clubsK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/clubsQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/clubsJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/clubs10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/clubs9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/clubs8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/clubs7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/clubs6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/clubs5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/clubs4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/clubs3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/clubs2.jpg"));
                            break;

                    }

                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    view.getTopCardPanel().remove(randomLabel);
                    view.getTopCardPanel().add(picLabel);
                } else {
                    switch (subNum) {
                        case "A":
                            cardImage = ImageIO.read(new File("./resources/heartsA.jpg"));
                            break;
                        case "K":
                            cardImage = ImageIO.read(new File("./resources/heartsK.jpg"));
                            break;
                        case "Q":
                            cardImage = ImageIO.read(new File("./resources/heartsQ.jpg"));
                            break;
                        case "J":
                            cardImage = ImageIO.read(new File("./resources/heartsJ.jpg"));
                            break;
                        case "10":
                            cardImage = ImageIO.read(new File("./resources/hearts10.jpg"));
                            break;
                        case "9":
                            cardImage = ImageIO.read(new File("./resources/hearts9.jpg"));
                            break;
                        case "8":
                            cardImage = ImageIO.read(new File("./resources/hearts8.jpg"));
                            break;
                        case "7":
                            cardImage = ImageIO.read(new File("./resources/hearts7.jpg"));
                            break;
                        case "6":
                            cardImage = ImageIO.read(new File("./resources/hearts6.jpg"));
                            break;
                        case "5":
                            cardImage = ImageIO.read(new File("./resources/hearts5.jpg"));
                            break;
                        case "4":
                            cardImage = ImageIO.read(new File("./resources/hearts4.jpg"));
                            break;
                        case "3":
                            cardImage = ImageIO.read(new File("./resources/hearts3.jpg"));
                            break;
                        default:
                            cardImage = ImageIO.read(new File("./resources/hearts2.jpg"));
                            break;

                    }

                    JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                    view.getTopCardPanel().remove(randomLabel);
                    view.getTopCardPanel().add(picLabel);

                }
            }
            //check for bust
            model.checkBust();
            //if game is not finsihed check for win
            if(!model.data.gameFinish)
                model.checkWin();

        }

    }

}
