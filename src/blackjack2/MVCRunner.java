/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import blackjack.*;

/**
 *
 * @author greay
 */
public class MVCRunner {
    
    public static void main(String[] args) {
        MVCRunner mainRunMVC = new MVCRunner();
    }

    public MVCRunner() {
        Model myModel = new Model();
        View myView = new View();
//        myModel.addObserver(myView);
        
        Controller myController = new Controller(myView, myModel);
        myModel.addObserver(myView); // Build connection between the view and the model.
    }
}
