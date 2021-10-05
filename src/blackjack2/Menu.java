/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.Set;

/**
 *
 * @author greay
 */
public class Menu {
    private boolean newPlayer;
    
    public Menu()
    {
        //if it is a users first time this will remain true
        //if not changed to false
        setNewPlayer(true);
    }
    public static void main(String[] args) {
        
        
        
        //start of blackjack
        Menu menu = new Menu();
        //instantiate user to null
        //will be set to an actual user later on
        User user = null;
        //create a scanner for user input
        Scanner scan = new Scanner(System.in);
        //set user input to unaccepted value
        int input = -1;
        //set playing to false
        //will be changed to true after creation of user
        boolean playing =  false;
        
        
        
        System.out.println("Welcome to BlackJack");
        //main menu:
        //repeat asking for input from user
        while(input != 1 && input != 2 && input!=3 && input !=0)
        {
            System.out.println("1.New Player     2.Returning Player   3.Leaderboard    0.EXIT");
            try{
                //get input
                input = scan.nextInt();
                //new player
                if(input == 1)
                {
                    user = menu.createNewPlayer();
                    
                    playing = true;

                }
                //returning player
                else if(input == 2)
                {              
                    user = menu.existPlayer();
                    
                    playing  = true;
                    
                }
                //leaderboard
                else if(input == 3)
                {
                    menu.getLeaderboard();
                    input = -1;
                }
                //exit
                else if(input == 0)
                {
                    System.out.println("EXITING");
                    playing = false;
                }
                //repeat asking for input
                else
                {
                    System.out.println("Invalid number");
                    System.out.println("Please select 1, 2, 3 or 0");
                }
            }
            //throw exception if anything but a number is entered
            catch(InputMismatchException e)
            {
                System.out.println("Invalid input");
                System.out.println("Please select 1, 2, 3 or 0");
                scan.nextLine();
            }
        }
        //set to true after player is created
        //main loop that repeats while wanting to play a game
        while(playing)
        {
            //create the dealer
            Dealer dealer = new Dealer("Dealer");
            //isCreation set true once a player has 'successfully' been created
            //if new let dealer tell the rules
            if(menu.isNewPlayer() && user.isCreation())
            {
                System.out.print("\n");
                System.out.println(dealer);
                menu.setNewPlayer(false);
            }
            //start the game
            if(user.isCreation())
            {
                //if user has no coins exit automatically
                if(user.getCoins() == 0)
                {
                    System.out.println("Insufficient funds");
                    playing  = false;
                    System.out.println("EXITING");
                    return;
                }
                //else
                //start betting 
                Betting bet = new Betting(user);
                int pot = bet.placeBets(user);
                //bets are placed
                //instantiate a new game
                Game game = new Game();
                //play a game between the user and dealer
                game.play(user, dealer);
                
                //game is over
                //if win
                if(game.getWin()==1)
                {
                    System.out.println("YOU WIN");
                    //get user coins
                    int coins = user.getCoins();
                    //if blackjack
                    if(game.isBlackjack())
                    {
                        System.out.println("BLACKJACK X1.5");
                        //return is 3/2
                        double multiPot = pot * 1.5;
                        System.out.println("+" + multiPot);
                        //add coins
                        user.setCoins(coins += multiPot );
                    }
                    //if double
                    else if(game.isSelectDouble())
                    {
                        //return is 2/1
                        System.out.println("Double x2");
                        double multiPot = pot * 2;
                        System.out.println("+" + multiPot);
                        //add coins
                        user.setCoins(coins += multiPot);
                    }
                    
                    //regular win
                    else
                    {
                        System.out.println("+" + pot);
                        //add coins
                        user.setCoins(coins += pot );
                    }
                }
                //if lose
                else if(game.getWin()==2)
                {
                    System.out.println("YOU LOSE");
                    //get user coins
                    int coins = user.getCoins();
                    //if double
                    if(game.isSelectDouble())
                    {
                        System.out.println("Double x2");
                        //return is 2/1
                        double multiPot = pot * 2;
                        System.out.println("-" + multiPot);
                        //minus coins
                        user.setCoins(coins -= multiPot);
                    }
                    //regular lose
                    else
                    {
                        System.out.println("-" + pot);
                        //minus coins
                        user.setCoins(coins -= pot );
                    }
                }
                //draw/push/tie
                else
                {
                    System.out.println("PUSH");
                    //nothing changes
                    System.out.println("Coins refunded");
                }
                System.out.println("---------------------------------------------------------------");
                System.out.println("You now have " + user.getCoins() + "\n");
                //update user coins to score.txt
                menu.addCoins(user);
                //reset asking for input
                int ask = -1;
                //if user runs out of coins
                //automatic lose and exit
                if(user.getCoins() == 0)
                {
                    System.out.println("House Wins!");
                    playing = false;
                    System.out.println("Thanks for playing");
                    ask = 2;
                }
                
                //ask for user input
                while(ask!= 1 && ask!= 2 && ask!= 0)
                {
                    try{
                        
                        System.out.println("1.New Game  2.Leaderboard   0.EXIT");
                        //get user input
                        ask = scan.nextInt();
                        //exit
                        if(ask==0)
                        {
                            playing = false;
                            
                            System.out.println("Thanks for playing");
                            System.out.println("EXITING");
                        }
                        //leaderboard
                        //after ask for another input
                        else if(ask==2)
                        {
                            menu.getLeaderboard();
                            ask = -1;
                        }
                        //new game
                        //let 'playing' loop repeat
                        else if(ask==1)
                        {
                            System.out.println("---------------------------------------------------------------");
                        }
                        //repeat asking for input
                        else
                        {
                            System.out.println("Invalid number");
                            System.out.println("Please select 1, 2 or 0");
                            ask = -1;
                        }
                    }
                    //input is not a number
                    catch(InputMismatchException e)
                    {
                        System.out.println("Invalid input");
                        System.out.println("Please select 1, 2 or 0");
                        scan.next();
                    }
                }
            }
            //exit
            else
            {
                System.out.println("EXITING");
                playing  = false;
            }
        }
}
    
    public User createNewPlayer()
    {
        //instantiate variables
        String name;
        ArrayList myList;
        HashMap scoreMap;
        int counter = 0;
        
        //create scanner
        Scanner scan = new Scanner(System.in);
        
        //ask for name
        System.out.println("Please enter your name: ");
        name = scan.next();
        
        //create central file components for each file
        FileIO namesinout = new FileIO("names");
        FileIO scoresinout = new FileIO("scores");
        
        //read from names.txt and add contents to arraylist
        myList = namesinout.ReadL();
        //read from scores.txt and add contents to hashmap
        scoreMap = scoresinout.ReadH();
        
        
            
        //loop and search for existing user with name input
        for(Object e : myList)
        {
            //if already exists
            if(e.equals(name))
            {
                System.out.println("Record of " + name + " already exists.");
                counter++;
            } 
        }
        //if user does not exist
        if(counter == 0)
        {
            System.out.print("\n");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Welcome " + name);
            //add name to list
            myList.add(name);
            scoreMap.put(name, 1000);
            User a = new User(name, 1000,true);
            
            //write new list of names to names.txt 
            namesinout.WriteL(myList);
            //write new hashmap of names with scores to scores.txt
            scoresinout.WriteH(scoreMap);
            //return created user
            return a;
        } 
        //user already exists with same name
        else
        {
            //ask what user wants to do
            System.out.println("1.Login to existing account    2.Create new account   0.EXIT");
            try{
                int input  = scan.nextInt();
                //log into existing user
                if(input == 1)
                {
                    return existPlayer();

                }
                //create new user
                else if(input == 2)
                {
                    return createNewPlayer();
                }
                //exit by creating a new user with 'unsuccessful' creation
                else if(input == 0)
                {
                    User a = new User(name, 1000, false);
                    return a;
                }
                //repeat asking for input
                else
                {
                    System.out.println("Invalid number");
                    scan.next();
                }
            }
            //input is not a number
            //repeat asking for input
            catch(InputMismatchException e)
            {
                System.out.println("Invalid number");
                scan.nextLine();
            }
        }
        //never gets here
        return null;
            
    }
    
    
    public User existPlayer(){
        //instantiate variables
        String name;
        Scanner scan = new Scanner(System.in);
        ArrayList myList;
        HashMap scoreMap;
        int counter= 0;
        
        //ask for name
        System.out.println("Please enter your name: ");
        name = scan.next();
        
        //create central file components for each file
        FileIO namesinout = new FileIO("names");
        FileIO scoresinout = new FileIO("scores");
        //read from names.txt and add contents to arraylist
        myList = namesinout.ReadL();
        //read from scores.txt and add contents to hashmap
        scoreMap = scoresinout.ReadH();
        
         
        //search for name
        for(Object e : myList)
        {
            //if name is found
            if(e.equals(name))
            {
                counter++;
            }
        }
        //if found
        if(counter == 1)
        {
            System.out.print("\n");
            System.out.println("---------------------------------------------------------------");
            System.out.println("Welcome back " + name);
            
            int pCoins = Integer.valueOf((String)scoreMap.get(name));
            User a = new User(name, pCoins, true);
            setNewPlayer(false);
            //return user
            return a;
        }
        //cannot find
        else
        {
            System.out.println("Player does not exist");
            System.out.println("Please check spelling");
            System.out.println("1.Login to existing account    2.Create new user    0.EXIT");
            try{
                int input = scan.nextInt();
                //attempt to log in again
                if(input == 1)
                {
                    return existPlayer();
                }
                //create new player
                else if(input == 2)
                {
                    return createNewPlayer();

                }
                //exit by creating a new user with 'unsuccessful' creation
                else if(input == 0)
                {
                    User a = new User(name, 1000, false);
                    return a;
                }
                //repeat asking for input
                else 
                {
                    System.out.println("Invalid number");
                    scan.nextLine();
                }
            }
            //input is not a number
            //repeat asking for input
            catch(InputMismatchException e)
            {
                System.out.println("Invalid number");
                scan.nextLine();
            }
        }
        //will never get here
        return null;
    }
           
        

    private void addCoins(User a) {
        //instantiate variables
        int coins = a.getCoins();
        String name = a.getName();
        HashMap scoreMap;
        
        //create central file components for each scores.txt
        FileIO scoresinout = new FileIO("scores");
        
        //read from scores.txt and add contents to hashmap
        scoreMap = scoresinout.ReadH();
        
        //remove user
        scoreMap.remove(name);
        //put in user with new coins
        scoreMap.put(name, coins);
        
        //write to scores.txt 
        scoresinout.WriteH(scoreMap);
        
    }
    
    private void getLeaderboard()
    {
        //instantiate variables
        ArrayList<Player> nameList = new ArrayList<>();
        ArrayList name = new ArrayList();
        ArrayList score = new ArrayList();
        HashMap scoreMap;
        
        //create central file components for scores.txt
        FileIO scoresinout = new FileIO("scores");
        
        //read from scores.txt and add contents to hashmap
        scoreMap = scoresinout.ReadH();
        //create entrySet for scoreMap
        Set sSet = scoreMap.entrySet();
        //loop through each object in the hashmap/set
        for(Object e : sSet)
        {
            //split the name from score and store in each arraylist
            String str[] = e.toString().split("=");
            name.add(str[0]);
            score.add(str[1]); 
        }
        
        //add players to list
        for(int i = 0 ; i < name.size(); i ++)
        {
            //convert name and score into string and int respectively
            String namev = name.get(i).toString();
            int scorev = Integer.parseInt((String) score.get(i));
            //add all players
            if(namev.equals("Dealer"))
            {
                Player dealer = new Dealer("Dealer");
                nameList.add(dealer);
            }
            else
            {
                Player user = new User(namev, scorev, false);
                nameList.add(user);
            }
        }
        //find 5 highest scores
        ArrayList<Player> topScores = new ArrayList<>();
        HashMap topPlayers = new HashMap();
        for(int i = 0; i < 5; i ++)
        {
            Player top = nameList.get(0);
            for(int j=0; j< nameList.size(); j++)
            {
                if(nameList.get(j).getCoins()> top.getCoins())
                {
                    top = nameList.get(j);
                }
            }
            //add top 5 players to arraylist and hashmap
            topScores.add(top);
            topPlayers.put(top.getName(), top.getCoins());
            nameList.remove(top);
        }
        //print out top scores
        System.out.println("---------------------------------------------------------------");
        for(int k = 0 ; k < topScores.size(); k++)
        {
            System.out.println(k+1 + "." + topScores.get(k).getName() + "  " + topScores.get(k).getCoins());
        }
        System.out.println("---------------------------------------------------------------");
        
        
        //create central file components for topScores.txt
        FileIO topinout = new FileIO("topScores");
        //write to topScores.txt 
        topinout.WriteH(topPlayers);
        
    }

    /**
     * @return the newPlayer
     */
    public boolean isNewPlayer() {
        return newPlayer;
    }

    /**
     * @param newPlayer the newPlayer to set
     */
    public void setNewPlayer(boolean newPlayer) {
        this.newPlayer = newPlayer;
    }
    
    
}
    

