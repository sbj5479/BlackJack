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
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
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

    private Dealer dealer;

    //new login
    private JPanel newLoginPanel;
    private JButton createButton;
    private JLabel existLabel;
    private JButton LOGIN;
    private JOptionPane dealerMessage;
    private JButton instructionsButton;
    private JPanel bottomLoginPanel;
    //both login
    private JLabel name;
    private JTextField nameField;
    private JOptionPane failMessage;
    private JButton backButton;
    //relogin
    private JPanel reLoginPanel;
    private JButton loginButton;
    private JLabel newLabel;
    private JButton CREATE;
    private JPanel bottomRePanel;

    //leaderboard
    private JPanel leaderboardPanel;
    private JLabel first;
    private JLabel second;
    private JLabel third;
    private JLabel fourth;
    private JLabel fifth;
    private JButton close;

    //bidding
    private JPanel bettingPanel;
    private JLabel bank;
    private JLabel pot;

    private JButton add1;
    private JButton add5;
    private JButton add10;
    private JButton add25;
    private JButton add50;
    private JButton add100;
    private JButton reset;
    private JButton allIn;

    private JButton playButton;

    private JPanel bottomBetPanel;

    //playing
    private JPanel gamePanel;
    private JPanel topCardPanel;
    private JPanel bottomCardPanel;
    private JButton hitButton;
    private JLabel statusLabel;
    private JButton standButton;
    private JButton doubleButton;
    private JLabel userScore;
    private JLabel dealerScore;
    private JButton mainMenuButton;
    private JOptionPane noPotMessage;
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

    private JOptionPane stopMessage;

//    private Image diamondCard;
    public View() {
        //home
        this.homePanel = new HomePanel();
        homePanel.setLayout(new FlowLayout());
        this.newPlayer = new JButton("New Player");
        this.returnPlayer = new JButton("Returning Player");
        this.leaderboard = new JButton("Leaderboard");
        this.exit = new JButton("Exit");

        //home buttons
        homePanel.add(newPlayer);
        homePanel.add(returnPlayer);
        homePanel.add(leaderboard);
        homePanel.add(exit);
        dealer = new Dealer("Dealer");

        //add homePanel first
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
        getHomePanel().add(getNewPlayer());
        getHomePanel().add(getReturnPlayer());
        getHomePanel().add(getLeaderboard());
        getHomePanel().add(getExit());

        //show home screen
        this.getContentPane().removeAll();
        getHomePanel().setVisible(true);
        this.add(getHomePanel());
        this.revalidate();
        this.repaint();
    }

    public void newLoginScreen() {

        //top panel
        newLoginPanel = new JPanel();
        Color colour = new Color(34, 177, 76);
        getNewLoginPanel().setBackground(colour);
        name = new JLabel("Name:");
        nameField = new JTextField(30);

        //bottom panel
        bottomLoginPanel = new JPanel();
        getBottomLoginPanel().setLayout(new GridLayout(1, 3));
        getBottomLoginPanel().setBackground(colour);

        //add components
        getNewLoginPanel().add(name);
        getNewLoginPanel().add(getNameField());
        getNewLoginPanel().add(getCreateButton());
        getNewLoginPanel().add(getExistLabel());
        getNewLoginPanel().add(getLOGIN());

        getBottomLoginPanel().add(getBackButton());
        getBottomLoginPanel().add(getInstructionsButton());
        JLabel temp2 = new JLabel("");
        getBottomLoginPanel().add(temp2);

        //show new login screen
        this.getContentPane().removeAll();
        getNewLoginPanel().setVisible(true);
        this.add(getNewLoginPanel());
        this.add(getBottomLoginPanel(), BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void reLoginScreen() {
        reLoginPanel = new JPanel();
        Color colour = new Color(34, 177, 76);
        getReLoginPanel().setBackground(colour);
        name = new JLabel("Name:");
        nameField = new JTextField(30);

        bottomRePanel = new JPanel();
        getBottomRePanel().setLayout(new GridLayout(1, 3));
        getBottomRePanel().setBackground(colour);

        getReLoginPanel().add(name);
        getReLoginPanel().add(getNameField());
        getReLoginPanel().add(getLoginButton());
        getReLoginPanel().add(getNewLabel());
        getReLoginPanel().add(getCREATE());

        getBottomRePanel().add(getBackButton());
        getBottomRePanel().add(getInstructionsButton());
        JLabel temp2 = new JLabel("");
        getBottomRePanel().add(temp2);

        this.getContentPane().removeAll();
        getReLoginPanel().setVisible(true);
        this.add(getReLoginPanel());
        this.add(getBottomRePanel(), BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void leaderboardScreen() {
        JPanel topPanel = new LeaderBoardTopPanel();

        leaderboardPanel = new JPanel();
        Color colour = new Color(34, 177, 76);
        getLeaderboardPanel().setBackground(colour);

        getLeaderboardPanel().setLayout(new GridLayout(6, 3));
        //temp labels to fill in grid
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
        getLeaderboardPanel().add(temp1);
        getLeaderboardPanel().add(getFirst());
        getLeaderboardPanel().add(temp2);
        getLeaderboardPanel().add(temp3);
        getLeaderboardPanel().add(getSecond());
        getLeaderboardPanel().add(temp4);
        getLeaderboardPanel().add(temp5);
        getLeaderboardPanel().add(getThird());
        getLeaderboardPanel().add(temp6);
        getLeaderboardPanel().add(temp7);
        getLeaderboardPanel().add(getFourth());
        getLeaderboardPanel().add(temp8);
        getLeaderboardPanel().add(temp9);
        getLeaderboardPanel().add(getFifth());
        getLeaderboardPanel().add(temp10);
        getLeaderboardPanel().add(temp11);
        getLeaderboardPanel().add(getClose());
        getLeaderboardPanel().add(temp12);

        this.getContentPane().removeAll();
        topPanel.setVisible(true);
        getLeaderboardPanel().setVisible(true);
        this.add(topPanel, BorderLayout.NORTH);
        this.add(getLeaderboardPanel(), BorderLayout.CENTER);
        this.revalidate();
        this.repaint();

    }

    public void bettingScreen(User user) {
        bettingPanel = new BettingPanel();
        bank = new JLabel("Bank: $" + user.getCoins());
        pot = new JLabel("Pot: $0");

        getBettingPanel().add(getBank());
        getBettingPanel().add(getPot());
        getBettingPanel().add(getAdd1());
        getBettingPanel().add(getAdd5());
        getBettingPanel().add(getAdd10());
        getBettingPanel().add(getAdd25());
        getBettingPanel().add(getAdd50());
        getBettingPanel().add(getAdd100());
        getBettingPanel().add(getAllIn());
        getBettingPanel().add(getReset());
        getBettingPanel().add(getPlayButton());

        Color colour = new Color(34, 177, 76);
        bottomBetPanel = new JPanel();
        getBottomBetPanel().setLayout(new GridLayout(1, 3));
        getBottomBetPanel().setBackground(colour);

        getBottomBetPanel().add(getBackButton());
        JLabel temp1 = new JLabel("");
        JLabel temp2 = new JLabel("");
        getBottomBetPanel().add(temp1);
        getBottomBetPanel().add(temp2);

        String text = getBank().getText();
        String number = text.replaceAll("[^0-9]", "");
        int bank = Integer.valueOf(number);
        System.out.println(bank);

        this.getContentPane().removeAll();
        getBettingPanel().setVisible(true);
        this.add(getBettingPanel());
        this.add(getBottomBetPanel(), BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();
    }

    public void playGame(View view, Data data) {

        topCardPanel = new JPanel();
        Color colour = new Color(34, 177, 76);
        getTopCardPanel().setBackground(colour);
        bottomCardPanel = new JPanel();
        getBottomCardPanel().setBackground(colour);

        gamePanel = new JPanel();
        getGamePanel().setBackground(colour);
        getGamePanel().setLayout(new GridLayout(3, 3, 10, 20));
        getGamePanel().add(getDealerScore());
        JLabel temp1 = new JLabel("");
        getGamePanel().add(temp1);
        getGamePanel().add(getHitButton());

        getGamePanel().add(getMainMenuButton());
        getGamePanel().add(getStatusLabel());
        getGamePanel().add(getStandButton());
        getGamePanel().add(getUserScore());
        JLabel temp3 = new JLabel("");
        getGamePanel().add(temp3);
        getGamePanel().add(getDoubleButton());

        this.getContentPane().removeAll();
        getTopCardPanel().setVisible(true);
        getGamePanel().setVisible(true);
        getBottomCardPanel().setVisible(true);
        this.add(getTopCardPanel(), BorderLayout.NORTH);
        this.add(getGamePanel(), BorderLayout.CENTER);
        this.add(getBottomCardPanel(), BorderLayout.SOUTH);
        this.revalidate();
        this.repaint();

    }

    public void restartScreen() {
        restartPanel = new JPanel();
        getRestartPanel().add(getRestartButton());
        getRestartPanel().add(getEndGameButton());

        this.getContentPane().removeAll();
        getRestartPanel().setVisible(true);
        this.add(getRestartPanel());
        this.revalidate();
        this.repaint();
    }

    public void winScreen() {
        winPanel = new JPanel();
        winLabel = new JLabel("WIN");
        getWinPanel().add(getWinLabel());
        getWinPanel().add(getRestartButton());
        getWinPanel().add(getEndGameButton());

        this.getContentPane().removeAll();
        getWinPanel().setVisible(true);
        this.add(getWinPanel());
        this.revalidate();
        this.repaint();
    }

    public void loseScreen() {
        losePanel = new JPanel();
        loseLabel = new JLabel("LOSE");
        getLosePanel().add(getLoseLabel());
        getLosePanel().add(getRestartButton());
        getLosePanel().add(getEndGameButton());

        this.getContentPane().removeAll();
        getLosePanel().setVisible(true);
        this.add(getLosePanel());
        this.revalidate();
        this.repaint();

    }

    public void blackjackScreen() {
        blackjackPanel = new JPanel();
        blackjackLabel = new JLabel("BLACKJACK");
        getBlackjackPanel().add(getBlackjackLabel());
        getBlackjackPanel().add(getRestartButton());
        getBlackjackPanel().add(getEndGameButton());

        this.getContentPane().removeAll();
        getBlackjackPanel().setVisible(true);
        this.add(getBlackjackPanel());
        this.revalidate();
        this.repaint();
    }

    public void addButtons(int status) {
        getBottomCardPanel().add(getRestartButton());
        getBottomCardPanel().add(getEndGameButton());
        if (status == 1) {
            getStatusLabel().setText("                      WIN");
        } else if (status == 2) {
            getStatusLabel().setText("                      LOSE");
        } else if (status == 3) {
            getStatusLabel().setText("                      PUSH");
        } else if (status == 4) {
            getStatusLabel().setText("                      BUST");
        } else {
            getStatusLabel().setText("                      BLACKJACK");
        }
        this.revalidate();
        this.repaint();

    }

    public void doubleOff() {
        getDoubleButton().setEnabled(false);
        this.revalidate();
        this.repaint();
    }

    public void showInstructions() {
        getDealerMessage().showMessageDialog(null, "<html>" + getDealer().toString().replaceAll("\n", "<br/>") + "</html>", "Instructions", JOptionPane.INFORMATION_MESSAGE);
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
        this.add(quitPanel);
        this.revalidate();
        this.repaint();
    }

    public void addActionListener(ActionListener listener) {
        //home
        this.getNewPlayer().addActionListener(listener);
        this.getReturnPlayer().addActionListener(listener);
        this.getLeaderboard().addActionListener(listener);
        this.getExit().addActionListener(listener);

        //login
        this.getLoginButton().addActionListener(listener);
        this.getCreateButton().addActionListener(listener);
        this.getCREATE().addActionListener(listener);
        this.getLOGIN().addActionListener(listener);
        this.getInstructionsButton().addActionListener(listener);
        this.getBackButton().addActionListener(listener);

        //leaderboard
        this.getClose().addActionListener(listener);

        //betting
        this.getAdd1().addActionListener(listener);
        this.getAdd5().addActionListener(listener);
        this.getAdd10().addActionListener(listener);
        this.getAdd25().addActionListener(listener);
        this.getAdd50().addActionListener(listener);
        this.getAdd100().addActionListener(listener);
        this.getAllIn().addActionListener(listener);
        this.getReset().addActionListener(listener);
        this.getPlayButton().addActionListener(listener);
        this.getMainMenuButton().addActionListener(listener);

        //playing
        this.getHitButton().addActionListener(listener);
        this.getStandButton().addActionListener(listener);
        this.getDoubleButton().addActionListener(listener);

        //restart
        this.getRestartButton().addActionListener(listener);
        this.getEndGameButton().addActionListener(listener);

    }

    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        //while quit is not true
        if (data.quitFlag) {
            this.quitGame(data.user.getCoins());
        } //keep trying to login
        else if (!data.loginFlag) {
            this.getNameField().setText("");

            //if name does not exist and trying login
            if (data.reFail) {
                this.getFailMessage().showMessageDialog(null, "Name does not exist", "Invalid Name", JOptionPane.WARNING_MESSAGE);
            } //if name exists and trying to create new 
            else {
                this.getFailMessage().showMessageDialog(null, "Name already exists", "Invalid Name", JOptionPane.WARNING_MESSAGE);
            }

        } //main loop
        else {
            //while user has coins and not quitting
            if (data.user.getCoins() > 0 && !data.quitFlag) {
                //keeping looping 
                do {
                    //get bets
                    if (!data.betFinish) {
//                        System.out.println("BETTING-----------");

                        this.bettingScreen(data.user);
                    }
                    //start game
                    if (data.gameStart) {
                        //start game
//                        System.out.println("GAME START-----------");

                        this.playGame(this, data);
                        getHitButton().setEnabled(true);
                        getStandButton().setEnabled(true);
                        getDoubleButton().setEnabled(true);
                    }
                    //play game 

                    //after game is finished
                    if (data.gameFinish && data.betFinish) {
                        getHitButton().setEnabled(false);
                        getStandButton().setEnabled(false);
                        getDoubleButton().setEnabled(false);
//                        System.out.println("GAME FINISH--------");
//                            System.out.println("game stop");
                        //if lose
                        if (data.win == 2) {
                            //minus coins
//                            System.out.println("minus");
                            status = 2;
                            //show bust on end screen
                            if (data.bust) {
                                status = 4;
                            }
                            //if player doubled pot minus 2x
                            if (data.doub) {
//                                System.out.println("minus doub");
                                double multipot = data.pot * 2;
//                                System.out.println(multipot);
                                data.user.coins -= multipot;
                            } //minus normal pot
                            else {
                                data.user.coins -= data.pot;
                            }
                            //if draw
                        } else if (data.win == 3) {

                            status = 3;
//                            System.out.println("draw");

                        } //if win
                        else {
//                            System.out.println("win");
                            status = 1;
                            //if player doubled
                            if (data.doub) {
//                                System.out.println("doub");
                                double multipot = data.pot * 2;
//                                System.out.println(multipot);
                                data.user.coins += multipot;
                            } //if player hits blackjack
                            else if (data.blackjack) {
                                status = 5;
//                                System.out.println("blackjack");
                                double multipot = data.pot * 1.5;
//                                System.out.println(multipot);
                                data.user.coins += multipot;
                            } //normal win
                            else {
                                data.user.coins += data.pot;
                            }
                        }
                        //add restart and quit game buttons
                        addButtons(getStatus());

                    }
                    //keep looping while restart is false
                    //if retart is clicked check for quit game then make restat false again
                } while (!data.restart);
            }
            if (data.user.getCoins() == 0) {
                //quit game
                this.getStopMessage().showMessageDialog(null, "Insufficient coins to play.", "Stopping game", JOptionPane.WARNING_MESSAGE);
                this.quitGame(0);

            }
            //quit game screen
            if (data.quitFlag) {
                this.quitGame(data.userScore);
            }
        }

    }

    /**
     * @return the newPlayer
     */
    public JButton getNewPlayer() {
        return newPlayer;
    }

    /**
     * @return the first
     */
    public JLabel getFirst() {
        return first;
    }

    /**
     * @return the second
     */
    public JLabel getSecond() {
        return second;
    }

    /**
     * @return the third
     */
    public JLabel getThird() {
        return third;
    }

    /**
     * @return the fourth
     */
    public JLabel getFourth() {
        return fourth;
    }

    /**
     * @return the fifth
     */
    public JLabel getFifth() {
        return fifth;
    }

    /**
     * @return the returnPlayer
     */
    public JButton getReturnPlayer() {
        return returnPlayer;
    }

    /**
     * @return the leaderboard
     */
    public JButton getLeaderboard() {
        return leaderboard;
    }

    /**
     * @return the exit
     */
    public JButton getExit() {
        return exit;
    }

    /**
     * @return the createButton
     */
    public JButton getCreateButton() {
        return createButton;
    }

    /**
     * @return the LOGIN
     */
    public JButton getLOGIN() {
        return LOGIN;
    }

    /**
     * @return the instructionsButton
     */
    public JButton getInstructionsButton() {
        return instructionsButton;
    }

    /**
     * @return the backButton
     */
    public JButton getBackButton() {
        return backButton;
    }

    /**
     * @return the loginButton
     */
    public JButton getLoginButton() {
        return loginButton;
    }

    /**
     * @return the CREATE
     */
    public JButton getCREATE() {
        return CREATE;
    }

    /**
     * @return the close
     */
    public JButton getClose() {
        return close;
    }

    /**
     * @return the add1
     */
    public JButton getAdd1() {
        return add1;
    }

    /**
     * @return the add5
     */
    public JButton getAdd5() {
        return add5;
    }

    /**
     * @return the add10
     */
    public JButton getAdd10() {
        return add10;
    }

    /**
     * @return the add25
     */
    public JButton getAdd25() {
        return add25;
    }

    /**
     * @return the add50
     */
    public JButton getAdd50() {
        return add50;
    }

    /**
     * @return the add100
     */
    public JButton getAdd100() {
        return add100;
    }

    /**
     * @return the reset
     */
    public JButton getReset() {
        return reset;
    }

    /**
     * @return the allIn
     */
    public JButton getAllIn() {
        return allIn;
    }

    /**
     * @return the playButton
     */
    public JButton getPlayButton() {
        return playButton;
    }

    /**
     * @return the hitButton
     */
    public JButton getHitButton() {
        return hitButton;
    }

    /**
     * @return the standButton
     */
    public JButton getStandButton() {
        return standButton;
    }

    /**
     * @return the doubleButton
     */
    public JButton getDoubleButton() {
        return doubleButton;
    }

    /**
     * @return the mainMenuButton
     */
    public JButton getMainMenuButton() {
        return mainMenuButton;
    }

    /**
     * @return the restartButton
     */
    public JButton getRestartButton() {
        return restartButton;
    }

    /**
     * @return the endGameButton
     */
    public JButton getEndGameButton() {
        return endGameButton;
    }

    /**
     * @return the homePanel
     */
    public JPanel getHomePanel() {
        return homePanel;
    }

    /**
     * @return the blackJack
     */
    public JLabel getBlackJack() {
        return blackJack;
    }

    /**
     * @return the dealer
     */
    public Dealer getDealer() {
        return dealer;
    }

    /**
     * @return the newLoginPanel
     */
    public JPanel getNewLoginPanel() {
        return newLoginPanel;
    }

    /**
     * @return the existLabel
     */
    public JLabel getExistLabel() {
        return existLabel;
    }

    /**
     * @return the dealerMessage
     */
    public JOptionPane getDealerMessage() {
        return dealerMessage;
    }

    /**
     * @return the bottomLoginPanel
     */
    public JPanel getBottomLoginPanel() {
        return bottomLoginPanel;
    }

    /**
     * @return the nameField
     */
    public JTextField getNameField() {
        return nameField;
    }

    /**
     * @return the failMessage
     */
    public JOptionPane getFailMessage() {
        return failMessage;
    }

    /**
     * @return the reLoginPanel
     */
    public JPanel getReLoginPanel() {
        return reLoginPanel;
    }

    /**
     * @return the newLabel
     */
    public JLabel getNewLabel() {
        return newLabel;
    }

    /**
     * @return the bottomRePanel
     */
    public JPanel getBottomRePanel() {
        return bottomRePanel;
    }

    /**
     * @return the leaderboardPanel
     */
    public JPanel getLeaderboardPanel() {
        return leaderboardPanel;
    }

    /**
     * @return the bettingPanel
     */
    public JPanel getBettingPanel() {
        return bettingPanel;
    }

    /**
     * @return the bank
     */
    public JLabel getBank() {
        return bank;
    }

    /**
     * @return the pot
     */
    public JLabel getPot() {
        return pot;
    }

    /**
     * @return the bottomBetPanel
     */
    public JPanel getBottomBetPanel() {
        return bottomBetPanel;
    }

    /**
     * @return the gamePanel
     */
    public JPanel getGamePanel() {
        return gamePanel;
    }

    /**
     * @return the topCardPanel
     */
    public JPanel getTopCardPanel() {
        return topCardPanel;
    }

    /**
     * @return the bottomCardPanel
     */
    public JPanel getBottomCardPanel() {
        return bottomCardPanel;
    }

    /**
     * @return the statusLabel
     */
    public JLabel getStatusLabel() {
        return statusLabel;
    }

    /**
     * @return the userScore
     */
    public JLabel getUserScore() {
        return userScore;
    }

    /**
     * @return the dealerScore
     */
    public JLabel getDealerScore() {
        return dealerScore;
    }

    /**
     * @return the noPotMessage
     */
    public JOptionPane getNoPotMessage() {
        return noPotMessage;
    }

    /**
     * @return the status
     */
    public int getStatus() {
        return status;
    }

    /**
     * @return the restartPanel
     */
    public JPanel getRestartPanel() {
        return restartPanel;
    }

    /**
     * @return the winPanel
     */
    public JPanel getWinPanel() {
        return winPanel;
    }

    /**
     * @return the losePanel
     */
    public JPanel getLosePanel() {
        return losePanel;
    }

    /**
     * @return the blackjackPanel
     */
    public JPanel getBlackjackPanel() {
        return blackjackPanel;
    }

    /**
     * @return the winLabel
     */
    public JLabel getWinLabel() {
        return winLabel;
    }

    /**
     * @return the loseLabel
     */
    public JLabel getLoseLabel() {
        return loseLabel;
    }

    /**
     * @return the blackjackLabel
     */
    public JLabel getBlackjackLabel() {
        return blackjackLabel;
    }

    /**
     * @return the stopMessage
     */
    public JOptionPane getStopMessage() {
        return stopMessage;
    }
}
