/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 * @author greay
 */
public class BettingPanel extends JPanel{
    public Image image;
        
        public BettingPanel()
        {
            setPreferredSize(new Dimension(600, 600));
            this.image = new ImageIcon("./resources/betting.jpg").getImage();
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            g.drawImage(this.image, 0, 0, null);
            
        }
}
