/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author greay
 */
public class Controller implements ActionListener{
    View view;
    Model model;
    
    public Controller(View view, Model model)
    {
        this.view = view;
        this.model = model;
        this.view.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String command = e.getActionCommand(); // Obtain the text displayed on the component.
        switch (command) {
            case "New Player":
                
                break;
            case "Next":
                
                break;
            case "Quit":
                
                break;
            default:
                break;
        }
    }
    
    
    
}
