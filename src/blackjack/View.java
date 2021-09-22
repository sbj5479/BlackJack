/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

/**
 *
 * @author greay
 */
public class View extends JPanel implements Observer{
    
    private JButton newPlayer;
    private JButton returnPlayer;
    private JButton leaderboard;
    private JButton exit;
    
    private JLabel name;
    private JTextField nameField;
    private JButton enter;
    
    private JPanel homePanel;
    private JPanel newPlayerPanel;
    
    public JButton getNewPlayer(){
        return this.newPlayer;
    }
    
    public JButton getReturnPlayer(){
        return this.returnPlayer;
    }
    
    public JButton getLeaderboard(){
        return this.leaderboard;
    }
    
    public JButton getExit(){
        return this.exit;
    }
    
    public JTextField getNameField(){
        return this.nameField;
    }
    
    public JButton getEnter(){
        return this.enter;
    }
    
    public JPanel getHomePanel(){
        return this.homePanel;
    }
    
    public JPanel getNewPlayerPanel(){
        return this.newPlayerPanel;
    }

    public View()
    {
        super(new BorderLayout());
        
        this.homePanel = new HomePanel();
        this.newPlayer = new JButton("New Player");
        this.returnPlayer = new JButton("Returning Player");
        this.leaderboard = new JButton("Leaderboard");
        this.exit = new JButton("X");
        
//        newPlayer.addActionListener(this);
        
        //home
        homePanel.add(newPlayer);
        homePanel.add(returnPlayer);
        homePanel.add(leaderboard);
        homePanel.add(exit);
        
        //newplayer
        newPlayerPanel = new JPanel();
        name = new JLabel("Name: ");
        nameField = new JTextField("      ");
//        nameField.setSize(100, 100);
        enter = new JButton("Enter");
        newPlayerPanel.add(name);
        newPlayerPanel.add(nameField);
        newPlayerPanel.add(enter);
        
//        enter.addActionListener(this);
        add(homePanel,BorderLayout.NORTH);
        add(newPlayerPanel, BorderLayout.CENTER);
        newPlayerPanel.setVisible(false);
        
        JFrame frame = new JFrame("BlackJack");
        // kill all threads when frame closes
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(new BlackJackGUI());
        frame.pack();
        // position the frame in the middle of the screen
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension screenDimension = tk.getScreenSize();
        Dimension frameDimension = frame.getSize();
        frame.setLocation((screenDimension.width-frameDimension.width)/2,
           (screenDimension.height-frameDimension.height)/2);
        frame.setVisible(true);
        // now display something while the main thread is still alive
    }
    
    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void addController(Controller controller) {
//        System.out.println("View      : adding controller");
        //need a controller before adding it as a listener 
        newPlayer.addActionListener(controller);
    }
}
