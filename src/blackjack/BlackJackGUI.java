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
import javax.swing.JPanel;

/**
 *
 * @author greay
 */
public class BlackJackGUI extends JPanel implements ActionListener{
    
    private JButton newPlayer;
    private JButton returnPlayer;
    private JButton leaderboard;
    private JButton exit;
    
    private JPanel homePanel;
    
    public BlackJackGUI(){
        super(new BorderLayout());
        
        homePanel = new HomePanel();
        newPlayer = new JButton("New Player");
        returnPlayer = new JButton("Returning Player");
        leaderboard = new JButton("Leaderboard");
        exit = new JButton("X");
        
        
        homePanel.add(newPlayer);
        homePanel.add(returnPlayer);
        homePanel.add(leaderboard);
        homePanel.add(exit);
        
        add(homePanel,BorderLayout.CENTER);
        
        
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
