/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack;

import java.sql.ResultSet;

/**
 *
 * @author greay
 */
public class Model {
    View view;
    
    public Model()
    {
        
    }
    public void addNewPlayer()
    {
        tableEdit edit = new tableEdit();
        ResultSet rs = edit.getPlayer();
        edit.createPlayerTable(rs);
        String name = view.getNameField().getText();
        System.out.println(name);
        Integer score = 1000;

        edit.addNewPlayer(name, score.floatValue());
    }
    
    public void exit()
    {
        System.exit(0);
    }
}
