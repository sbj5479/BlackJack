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

            case "CREATE":
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
                if (bank - 1 == 0) {
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
                if (bank - 5 == 0) {
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
                if (bank - 10 == 0) {
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
                if (bank - 25 == 0) {
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
                if (bank - 50 == 0) {
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
                if (bank - 100 == 0) {
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

                cardTracker = false;
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
//                model.showDoub();

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
//                model.stand();
//                model.showDoub();
                cardQueue = model.dealerGame();
                try {
                    updateScores(cardQueue, 3);
                } catch (IOException ex) {
                    Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
                }
                break;

            case "DOUBLE":
//                model.showDoub();
//                model.doub();
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

            case "restart":
                model.addCoins();
                model.restart();
                view.statusLabel.setText("");
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
    public BufferedImage randomImage = null;
    public JLabel randomLabel = null;

    public void updateScores(Queue<String> queue, int status) throws IOException {
        view.dealerScore.setText("Dealer: " + model.data.dealerScore);
        System.out.println("User score: " + model.data.userScore);
        view.userScore.setText("User: " + model.data.userScore);
        BufferedImage cardImage = null;

        int origSize = queue.size();
        //normal game
        if (!model.data.startdealer) {
            for (int i = 0; i < origSize; i++) {
//            System.out.println("drawing");
//            System.out.println(i);
                String card = queue.poll();
                String subSuit = card.substring(5);
                String subNum = card.substring(0, 2);
                subSuit = subSuit.strip();
                subNum = subNum.strip();
                System.out.println("SUBSTRING: " + subSuit);
                System.out.println("SUBNUM: " + subNum);

                //m = random but after substring
                if (subSuit.equals("m")) {
                    randomImage = ImageIO.read(new File("./resources/random.jpg"));
                    randomLabel = new JLabel(new ImageIcon(randomImage));
                    view.topCardPanel.add(randomLabel);
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
                    if (status == 1) {
                        if (cardTracker) {
                            view.topCardPanel.add(picLabel);
                        } else {
                            view.bottomCardPanel.add(picLabel);
                        }
                    } else if (status == 2) {
                        view.bottomCardPanel.add(picLabel);
                    } else {
                        view.topCardPanel.remove(randomLabel);
                        view.topCardPanel.add(picLabel);
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
                            view.topCardPanel.add(picLabel);
                        } else {
                            view.bottomCardPanel.add(picLabel);
                        }
                    } else if (status == 2) {
                        view.bottomCardPanel.add(picLabel);
                    } else {
                        view.topCardPanel.remove(randomLabel);
                        view.topCardPanel.add(picLabel);
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
                            view.topCardPanel.add(picLabel);
                        } else {
                            view.bottomCardPanel.add(picLabel);
                        }
                    } else if (status == 2) {
                        view.bottomCardPanel.add(picLabel);
                    } else {
                        view.topCardPanel.remove(randomLabel);
                        view.topCardPanel.add(picLabel);
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
                            view.topCardPanel.add(picLabel);
                        } else {
                            view.bottomCardPanel.add(picLabel);
                        }
                    } else if (status == 2) {
                        view.bottomCardPanel.add(picLabel);
                    } else {
                        view.topCardPanel.remove(randomLabel);
                        view.topCardPanel.add(picLabel);
                    }

                }
                //flip cardTracker
                if (cardTracker) {
                    cardTracker = false;
                } else {
                    cardTracker = true;
                }
            }
            model.checkBust();
        } //if blackjack (first round 21)
        if (model.data.blackjack) {
            System.out.println("BLACKJACK");
            System.out.println("DEALER FLIPS CARD");
            //dealer has 1 last card to equal
            String dealerFlip = model.dealerCard();

            String subSuit = dealerFlip.substring(5);
            String subNum = dealerFlip.substring(0, 2);
            subSuit = subSuit.strip();
            subNum = subNum.strip();
            System.out.println("SUBSTRING: " + subSuit);
            System.out.println("SUBNUM: " + subNum);

//            System.out.println("SUBSTRING: " + subCard);
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
                view.topCardPanel.remove(randomLabel);
                view.topCardPanel.add(picLabel);

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
                view.topCardPanel.remove(randomLabel);
                view.topCardPanel.add(picLabel);
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
                view.topCardPanel.remove(randomLabel);
                view.topCardPanel.add(picLabel);
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
                view.topCardPanel.remove(randomLabel);
                view.topCardPanel.add(picLabel);

            }
            model.checkWin();
        } //player gets 21 and auto stands
        //(startdealer == true)
        else if (model.data.startdealer){
            for (int i = 0; i < origSize; i++) {
                System.out.println("DEALER STARTS HERE");
//            System.out.println("drawing");
//            System.out.println(i);
                String card = queue.poll();
                String subSuit = card.substring(5);
                String subNum = card.substring(0, 2);
                subSuit = subSuit.strip();
                subNum = subNum.strip();
                System.out.println("SUBSTRING: " + subSuit);
                System.out.println("SUBNUM: " + subNum);
//            System.out.println("SUBSTRING: " + subCard);

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
                    //status  = 1 start of game
                    //2 = player hit
                    //3 dealer
                    view.bottomCardPanel.add(picLabel);
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
                    view.bottomCardPanel.add(picLabel);
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
                    view.bottomCardPanel.add(picLabel);
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
                    view.bottomCardPanel.add(picLabel);

                }

            }

            Queue<String> dealerHand = model.dealerGame();
            int dealerhandSize = dealerHand.size();
            for (int i = 0; i < dealerhandSize; i++) {
                String dealerCard = dealerHand.poll();

                String subDealer = dealerCard.substring(5);
                String subNum = dealerCard.substring(0, 2);
                subDealer = subDealer.strip();
                subNum = subNum.strip();
                System.out.println("SUBSTRING: " + subDealer);
                System.out.println("SUBNUM: " + subNum);

                view.dealerScore.setText("Dealer: " + model.data.dealerScore);
//            System.out.println("SUBSTRING: " + subCard);

                //m = random but after substring
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
                    view.topCardPanel.remove(randomLabel);
                    view.topCardPanel.add(picLabel);

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
                    view.topCardPanel.remove(randomLabel);
                    view.topCardPanel.add(picLabel);
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
                    view.topCardPanel.remove(randomLabel);
                    view.topCardPanel.add(picLabel);
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
                    view.topCardPanel.remove(randomLabel);
                    view.topCardPanel.add(picLabel);

                }
            }

            model.checkWin();

        }

    }

//        if(model.data.userScore > 21)
//        {
//            model.bust();
//        }
//        else if(model.data.userScore == 21)
//        {
//            model.blackjack();
//        }
}
