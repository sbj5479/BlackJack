/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.awt.BorderLayout;
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

    //new login
    private JPanel newLoginPanel;
    private JButton createButton;
    private JLabel existLabel;
    public JButton LOGIN;
    //both login
    private JLabel name;
    public JTextField nameField;
    private JOptionPane failMessage;
    //relogin
    private JPanel reLoginPanel;
    private JButton loginButton;
    private JLabel newLabel;
    public JButton CREATE;

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
    public JPanel topCardPanel;
    public JPanel bottomCardPanel;
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

        add(homePanel, BorderLayout.CENTER);

        //login buttons
        loginButton = new JButton("login");
        createButton = new JButton("create");
        LOGIN = new JButton("LOGIN");
        CREATE = new JButton("CREATE");
        newLabel = new JLabel("First time playing? Click here ->");
        existLabel = new JLabel("Played before? Click here ->");
        failMessage = new JOptionPane("Name already exists");

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
        nameField = new JTextField(30);

        
        newLoginPanel.add(name);
        newLoginPanel.add(nameField);
        newLoginPanel.add(createButton);
        newLoginPanel.add(existLabel);
        newLoginPanel.add(LOGIN);
        

        this.getContentPane().removeAll();
        newLoginPanel.setVisible(true);
        this.add(newLoginPanel);
        this.revalidate();
        this.repaint();
    }

    public void reLoginScreen() {
        reLoginPanel = new JPanel();
        name = new JLabel("Name:");
        nameField = new JTextField(30);

        
        reLoginPanel.add(name);
        reLoginPanel.add(nameField);
        reLoginPanel.add(loginButton);
        reLoginPanel.add(newLabel);
        reLoginPanel.add(CREATE);
        

        this.getContentPane().removeAll();
        reLoginPanel.setVisible(true);
        this.add(reLoginPanel);
        this.revalidate();
        this.repaint();
    }

    public void leaderboardScreen() {
        leaderboardPanel = new JPanel();
        leaderboardPanel.setLayout(new BoxLayout(leaderboardPanel, BoxLayout.Y_AXIS));

        leaderboardPanel.add(first);
        first.setLocation(50, 50);
        leaderboardPanel.add(second);
        leaderboardPanel.add(third);
        leaderboardPanel.add(fourth);
        leaderboardPanel.add(fifth);

        leaderboardPanel.add(close);

        this.getContentPane().removeAll();
        leaderboardPanel.setVisible(true);
        this.add(leaderboardPanel, BorderLayout.CENTER);
        this.revalidate();
        this.repaint();

    }

    public void bettingScreen(User user) {
        biddingPanel = new BettingPanel();
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

        topCardPanel = new JPanel();
//        topCardPanel.setLayout(new GridLayout(1, 6));
        bottomCardPanel = new JPanel();
//        bottomCardPanel.setLayout(new GridLayout(1,6));
        
        gamePanel = new JPanel();
        gamePanel.setLayout(new GridLayout(3, 2));
        gamePanel.add(dealerScore);
        gamePanel.add(hitButton);
        JLabel temp = new JLabel("");
        gamePanel.add(temp);
        gamePanel.add(standButton);
        gamePanel.add(userScore);
        gamePanel.add(doubleButton);
        
        

        this.getContentPane().removeAll();
        gamePanel.setVisible(true);
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
    
    public void addButtons()
    {
        bottomCardPanel.add(restartButton);
        bottomCardPanel.add(endGameButton);
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
//            if(data.reFlag)
//            {
//                
                this.failMessage.showMessageDialog(null, "Invalid name");
                
//            }
//            if(data.newFlag)
//            {
                
//                this.failMessage.showMessageDialog(null, "Name already exists");
//            }
        } 
        else 
        {
            //main loop
            if (data.user.getCoins() > 0 && !data.quitFlag) {
                do {
                    System.out.println("starting game");
                    //betting
                    this.bettingScreen(data.user);
                    if (data.betFinish) {
                        //start game
                        System.out.println("bet over");
                        
                        this.playGame(this, data);
//                        if(data.scoreChanged)
//                        {
////                            System.out.println("DEALER SCORE CHANGED HERE\n");
//                            dealerScore.setText("Dealer: " + data.dealerScore);
//                            userScore.setText("Dealer: " + data.userScore);
//                            
//                            this.revalidate();
//                            this.repaint();
//                            data.scoreChanged = false;
//                        }



//                        if(!data.showDoub)
//                        {
//                            doubleButton.setEnabled(false);
//                        }



                        if (data.gameFinish) {
//                            System.out.println("game stop");
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
                while(!data.restart);
            }
//            System.out.println("GAME IS NOW FINSIHED");
//            if
//            {
//                System.out.println("Insufficient coins");
//            }
        }
    }

    

}
