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

    public Controller(View view, Model model) {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Obtain the text displayed on the component.
        String username;
        String text;
        String number;
        int bank;

        switch (command) {
            //login
            case "New Player":
                this.view.newLoginScreen();
                break;
            case "Returning Player":
                this.view.reLoginScreen();
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

//                this.view.playGame(model.data.roundCounter, model.data.user);
                break;

            case "PLAY":
//                this.view.playGame(model.data.roundCounter, model.data.user);
                model.finishBets();
                model.startGame();
            {
                try {
                    updateScores();
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
                break;


            case "HIT":
                model.drawCard();
            {
                try {
                    updateScores();
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
            {
                try {
                    updateScores();
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
    
    
    public void updateScores() throws IOException
    {
        view.dealerScore.setText("Dealer: " + model.data.dealerScore);
        view.userScore.setText("Dealer: " + model.data.userScore);
        
        BufferedImage card = ImageIO.read(new File("./resources/diamonds.jpg"));
        JLabel picLabel = new JLabel(new ImageIcon(card));
        view.gamePanel.add(picLabel);
        
//        Image card = new Image("./resources/diamond.jpg") {};
//        view.gamePanel.add(card);
        if(model.data.userScore > 21)
        {
            model.bust();
        }
        else if(model.data.userScore == 21)
        {
            model.blackjack();
        }
        
        
    }

//    @Override
//    public void propertyChange(PropertyChangeEvent evt) {
//        String name  = evt.getPropertyName();
//        System.out.println(name);
//        if("model.data.dealerScore".equals(name))
//        {
//            System.out.println("update");
//            updateScores();
//        }
//    }
            
            
    

    

}
