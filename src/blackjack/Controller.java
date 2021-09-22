/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;

/**
 *
 * @author greay
 */
public class Controller implements ActionListener{
    Model model;
    View view;
    
    Controller(){
        
    }
    

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();
        
        if(source == view.getNewPlayer())
        {
            view.getHomePanel().setVisible(false);
            view.getNewPlayerPanel().setVisible(true);
            
            
        }
        
        if(source == view.getEnter())
        {
            model.addNewPlayer();

        }
        
    }
    
    public void addModel(Model m)
    {
        this.model = m;
    }
    
    public void addView(View v)
    {
        this.view = v;
    }
    
}
