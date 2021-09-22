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
public class MVCRunner {
    
    public static void main(String[] args) {
        MVCRunner mainRunMVC = new MVCRunner();
    }

    public MVCRunner() {
        Model myModel = new Model();
        View myView = new View();
//        myModel.addObserver(myView);
        
        Controller myController = new Controller();
        //pass the reference of model and view to the controllor
        myController.addModel(myModel);
        myController.addView(myView);
//        myController.initModel(start_value);
        myView.addController(myController);
    }
}
