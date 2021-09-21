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
public class HomePanel extends JPanel{
    
        public Image image;
        
        public HomePanel()
        {
            setPreferredSize(new Dimension(500, 500));
            setBackground(Color.WHITE);
//            this.image = new ImageIcon("./resources/T06_bg.jpg").getImage();
        }
        
        @Override
        public void paintComponent(Graphics g)
        {
            super.paintComponent(g);
            
        }
    }