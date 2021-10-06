/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.awt.BorderLayout;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author greay
 */
public class View extends JFrame implements Observer{

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
    
    
    public View()
    {
        this.homePanel = new JPanel();
        homePanel.setLayout(new BoxLayout(homePanel, BoxLayout.X_AXIS));
        this.newPlayer = new JButton("New Player");
        this.returnPlayer = new JButton("Returning Player");
        this.leaderboard = new JButton("Leaderboard");
        this.exit = new JButton("X");
        
        homePanel.add(newPlayer);
        homePanel.add(returnPlayer);
        homePanel.add(leaderboard);
        homePanel.add(exit);
        
        add(homePanel);
        
        
        loginButton = new JButton("login");
        
        
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 600);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
    }
    
    public void newLoginScreen()
    {
        
        newLoginPanel = new JPanel();
        name = new JLabel("Name:");
        nameField = new JTextField(20);
        createButton = new JButton("create");
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
    
    public void reLoginScreen()
    {
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
    
    
    
    public void addActionListener(ActionListener listener) {
        this.newPlayer.addActionListener(listener);
        this.returnPlayer.addActionListener(listener);
        this.exit.addActionListener(listener);
        this.loginButton.addActionListener(listener);
    }
    
    @Override
    public void update(Observable o, Object arg) {
        Data data = (Data) arg;
        if(!data.loginFlag)
        {
            this.nameField.setText("");
            this.failLogin.setText("Invalid name");
        }
        else 
        {
            System.out.println("starting game");
        }
    }
    
//    public void addContoller(Controller controller)
//    {
//        
//    }
    
    
}
