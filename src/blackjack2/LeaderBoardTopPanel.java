/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author greay
 */
public class LeaderBoardTopPanel extends JPanel{
    public Image image;
        
        public LeaderBoardTopPanel()
        {
            setPreferredSize(new Dimension(600, 300));
//            setBackground(Color.WHITE);
            this.image = new ImageIcon("./resources/leaderboard.jpg").getImage();
//            this.setBackground(Color.green);
//            this.setVisible(true);
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(this.image, 0, 0, null);
            
        }
}
