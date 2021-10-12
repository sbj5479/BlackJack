/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.TextEvent;
import java.awt.event.TextListener;
import java.awt.image.BufferedImage;
import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author greay
 */
public class Controller implements ActionListener {

    View view;
    Model model;
    Queue cardQueue;
    boolean cardTracker;

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
        cardTracker = false;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Obtain the text displayed on the component.
        String username;
        String text;
        String number;
        int bank;
        String suit;

        switch (command) {
            //login
            case "New Player":
                this.view.newLoginScreen();
//                this.model.newLogin();
                
                break;
            case "Returning Player":
                this.view.reLoginScreen();
//                this.model.reLogin();
                break;
                
            case "Leaderboard":
                ArrayList<Player> top5 = this.model.getTopScores();
                view.first.setText(top5.get(0).getName() + " " + top5.get(0).getCoins());
                view.second.setText(top5.get(1).getName() + " " + top5.get(1).getCoins());
                view.third.setText(top5.get(2).getName() + " " + top5.get(2).getCoins());
                view.fourth.setText(top5.get(3).getName() + " " + top5.get(3).getCoins());
                view.fifth.setText(top5.get(4).getName() + " " + top5.get(4).getCoins());
                this.view.leaderboardScreen();

                break;
                
            case "close":
                this.view.homeScreen();
                break;
                
            case "login":
                username = this.view.nameField.getText();
                this.model.checkName(username);
                break;
            case "create":
                username = this.view.nameField.getText();
                this.model.newName(username);
                break;
                
            case"CREATE":
                this.view.newLoginScreen();
                break;
                
            case "LOGIN":
                this.view.reLoginScreen();
                break;

            //betting
            case "$1":
                text = view.bank.getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.bank.setText("Bank: $" + this.model.addFunds(1, bank));
                this.view.pot.setText("Pot: $" + model.data.pot);

                
                if (bank - 1 < 100) {
                    view.add100.setEnabled(false);
                }
                if (bank - 1 < 50) {
                    view.add50.setEnabled(false);
                }
                if (bank - 1 < 25) {
                    view.add25.setEnabled(false);
                }
                if (bank - 1 < 10) {
                    view.add10.setEnabled(false);
                }
                if (bank - 1 < 5) {
                    view.add5.setEnabled(false);
                }
                if (bank - 1 == 0) 
                {
                    view.add1.setEnabled(false);
                    view.allIn.setEnabled(false);
                }
                break;
            case "$5":
                text = view.bank.getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.bank.setText("Bank: $" + this.model.addFunds(5, bank));
                this.view.pot.setText("Pot: $" + model.data.pot);
                
                if (bank - 5 < 100) {
                    view.add100.setEnabled(false);
                }
                if (bank - 5 < 50) {
                    view.add50.setEnabled(false);
                }
                if (bank - 5 < 25) {
                    view.add25.setEnabled(false);
                }
                if (bank - 5 < 10) {
                    view.add10.setEnabled(false);
                }
                if (bank - 5 < 5) {
                    view.add5.setEnabled(false);
                }
                if (bank - 5 == 0) 
                {
                    view.add1.setEnabled(false);
                    view.allIn.setEnabled(false);
                }
                break;
            case "$10":
                text = view.bank.getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.bank.setText("Bank: $" + this.model.addFunds(10, bank));
                this.view.pot.setText("Pot: $" + model.data.pot);
                
                if (bank - 10 < 100) {
                    view.add100.setEnabled(false);
                }
                if (bank - 10 < 50) {
                    view.add50.setEnabled(false);
                }
                if (bank - 10 < 25) {
                    view.add25.setEnabled(false);
                }
                if (bank - 10 < 10) {
                    view.add10.setEnabled(false);
                }
                if (bank - 10 < 5) {
                    view.add5.setEnabled(false);
                }
                if (bank - 10 == 0) 
                {
                    view.add1.setEnabled(false);
                    view.allIn.setEnabled(false);
                }
                break;
            case "$25":
                text = view.bank.getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.bank.setText("Bank: $" + this.model.addFunds(25, bank));
                this.view.pot.setText("Pot: $" + model.data.pot);
                
                if (bank - 25 < 100) {
                    view.add100.setEnabled(false);
                }
                if (bank - 25 < 50) {
                    view.add50.setEnabled(false);
                }
                if (bank - 25 < 25) {
                    view.add25.setEnabled(false);
                }
                if (bank - 25 < 10) {
                    view.add10.setEnabled(false);
                }
                if (bank - 25 < 5) {
                    view.add5.setEnabled(false);
                }
                if (bank - 25 == 0) 
                {
                    view.add1.setEnabled(false);
                    view.allIn.setEnabled(false);
                }
                break;
            case "$50":
                text = view.bank.getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.bank.setText("Bank: $" + this.model.addFunds(50, bank));
                this.view.pot.setText("Pot: $" + model.data.pot);
                
                if (bank - 50 < 100) {
                    view.add100.setEnabled(false);
                }
                if (bank - 50 < 50) {
                    view.add50.setEnabled(false);
                }
                if (bank - 50 < 25) {
                    view.add25.setEnabled(false);
                }
                if (bank - 50 < 10) {
                    view.add10.setEnabled(false);
                }
                if (bank - 50 < 5) {
                    view.add5.setEnabled(false);
                }
                if (bank - 50 == 0) 
                {
                    view.add1.setEnabled(false);
                    view.allIn.setEnabled(false);
                }
                break;
            case "$100":
                text = view.bank.getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.bank.setText("Bank: $" + this.model.addFunds(100, bank));
                this.view.pot.setText("Pot: $" + model.data.pot);

                if (bank - 100 < 100) {
                    view.add100.setEnabled(false);
                }
                if (bank - 100 < 50) {
                    view.add50.setEnabled(false);
                }
                if (bank - 100 < 25) {
                    view.add25.setEnabled(false);
                }
                if (bank - 100 < 10) {
                    view.add10.setEnabled(false);
                }
                if (bank - 100 < 5) {
                    view.add5.setEnabled(false);
                }
                if (bank - 100 == 0) 
                {
                    view.add1.setEnabled(false);
                    view.allIn.setEnabled(false);
                }

                break;
            case "ALL IN":
                text = view.bank.getText();
                number = text.replaceAll("[^0-9]", "");
                bank = Integer.valueOf(number);

                this.view.bank.setText("Bank: $" + this.model.addFunds(bank, bank));
                this.view.pot.setText("Pot: $" + model.data.pot);
                model.finishBets();
                break;

            case "PLAY":
                
                model.finishBets();
//                cardQueue = model.startGame();
                cardQueue = model.startGame();
                
                try {
                    updateScores(cardQueue, 1);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
//                
//                //draw first card
//                String suit1 = model.drawCard();
//                cardQueue.offer(suit1);
//                
//            
//                try {
//                    updateScores(cardQueue);
//                    Thread.sleep(200);
//                } catch (IOException ex) {
//                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (InterruptedException ex) {
//                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                
//                //draw dealers first card (hidden)
//                cardQueue.offer("random");
//                
//                try {
//                    updateScores(cardQueue);
//                    Thread.sleep(200);
//                } catch (IOException ex) {
//                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (InterruptedException ex) {
//                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                
//                //draw second card
//                String suit2 = model.drawCard();
//                cardQueue.offer(suit2);
//                
//                try {
//                    updateScores(cardQueue);
//                    Thread.sleep(200);
//                } catch (IOException ex) {
//                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (InterruptedException ex) {
//                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//            }
//                
//                //draw dealers second card
//                String dealerSuit1 = model.dealerCard();
//                cardQueue.offer(dealerSuit1);
//                
//                try {
//                    updateScores(cardQueue);
//                    Thread.sleep(200);
//                } catch (IOException ex) {
//                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//                } catch (InterruptedException ex) {
//                Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
//            }
                
                break;






            case "HIT":
                suit = model.drawCard();
                cardQueue.offer(suit);
            {
                try {
                    updateScores(cardQueue, 2);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                
                break;

                
            case "STAND":
                model.stand();
                break;
                
            case "DOUBLE":
                model.doub();
                suit  = model.drawCard();
                cardQueue.offer(suit);
            {
                try {
                    updateScores(cardQueue, 2);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;

                
            case "restart":
                model.addCoins();
                model.restart();
                break;
//                view.getContentPane().removeAll();
            case "end game":
                model.addCoins();
                model.quit();
                break;
            default:

                break;
        }
    }
    
    
    public void updateScores(Queue<String> queue, int status) throws IOException
    {
        view.dealerScore.setText("Dealer: " + model.data.dealerScore);
        view.userScore.setText("User: " + model.data.userScore);
        int origSize = queue.size();
        for(int i = 0; i < origSize; i ++)
        {
//            System.out.println(i);
            String card = queue.poll();
            String subCard = card.substring(5);
            subCard = subCard.strip();
//            System.out.println("SUBSTRING: " + subCard);
            
            //m = random but after substring
            if(subCard.equals("m"))
            {
                BufferedImage cardImage = ImageIO.read(new File("./resources/random.jpg"));
                JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                view.topCardPanel.add(picLabel);
            }
            else if(subCard.equals("Diamonds"))
            {
                BufferedImage cardImage = ImageIO.read(new File("./resources/diamonds.jpg"));
                JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                //status  = 1 start of game
                //2 = player hit
                //3 dealer
                if(status == 1)
                {
                    if(cardTracker)
                        view.topCardPanel.add(picLabel);
                    else
                        view.bottomCardPanel.add(picLabel);
                }
                else if(status == 2)
                    view.bottomCardPanel.add(picLabel);
                else
                    view.topCardPanel.add(picLabel);
            }
            else if(subCard.strip().equals("Spades"))
            {
                BufferedImage cardImage = ImageIO.read(new File("./resources/spades.jpg"));
                JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                if(status == 1)
                {
                    if(cardTracker)
                        view.topCardPanel.add(picLabel);
                    else
                        view.bottomCardPanel.add(picLabel);
                }
                else if(status == 2)
                    view.bottomCardPanel.add(picLabel);
                else
                    view.topCardPanel.add(picLabel);
            }
            else if(subCard.strip().equals("Clubs"))
            {
                BufferedImage cardImage = ImageIO.read(new File("./resources/clubs.jpg"));
                JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                if(status == 1)
                {
                    if(cardTracker)
                        view.topCardPanel.add(picLabel);
                    else
                        view.bottomCardPanel.add(picLabel);
                }
                else if(status == 2)
                    view.bottomCardPanel.add(picLabel);
                else
                    view.topCardPanel.add(picLabel);
            }
            else
            {
                
                BufferedImage cardImage = ImageIO.read(new File("./resources/hearts.jpg"));
                JLabel picLabel = new JLabel(new ImageIcon(cardImage));
                if(status == 1)
                {
                    if(cardTracker)
                        view.topCardPanel.add(picLabel);
                    else
                        view.bottomCardPanel.add(picLabel);
                }
                else if(status == 2)
                    view.bottomCardPanel.add(picLabel);
                else
                    view.topCardPanel.add(picLabel);
            
            }
            //flip cardTracker
            if(cardTracker)
                cardTracker = false;
            else
                cardTracker = true;
        }
        
        
        

        if(model.data.userScore > 21)
        {
            model.bust();
        }
        else if(model.data.userScore == 21)
        {
            model.blackjack();
        }
        
    }
            
}
