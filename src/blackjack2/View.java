/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.awt.BorderLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.TextListener;
import java.beans.PropertyChangeListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Observable;
import java.util.Observer;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author greay
 */
public class View extends JFrame implements Observer {

    //home panel
    private JPanel homePanel;
    private JLabel blackJack;
    private JButton newPlayer;
    private JButton returnPlayer;
    private JButton leaderboard;
    private JButton exit;

    //new login
    private JPanel newLoginPanel;
    private JButton createButton;
    //both login
    private JLabel name;
    public JTextField nameField;
    private JLabel failLogin;
    //relogin
    private JPanel reLoginPanel;
    private JButton loginButton;

    //leaderboard
    private JPanel leaderboardPanel;
    public JLabel first;
    public JLabel second;
    public JLabel third;
    public JLabel fourth;
    public JLabel fifth;
    private JButton close;

    //bidding
    private JPanel biddingPanel;
    public JLabel bank;
    public JLabel pot;

    public JButton add1;
    public JButton add5;
    public JButton add10;
    public JButton add25;
    public JButton add50;
    public JButton add100;
    public JButton allIn;

    private JButton playButton;

    //playing
    public JPanel gamePanel;
    private JButton hitButton;
    private JButton standButton;
    public JButton doubleButton;
    public JLabel userScore;
    public JLabel dealerScore;

    //restart
    private JPanel restartPanel;
    private JButton restartButton;
    private JButton endGameButton;

    //win lose 
    private JPanel winPanel;
    private JPanel losePanel;
    private JPanel blackjackPanel;
    private JLabel winLabel;
    private JLabel loseLabel;
    private JLabel blackjackLabel;

    
    private Image diamondCard;
    
    public View() {
        //home
        this.homePanel = new JPanel();
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.X_AXIS));
        this.newPlayer = new JButton("New Player");
        this.returnPlayer = new JButton("Returning Player");
        this.leaderboard = new JButton("Leaderboard");
        this.exit = new JButton("X");

        //home buttons
        homePanel.add(newPlayer);
        homePanel.add(returnPlayer);
        homePanel.add(leaderboard);
        homePanel.add(exit);

        add(homePanel);

        //login buttons
        loginButton = new JButton("login");
        createButton = new JButton("create");

        //leaderboard buttons and labels
        close = new JButton("close");
        first = new JLabel("");
        second = new JLabel("");
        third = new JLabel("");
        fourth = new JLabel("");
        fifth = new JLabel("");

        //betting buttons
        add1 = new JButton("$1");
        add5 = new JButton("$5");
        add10 = new JButton("$10");
        add25 = new JButton("$25");
        add50 = new JButton("$50");
        add100 = new JButton("$100");
        allIn = new JButton("ALL IN");
        playButton = new JButton("PLAY");

        //playing buttons
        hitButton = new JButton("HIT");
        standButton = new JButton("STAND");
        doubleButton = new JButton("DOUBLE");
        userScore = new JLabel("You have: 0");
        dealerScore = new JLabel("Dealer has: 0");
        
        diamondCard = new ImageIcon("./resources/diamonds.jpg").getImage();

        //restart buttons
        restartButton = new JButton("restart");
        endGameButton = new JButton("end game");

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void homeScreen() {
        homePanel.add(newPlayer);
        homePanel.add(returnPlayer);
        homePanel.add(leaderboard);
        homePanel.add(exit);

        this.getContentPane().removeAll();
        homePanel.setVisible(true);
        this.add(homePanel);
        this.revalidate();
        this.repaint();
    }

    public void newLoginScreen() {

        newLoginPanel = new JPanel();
        name = new JLabel("Name:");
        nameField = new JTextField(20);

        failLogin = new JLabel("");
        newLoginPanel.add(name);
        newLoginPanel.add(nameField);
        newLoginPanel.add(createButton);
        newLoginPanel.add(failLogin, BorderLayout.SOUTH);

        this.getContentPane().removeAll();
        newLoginPanel.setVisible(true);
        this.add(newLoginPanel);
        this.revalidate();
        this.repaint();
    }

    public void reLoginScreen() {
        reLoginPanel = new JPanel();
        name = new JLabel("Name:");
        nameField = new JTextField(20);

        failLogin = new JLabel("");
        reLoginPanel.add(name);
        reLoginPanel.add(nameField);
        reLoginPanel.add(loginButton);
        reLoginPanel.add(failLogin, BorderLayout.SOUTH);

        this.getContentPane().removeAll();
        reLoginPanel.setVisible(true);
        this.add(reLoginPanel);
        this.revalidate();
        this.repaint();
    }

    public void leaderboardScreen() {
        leaderboardPanel = new JPanel();

        leaderboardPanel.add(first);
        leaderboardPanel.add(second);
        leaderboardPanel.add(third);
        leaderboardPanel.add(fourth);
        leaderboardPanel.add(fifth);

        leaderboardPanel.add(close);

        this.getContentPane().removeAll();
        leaderboardPanel.setVisible(true);
        this.add(leaderboardPanel);
        this.revalidate();
        this.repaint();

    }

    public void bettingScreen(User user) {
        biddingPanel = new JPanel();
        bank = new JLabel("Bank: $" + user.getCoins());
        pot = new JLabel("Pot: $0");

        biddingPanel.add(bank);
        biddingPanel.add(pot);
        biddingPanel.add(add1);
        biddingPanel.add(add5);
        biddingPanel.add(add10);
        biddingPanel.add(add25);
        biddingPanel.add(add50);
        biddingPanel.add(add100);
        biddingPanel.add(allIn);
        biddingPanel.add(playButton);

        String text = bank.getText();
        String number = text.replaceAll("[^0-9]", "");
        int bank = Integer.valueOf(number);
        System.out.println(bank);

        this.getContentPane().removeAll();
        biddingPanel.setVisible(true);
        this.add(biddingPanel);
        this.revalidate();
        this.repaint();
    }

    public void playGame(View view, Data data) {

        gamePanel = new JPanel();
        gamePanel.add(hitButton);
        gamePanel.add(standButton);
        gamePanel.add(doubleButton);
        gamePanel.add(userScore);
        gamePanel.add(dealerScore);

        this.getContentPane().removeAll();
        gamePanel.setVisible(true);
        this.add(gamePanel);
        this.revalidate();
        this.repaint();

    }

    public void restartScreen() {
        restartPanel = new JPanel();
        restartPanel.add(restartButton);
        restartPanel.add(endGameButton);

        this.getContentPane().removeAll();
        restartPanel.setVisible(true);
        this.add(restartPanel);
        this.revalidate();
        this.repaint();
    }

    public void winScreen() {
        winPanel = new JPanel();
        winLabel = new JLabel("WIN");
        winPanel.add(winLabel);
        winPanel.add(restartButton);
        winPanel.add(endGameButton);
        this.getContentPane().removeAll();
        winPanel.setVisible(true);
        this.add(winPanel);
        this.revalidate();
        this.repaint();
    }

    public void loseScreen() {
        losePanel = new JPanel();
        loseLabel = new JLabel("LOSE");
        losePanel.add(loseLabel);
        losePanel.add(restartButton);
        losePanel.add(endGameButton);
        this.getContentPane().removeAll();
        losePanel.setVisible(true);
        this.add(losePanel);
        this.revalidate();
        this.repaint();
        

    }

    public void blackjackScreen() {
        blackjackPanel = new JPanel();
        blackjackLabel = new JLabel("BLACKJACK");
        blackjackPanel.add(blackjackLabel);
        blackjackPanel.add(restartButton);
        blackjackPanel.add(endGameButton);
        this.getContentPane().removeAll();
        blackjackPanel.setVisible(true);
        this.add(blackjackPanel);
        this.revalidate();
        this.repaint();
    }
    
    public void addButtons()
    {
        gamePanel.add(restartButton);
        gamePanel.add(endGameButton);
        this.revalidate();
        this.repaint();
        
    }
    
    
    
    public void addActionListener(ActionListener listener) {
        //home
        this.newPlayer.addActionListener(listener);
        this.returnPlayer.addActionListener(listener);
        this.leaderboard.addActionListener(listener);
        this.exit.addActionListener(listener);

        //login
        this.loginButton.addActionListener(listener);
        this.createButton.addActionListener(listener);

        //leaderboard
        this.close.addActionListener(listener);

        //betting
        this.add1.addActionListener(listener);
        this.add5.addActionListener(listener);
        this.add10.addActionListener(listener);
        this.add25.addActionListener(listener);
        this.add50.addActionListener(listener);
        this.add100.addActionListener(listener);
        this.allIn.addActionListener(listener);
        this.playButton.addActionListener(listener);

        //playing
        this.hitButton.addActionListener(listener);
        this.standButton.addActionListener(listener);
        this.doubleButton.addActionListener(listener);

        //restart
        this.restartButton.addActionListener(listener);
        this.endGameButton.addActionListener(listener);

    }

    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        if (!data.loginFlag) {
            this.nameField.setText("");
            this.failLogin.setText("Invalid name");
        } else {
            //main loop
            if (data.user.getCoins() > 0 && !data.quitFlag) {
                if (data.restart) {
                    System.out.println("starting game");
                    //betting
                    this.bettingScreen(data.user);
                    if (data.betFinish) {
                        //start game
                        System.out.println("bet over");
                        this.playGame(this, data);
                        if(data.scoreChanged)
                        {
//                            System.out.println("DEALER SCORE CHANGED HERE\n");
                            dealerScore.setText("Dealer: " + data.dealerScore);
                            userScore.setText("Dealer: " + data.userScore);
                            
                            this.revalidate();
                            this.repaint();
                            data.scoreChanged = false;
                        }
                        
                        if (data.gameFinish) {
                            System.out.println("game stop");
                            if (data.win == 2) {
                                //minus coins
                                System.out.println("minus");
                                if (data.doub) {
                                    double multipot = data.pot * 1.5;
                                    data.user.coins -= multipot;
                                } else {
                                    data.user.coins -= data.pot;
                                }
//                                addButtons();
//                                loseScreen();
                                

                            } else if (data.win == 3) {
                                //double coins
                                System.out.println("draw");
                                
//                                addButtons();
//                                blackjackScreen();
                                
//                                
                            } 
                            else 
                            {
                                System.out.println("win");
                                if (data.doub) {
                                    System.out.println("doub");
                                    double multipot = data.pot * 2;
                                    data.user.coins += multipot;
                                }
                                else if(data.blackjack)
                                {
                                    //double coins
                                    System.out.println("double");
                                    double multipot = data.pot * 1.5;
                                    data.user.coins += multipot;
                                } 
                                else {
                                    data.user.coins += data.pot;
                                }
//                                addButtons();
//                                winScreen();
                                
//                                
                            }

                            
                                
                            addButtons();
                           
                            
//                            //restart
//                            this.restartScreen();
//                            
                            if (!data.restart) {
                                System.out.println("stop!!!!");
                            } else {
                                System.out.println("restart");
                            }
                        }

//                        if(data.bust)
//                        {
//                        //game has ended
//                            System.out.println("bust");
//                            this.restartScreen();
//
//                        }
                        //play again
//                        
//                        else {
//                           this.bettingScreen(data.user);
//                       }
                    }
                }

            }
//            System.out.println("GAME IS NOW FINSIHED");
//            if
//            {
//                System.out.println("Insufficient coins");
//            }
        }
    }

    

}
