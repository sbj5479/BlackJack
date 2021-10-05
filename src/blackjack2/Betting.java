/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.util.InputMismatchException;
import java.util.Scanner;

/**
 *
 * @author greay
 */
public class Betting {
    private int pot;
    private int bank;
    private int pay;
    
    
    public Betting(User user)
    {
        setBank(user.getCoins());
        setPot(0);
        setPay(-1);
    }
    
    public int placeBets(User user)
    {
        //create scanner
        Scanner scan = new Scanner(System.in);
        //must have at least 1 coin in pot to play
        //while pot is empty or user has not selected to play and pot is less than users total coins
        while(pay!=8 && pot < user.getCoins() || pot < 1)
                {
                    System.out.println("You have $" + bank);
                    System.out.println("Pot: $"+ pot);
                    //asking for bets
                    //menu slightly changes depending on users bank value
                    if(bank >= 100)
                    {
                        System.out.println("1.$1  2.$5  3.$10  4.$25  5.$50  6.$100  7.ALL IN 8.PLAY 0.EXIT");                       
                        try{
                            //ask for input
                            pay = scan.nextInt();
                            if(pay == 1)
                            {
                                pot++;
                                bank--;
                            }
                            else if(pay==2)
                            {
                                pot+=5;
                                bank-=5;
                            }
                            else if(pay==3)
                            {
                                pot+=10;
                                bank-=10;
                            }
                            else if(pay==4)
                            {
                                pot+=25;
                                bank-=25;
                            }
                            else if(pay==5)
                            {
                                pot+=50;
                                bank-=50;
                            }
                            else if(pay==6)
                            {
                                pot+=100;
                                bank-=100;
                            }
                            else if(pay ==7)
                            {
                                pot+=bank;
                                bank = 0;
                            }
                            //if user tries to play wihtout making a bet
                            else if(pay == 8 && pot == 0)
                            {
                                System.out.println("Must add to pot");
                            }
                            else if(pay == 8)
                            {
                                
                                System.out.println("\n---------------------------------------------------------------");
                                System.out.println("PLAYING GAME");
                            }
                            else if (pay == 0)
                            {
                                System.out.println("EXITING");
                                System.exit(0);
                            }
                            //invalid inputs
                            else
                            {
                                System.out.println("Invalid number");
                                System.out.println("Please select from provided numbers");
                            }
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input");
                            System.out.println("Please select from provided numbers");
                            scan.next();
                        }

                    }
                    else if(bank >= 50)
                    {
                        System.out.println("1.$1  2.$5  3.$10  4.$25  5.$50  7.ALL IN  8.PLAY  0.EXIT");                       
                        try{
                            pay = scan.nextInt();
                            if(pay == 1)
                            {
                                pot++;
                                bank--;
                            }
                            if(pay==2)
                            {
                                pot+=5;
                                bank-=5;
                            }
                            if(pay==3)
                            {
                                pot+=10;
                                bank-=10;
                            }
                            if(pay==4)
                            {
                                pot+=25;
                                bank-=25;
                            }
                            if(pay==5)
                            {
                                pot+=50;
                                bank-=50;
                            }
                            if(pay ==7)
                            {
                                pot+=bank;
                                bank = 0;
                            }
                            else if(pay == 8 && pot == 0)
                            {
                                System.out.println("Must add to pot");
                            }
                            else if(pay == 8)
                            {
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("PLAYING GAME");
                            }
                            else if (pay == 0)
                            {
                                System.out.println("EXITING");
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("Invalid number");
                            }
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input");
                            scan.nextLine();
                        }
                    }
                    else if(bank >= 25)
                    {
                        System.out.println("1.$1  2.$5  3.$10  4.$25  7.ALL IN  8.PLAY  0.EXIT");                       
                        try{
                            pay = scan.nextInt();
                            if(pay == 1)
                            {
                                pot++;
                                bank--;
                            }
                            if(pay==2)
                            {
                                pot+=5;
                                bank-=5;
                            }
                            if(pay==3)
                            {
                                pot+=10;
                                bank-=10;
                            }
                            if(pay==4)
                            {
                                pot+=25;
                                bank-=25;
                            }
                            if(pay ==7)
                            {
                                pot+=bank;
                                bank = 0;
                            }
                            else if(pay == 8 && pot == 0)
                            {
                                System.out.println("Must add to pot");
                            }
                            else if(pay == 8)
                            {
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("PLAYING GAME");
                            }
                            else if (pay == 0)
                            {
                                System.out.println("EXITING");
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("Invalid number");
                            }
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input");
                            scan.nextLine();
                        }

                    }
                    else if(bank >= 10)
                    {
                        System.out.println("1.$1  2.$5  3.$10  7.ALL IN  8.PLAY  0.EXIT");                       
                        try{
                            pay = scan.nextInt();
                            if(pay == 1)
                            {
                                pot++;
                                bank--;
                            }
                            if(pay==2)
                            {
                                pot+=5;
                                bank-=5;
                            }
                            if(pay==3)
                            {
                                pot+=10;
                                bank-=10;
                            }
                            if(pay ==7)
                            {
                                pot+=bank;
                                bank = 0;
                            }
                            else if(pay == 8 && pot == 0)
                            {
                                System.out.println("Must add to pot");
                            }
                            else if(pay == 8)
                            {
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("PLAYING GAME");
                            }
                            else if (pay == 0)
                            {
                                System.out.println("EXITING");
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("Invalid number");
                            }
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input");
                            scan.nextLine();
                        }

                    }
                    else if(bank >= 5)
                    {
                        System.out.println("1.$1  2.$5  7.ALL IN  8.PLAY  0.EXIT");                       
                        try{
                            pay = scan.nextInt();
                            if(pay == 1)
                            {
                                pot++;
                                bank--;
                            }
                            if(pay==2)
                            {
                                pot+=5;
                                bank-=5;
                            }
                            if(pay ==7)
                            {
                                pot+=bank;
                                bank = 0;
                            }
                            else if(pay == 8 && pot == 0)
                            {
                                System.out.println("Must add to pot");
                            }
                            else if(pay == 8)
                            {
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("PLAYING GAME");
                            }
                            else if (pay == 0)
                            {
                                System.out.println("EXITING");
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("Invalid number");
                            }
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input");
                            scan.nextLine();
                        }

                    }
                    else
                    {
                        System.out.println("1.$1  7.ALL IN  8.PLAY  0.EXIT");                       
                        try{
                            pay = scan.nextInt();
                            if(pay == 1)
                            {
                                pot++;
                                bank--;
                            }
                            if(pay ==7)
                            {
                                pot+=bank;
                                bank = 0;
                            }
                            else if(pay == 8 && pot == 0)
                            {
                                System.out.println("Must add to pot");
                            }
                            else if(pay == 8)
                            {
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("PLAYING GAME");
                            }
                            else if (pay == 0)
                            {
                                System.out.println("EXITING");
                                System.exit(0);
                            }
                            else
                            {
                                System.out.println("Invalid number");
                            }
                        }
                        catch(InputMismatchException e)
                        {
                            System.out.println("Invalid input");
                            scan.nextLine();
                        }

                    }

                }
                //Respect the risk
                if(pay == 7)
                    System.out.println("ALL IN BABY! " + pot);
                return pot;
    }

    /**
     * @return the pot
     */
    public int getPot() {
        return pot;
    }

    /**
     * @param pot the pot to set
     */
    public void setPot(int pot) {
        this.pot = pot;
    }

    /**
     * @return the bank
     */
    public int getBank() {
        return bank;
    }

    /**
     * @param bank the bank to set
     */
    public void setBank(int bank) {
        this.bank = bank;
    }

    /**
     * @return the pay
     */
    public int getPay() {
        return pay;
    }

    /**
     * @param pay the pay to set
     */
    public void setPay(int pay) {
        this.pay = pay;
    }
    
    
}
