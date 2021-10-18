/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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

    Dealer dealer;

    //new login
    private JPanel newLoginPanel;
    private JButton createButton;
    private JLabel existLabel;
    public JButton LOGIN;
    public JOptionPane dealerMessage;
    public JButton instructionsButton;
    public JPanel bottomLoginPanel;
    //both login
    private JLabel name;
    public JTextField nameField;
    private JOptionPane failMessage;
    public JButton backButton;
    //relogin
    private JPanel reLoginPanel;
    private JButton loginButton;
    private JLabel newLabel;
    public JButton CREATE;
    public JPanel bottomRePanel;

    //leaderboard
    private JPanel leaderboardPanel;
    public JLabel first;
    public JLabel second;
    public JLabel third;
    public JLabel fourth;
    public JLabel fifth;
    private JButton close;

    //bidding
    private JPanel bettingPanel;
    public JLabel bank;
    public JLabel pot;

    public JButton add1;
    public JButton add5;
    public JButton add10;
    public JButton add25;
    public JButton add50;
    public JButton add100;
    public JButton reset;
    public JButton allIn;

    private JButton playButton;
    
    private JPanel bottomBetPanel;

    //playing
    public JPanel gamePanel;
    public JPanel topCardPanel;
    public JPanel bottomCardPanel;
    private JButton hitButton;
    public JLabel statusLabel;
    private JButton standButton;
    public JButton doubleButton;
    public JLabel userScore;
    public JLabel dealerScore;
    public JButton mainMenuButton;
    public JOptionPane noPotMessage;
    private int status;

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

    public JOptionPane stopMessage;

//    private Image diamondCard;
    public View() {
        //home
        this.homePanel = new HomePanel();
        homePanel.setLayout(new FlowLayout());
        this.newPlayer = new JButton("New Player");
        this.returnPlayer = new JButton("Returning Player");
        this.leaderboard = new JButton("Leaderboard");
        this.exit = new JButton("X");

        //home buttons
        homePanel.add(newPlayer);
        homePanel.add(returnPlayer);
        homePanel.add(leaderboard);
        homePanel.add(exit);
        dealer = new Dealer("Dealer");

        add(homePanel, BorderLayout.CENTER);

        //login buttons
        loginButton = new JButton("login");
        createButton = new JButton("create");
        LOGIN = new JButton("LOGIN");
        CREATE = new JButton("CREATE");
        newLabel = new JLabel("First time playing? Click here -->");
        existLabel = new JLabel("Played before? Click here -->");
        failMessage = new JOptionPane();
        instructionsButton = new JButton("Instructions");
        backButton = new JButton("back");

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
        reset = new JButton("reset");
        playButton = new JButton("PLAY");

        //playing buttons
        hitButton = new JButton("HIT");
        standButton = new JButton("STAND");
        doubleButton = new JButton("DOUBLE");
        userScore = new JLabel("You have: 0");
        dealerScore = new JLabel("Dealer has: 0");
        statusLabel = new JLabel("");
        mainMenuButton = new JButton("Main Menu");

//        diamondCard = new ImageIcon("./resources/diamonds.jpg").getImage();
        //restart buttons
        restartButton = new JButton("play again");
        endGameButton = new JButton("end game");
        stopMessage = new JOptionPane();

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }

    public void homeScreen() {
        //add buttons to home
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
        Color colour = new Color(34, 177, 76);
        newLoginPanel.setBackground(colour);
        name = new JLabel("Name:");
        nameField = new JTextField(30);
        
//        dealerMessage = new JLabel("<html>" + dealer.toString().replaceAll("\n", "<br/>") + "</html>");
        bottomLoginPanel = new JPanel();
        bottomLoginPanel.setLayout(new GridLayout(1, 3));
        bottomLoginPanel.setBackground(colour);
//        instructionsButton = new JButton("Instructions");
//        bottomLoginPanel.add(dealerMessage);

        newLoginPanel.add(name);
        newLoginPanel.add(nameField);
        newLoginPanel.add(createButton);
        newLoginPanel.add(existLabel);
        newLoginPanel.add(LOGIN);
        
        bottomLoginPanel.add(backButton);
        bottomLoginPanel.add(instructionsButton);
        JLabel temp2 = new JLabel("");
        bottomLoginPanel.add(temp2);

        this.getContentPane().removeAll();
        newLoginPanel.setVisible(true);
        this.add(newLoginPanel);
        this.add(bottomLoginPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void reLoginScreen() {
        reLoginPanel = new JPanel();
        Color colour = new Color(34, 177, 76);
        reLoginPanel.setBackground(colour);
        name = new JLabel("Name:");
        nameField = new JTextField(30);
        
        bottomRePanel = new JPanel();
        bottomRePanel.setLayout(new GridLayout(1, 3));
        bottomRePanel.setBackground(colour);

        reLoginPanel.add(name);
        reLoginPanel.add(nameField);
        reLoginPanel.add(loginButton);
        reLoginPanel.add(newLabel);
        reLoginPanel.add(CREATE);
        
        
        bottomRePanel.add(backButton);
        bottomRePanel.add(instructionsButton);
        JLabel temp2 = new JLabel("");
        bottomRePanel.add(temp2);

        this.getContentPane().removeAll();
        reLoginPanel.setVisible(true);
        this.add(reLoginPanel);
        this.add(bottomRePanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void leaderboardScreen() {
        JPanel topPanel = new LeaderBoardTopPanel();
//        topPanel.setLayout(new GridLayout(3,4));
        //        bottomCardPanel.setLayout(new GridLayout(1,6));

        leaderboardPanel = new JPanel();
        Color colour = new Color(34, 177, 76);
        leaderboardPanel.setBackground(colour);

//        leaderboardPanel.setLayout(new BoxLayout(leaderboardPanel, BoxLayout.Y_AXIS));
        leaderboardPanel.setLayout(new GridLayout(6, 3));
        JLabel temp1 = new JLabel("");
        JLabel temp2 = new JLabel("");
        JLabel temp3 = new JLabel("");
        JLabel temp4 = new JLabel("");
        JLabel temp5 = new JLabel("");
        JLabel temp6 = new JLabel("");
        JLabel temp7 = new JLabel("");
        JLabel temp8 = new JLabel("");
        JLabel temp9 = new JLabel("");
        JLabel temp10 = new JLabel("");
        JLabel temp11 = new JLabel("");
        JLabel temp12 = new JLabel("");
        leaderboardPanel.add(temp1);
        leaderboardPanel.add(first);
        leaderboardPanel.add(temp2);
//        first.setLocation(50, 50);
        leaderboardPanel.add(temp3);
        leaderboardPanel.add(second);
        leaderboardPanel.add(temp4);
        leaderboardPanel.add(temp5);
        leaderboardPanel.add(third);
        leaderboardPanel.add(temp6);
        leaderboardPanel.add(temp7);
        leaderboardPanel.add(fourth);
        leaderboardPanel.add(temp8);
        leaderboardPanel.add(temp9);
        leaderboardPanel.add(fifth);
        leaderboardPanel.add(temp10);
        leaderboardPanel.add(temp11);
        leaderboardPanel.add(close);
        leaderboardPanel.add(temp12);

        this.getContentPane().removeAll();
        topPanel.setVisible(true);
        leaderboardPanel.setVisible(true);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(leaderboardPanel, BorderLayout.CENTER);
//        this.add(bottomPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();

    }

    public void bettingScreen(User user) {
        bettingPanel = new BettingPanel();
        bank = new JLabel("Bank: $" + user.getCoins());
        pot = new JLabel("Pot: $0");

        bettingPanel.add(bank);
        bettingPanel.add(pot);
        bettingPanel.add(add1);
        bettingPanel.add(add5);
        bettingPanel.add(add10);
        bettingPanel.add(add25);
        bettingPanel.add(add50);
        bettingPanel.add(add100);
        bettingPanel.add(allIn);
        bettingPanel.add(reset);
        bettingPanel.add(playButton);
        
        
        
        Color colour = new Color(34, 177, 76);
        bottomBetPanel = new JPanel();
        bottomBetPanel.setLayout(new GridLayout(1, 3));
        bottomBetPanel.setBackground(colour);
        
        bottomBetPanel.add(backButton);
         JLabel temp1 = new JLabel("");
        JLabel temp2 = new JLabel("");
        bottomBetPanel.add(temp1);
        bottomBetPanel.add(temp2);

        String text = bank.getText();
        String number = text.replaceAll("[^0-9]", "");
        int bank = Integer.valueOf(number);
        System.out.println(bank);

        this.getContentPane().removeAll();
        bettingPanel.setVisible(true);
        this.add(bettingPanel);
        this.add(bottomBetPanel, BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void playGame(View view, Data data) {

        topCardPanel = new JPanel();
        Color colour = new Color(34, 177, 76);
        topCardPanel.setBackground(colour);
//        topCardPanel = new CardPanel();

//        topCardPanel.setLayout(new GridLayout(1, 6));
        bottomCardPanel = new JPanel();
        bottomCardPanel.setBackground(colour);
//        bottomCardPanel.setLayout(new GridLayout(1,6));

        gamePanel = new JPanel();
        gamePanel.setBackground(colour);
        gamePanel.setLayout(new GridLayout(3, 3, 10, 20));
        gamePanel.add(dealerScore);
         JLabel temp1 = new JLabel("");
        gamePanel.add(temp1);
        gamePanel.add(hitButton);
         
        
        gamePanel.add(mainMenuButton);
        gamePanel.add(statusLabel);
        gamePanel.add(standButton);
        gamePanel.add(userScore);
         JLabel temp3 = new JLabel("");
        gamePanel.add(temp3);
        gamePanel.add(doubleButton);

        this.getContentPane().removeAll();
        topCardPanel.setVisible(true);
        gamePanel.setVisible(true);
        bottomCardPanel.setVisible(true);
        this.add(topCardPanel, BorderLayout.NORTH);
        this.add(gamePanel, BorderLayout.CENTER);
        this.add(bottomCardPanel, BorderLayout.SOUTH);
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

    public void addButtons(int status) {
        bottomCardPanel.add(restartButton);
        bottomCardPanel.add(endGameButton);
        if (status == 1) {
            statusLabel.setText("                      WIN");
        } else if (status == 2) {
            statusLabel.setText("                      LOSE");
        } else if (status == 3) {
            statusLabel.setText("                      PUSH");
        } else if (status == 4) {
            statusLabel.setText("                      BUST");
        } else {
            statusLabel.setText("                      BLACKJACK");
        }
        this.revalidate();
        this.repaint();

    }

    public void doubleOff() {
        doubleButton.setEnabled(false);
        this.revalidate();
        this.repaint();
    }

    public void showInstructions() {
        dealerMessage.showMessageDialog(null, "<html>" + dealer.toString().replaceAll("\n", "<br/>") + "</html>", "Instructions", JOptionPane.INFORMATION_MESSAGE);
//        instructionsButton.setVisible();
//        bottomLoginPanel.add(dealerMessage);
    }

    private void quitGame(int coins) {
        JPanel quitPanel = new JPanel();
        Color colour = new Color(34, 177, 76);
        quitPanel.setBackground(colour);
        
            
        JLabel coinsLabel = new JLabel("Your remaining coins: " + coins);
        
        JLabel thanksLabel = new JLabel("Thanks for playing!");
        quitPanel.add(coinsLabel);
        quitPanel.add(thanksLabel);
        this.getContentPane().removeAll();
        //calcPanel.setVisible(true);
        this.add(quitPanel);
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
        this.CREATE.addActionListener(listener);
        this.LOGIN.addActionListener(listener);
        this.instructionsButton.addActionListener(listener);
        this.backButton.addActionListener(listener);

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
        this.reset.addActionListener(listener);
        this.playButton.addActionListener(listener);
        this.mainMenuButton.addActionListener(listener);

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
        //while quit is not true
        if (data.quitFlag) {
            this.quitGame(data.user.getCoins());
        } 
        //keep trying to login
        else if (!data.loginFlag) {
            this.nameField.setText("");

//            System.out.println(data.reFail);
            //if name does not exist and trying login
            if (data.reFail) {
//                System.out.println("WORK?");
                this.failMessage.showMessageDialog(null, "Name does not exist", "Invalid Name", JOptionPane.WARNING_MESSAGE);
            } 
            //if name exists and trying to create new 
            else {
                this.failMessage.showMessageDialog(null, "Name already exists", "Invalid Name", JOptionPane.WARNING_MESSAGE);
            }
            
        } 
        //main loop
        else {
            //while user has coins and not quitting
            if (data.user.getCoins() > 0 && !data.quitFlag) {
                //keeping looping 
                do {
                    //get bets
                    if (!data.betFinish) {
                        System.out.println("BETTING-----------");
                        
                        this.bettingScreen(data.user);
                    }
                    //start game
                    if (data.gameStart) {
                        //start game
                        System.out.println("GAME START-----------");

                        this.playGame(this, data);
                        hitButton.setEnabled(true);
                        standButton.setEnabled(true);
                        doubleButton.setEnabled(true);
                    }
                    //play game 

                    //after game is finished
                    if (data.gameFinish && data.betFinish) {
                        hitButton.setEnabled(false);
                        standButton.setEnabled(false);
                        doubleButton.setEnabled(false);
//                        System.out.println("GAME FINISH--------");
//                            System.out.println("game stop");
                        //if lose
                        if (data.win == 2) {
                            //minus coins
                            System.out.println("minus");
                            status = 2;
                            //show bust on end screen
                            if (data.bust) {
                                status = 4;
                            }
                            //if player doubled pot minus 2x
                            if (data.doub) {
                                System.out.println("minus doub");
                                double multipot = data.pot * 2;
                                System.out.println(multipot);
                                data.user.coins -= multipot;
                            } 
                            //minus normal pot
                            else {
                                data.user.coins -= data.pot;
                            }                               
                        //if draw
                        } else if (data.win == 3) {
                            
                            status = 3;
//                            System.out.println("draw");

                               
                        } 
                        //if win
                        else {
//                            System.out.println("win");
                            status = 1;
                            //if player doubled
                            if (data.doub) {
//                                System.out.println("doub");
                                double multipot = data.pot * 2;
                                System.out.println(multipot);
                                data.user.coins += multipot;
                            } 
                            //if player hits blackjack
                            else if (data.blackjack) {
                                status = 5;
//                                System.out.println("blackjack");
                                double multipot = data.pot * 1.5;
                                System.out.println(multipot);
                                data.user.coins += multipot;
                            } 
                            //normal win
                            else {
                                data.user.coins += data.pot;
                            }        
                        }
                        //add restart and quit game buttons
                        addButtons(status);


                        

                        
                    }
                //keep looping while restart is false
                //if retart is clicked check for quit game then make restat false again
                } while (!data.restart);
            }
            if (data.user.getCoins() == 0) {
                //quit game
                this.stopMessage.showMessageDialog(null, "Insufficient coins to play.", "Stopping game", JOptionPane.WARNING_MESSAGE);
                this.quitGame(0);
                
            }
            //quit game screen
            if (data.quitFlag) {
                this.quitGame(data.userScore);
            }
        }
  
    }
}
