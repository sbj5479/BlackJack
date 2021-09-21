/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

/**
 *
 * @author greay
 */
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.sql.ResultSet;

/**
 *
 * @author greay
 */
public class BlackJackGUI extends JPanel implements ActionListener{
    
    private JButton newPlayer;
    private JButton returnPlayer;
    private JButton leaderboard;
    private JButton exit;
    
    private JLabel name;
    private JTextField nameField;
    private JButton enter;
    
    private JPanel homePanel;
    private JPanel newPlayerPanel;
    
    public BlackJackGUI(){
        super(new BorderLayout());
        
        homePanel = new HomePanel();
        newPlayer = new JButton("New Player");
        returnPlayer = new JButton("Returning Player");
        leaderboard = new JButton("Leaderboard");
        exit = new JButton("X");
        
        newPlayer.addActionListener(this);
        
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
        
        enter.addActionListener(this);
        add(homePanel,BorderLayout.NORTH);
        add(newPlayerPanel, BorderLayout.CENTER);
        newPlayerPanel.setVisible(false);
        
        
        
        
    }
    
    public static void main(String[] args) {
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
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == newPlayer)
        {
            homePanel.setVisible(false);
            newPlayerPanel.setVisible(true);
            
            
        }
        
        if(source == enter)
        {
            tableEdit edit = new tableEdit();
            ResultSet rs = edit.getPlayer();
            edit.createPlayerTable(rs);
            String name = nameField.getText();
            System.out.println(name);
            Integer score = 1000;
            
<<<<<<< HEAD
            edit.addNewPlayer(name, score.floatValue(), rs);
=======
            edit.addNewPlayer(name, score.floatValue());
>>>>>>> f089a947627930e1051f7b2ae54bc642c492471b
        }
        
    }
}
