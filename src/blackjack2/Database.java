/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author greay
 */
public class Database {

    Connection connection = null;
    String url = "jdbc:derby:BlackjackDB;create=true";
    String dbusername = "pdc";
    String dbpassword = "pdc";

    String username;
    Data data;

    public Database() {
        data = new Data(); // Initialize an instance of Data.
    }

    public void dbsetup() {
        try {
            connection = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = connection.createStatement();
            String tableName = "PlayerTable";

            if (!checkTableExisting(tableName)) {
                System.out.println("NEW TABLE");
                statement.execute("CREATE TABLE " + tableName + " (username VARCHAR(20), coins INT)");
            }
            System.out.println("OLD TABLE");
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Data checkName(String username) {
//        Data data = new Data(); // Initialize an instance of Data.
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, coins FROM PlayerTable "
                    + "WHERE username = '" + username + "'");
            if (rs.next()) {

                System.out.println("found user");

                int pCoins = rs.getInt("coins");
                System.out.println(pCoins);
                data.user = new User(username, pCoins, true);

                /**
                 * If the username exists in the USERINFO table, and the
                 * password is correct, change the value of relating attributes
                 * of data. Otherwise, keep loginFlag as false.
                 */
                data.loginFlag = true;
                data.reFail = false;

            } else {
                System.out.println("no user");
                data.loginFlag = false;
                data.reFail = true;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; //Back to checkName() of Model.java.
    }

    public Data newName(String username) {

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, coins FROM PlayerTable "
                    + "WHERE username = '" + username + "'");
            if (rs.next() == false) {

                System.out.println("USER NOT FOUND");
                statement.executeUpdate("INSERT INTO PlayerTable "
                        + "VALUES('" + username + "', 1000)");
                data.user = new User(username, 1000, true);
                data.loginFlag = true;
                data.reFail = false;

            } else {
                System.out.println("TEST");
                data.loginFlag = false;
                data.reFail = false;

            }

            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; //Back to checkName() of Model.java.
    }

    public ArrayList topScores() {
        //instantiate variables
        ArrayList<Player> nameList = new ArrayList<>();
        ArrayList name = new ArrayList();
        ArrayList score = new ArrayList();
        HashMap scoreMap = new HashMap();

        Statement statement;
        try {
            statement = connection.createStatement();

            ResultSet rs = statement.executeQuery("SELECT * FROM PlayerTable");
            
            while (rs.next()) {
                int pCoins = rs.getInt("coins");
                String pName = rs.getString("username");
                //add to hashmap
                scoreMap.put(pName, pCoins);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

//        //create central file components for scores.txt
//        FileIO scoresinout = new FileIO("scores");
//        //read from scores.txt and add contents to hashmap
//        scoreMap = scoresinout.ReadH();
        //create entrySet for scoreMap
        Set sSet = scoreMap.entrySet();
        //loop through each object in the hashmap/set
        for (Object e : sSet) {
            //split the name from score and store in each arraylist
            String str[] = e.toString().split("=");
            name.add(str[0]);
            score.add(str[1]);
        }

        //add players to list
        for (int i = 0; i < name.size(); i++) {
            //convert name and score into string and int respectively
            String namev = name.get(i).toString();
            int scorev = Integer.parseInt((String) score.get(i));
            //add all players
            if (namev.equals("Dealer")) {
                Player dealer = new Dealer("Dealer");
                nameList.add(dealer);
            } else {
                Player user = new User(namev, scorev, false);
                nameList.add(user);
            }
        }
        //find 5 highest scores
        ArrayList<Player> topScores = new ArrayList<>();
        HashMap topPlayers = new HashMap();
        for (int i = 0; i < 5; i++) {
            Player top = nameList.get(0);
            for (int j = 0; j < nameList.size(); j++) {
                if (nameList.get(j).getCoins() > top.getCoins()) {
                    top = nameList.get(j);
                }
            }
            //add top 5 players to arraylist and hashmap
            topScores.add(top);
            topPlayers.put(top.getName(), top.getCoins());
            nameList.remove(top);
        }
        //print out top scores
//        System.out.println("---------------------------------------------------------------");
//        for(int k = 0 ; k < topScores.size(); k++)
//        {
////            System.out.println(k+1 + "." + topScores.get(k).getName() + "  " + topScores.get(k).getCoins());
//        }
//        System.out.println("---------------------------------------------------------------");
        try {
            //        //create central file components for topScores.txt
//        FileIO topinout = new FileIO("topScores");
//        //write to topScores.txt 
//        topinout.WriteH(topPlayers);

            connection = DriverManager.getConnection(url, dbusername, dbpassword);

            statement = connection.createStatement();
            String tableName = "LeaderboardTable";

            if (!checkTableExisting(tableName)) {
                System.out.println("NEW TABLE");
                statement.execute("CREATE TABLE " + tableName + " (username VARCHAR(20), coins INT)");
            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            for (int k = 0; k < topScores.size(); k++) {
                connection = DriverManager.getConnection(url, dbusername, dbpassword);
                statement = connection.createStatement();
                statement.executeUpdate("INSERT INTO LeaderboardTable "
                        + "VALUES('" + topScores.get(k).getName() + "', " + topScores.get(k).getCoins()+")");
//            System.out.println(k+1 + "." + topScores.get(k).getName() + "  " + topScores.get(k).getCoins());
            }
        } catch (SQLException ex)  {
                Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
            }
 
        

            return topScores;
        }

    

    public void addCoins(User a) {
        //instantiate variables

        int coins = a.getCoins();
        String name = a.getName();
//        HashMap scoreMap;
//        
//        //create central file components for each scores.txt
//        FileIO scoresinout = new FileIO("scores");
//        
//        //read from scores.txt and add contents to hashmap
//        scoreMap = scoresinout.ReadH();
//        
//        //remove user
//        scoreMap.remove(name);
//        //put in user with new coins
//        scoreMap.put(name, coins);
//        
//        //write to scores.txt 
//        scoresinout.WriteH(scoreMap);
        Statement statement;
        try {
            statement = connection.createStatement();
            statement.executeUpdate("UPDATE PlayerTable SET coins = " + coins + " "
                    + "WHERE username = '" + name + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean checkTableExisting(String newTableName) {
        boolean flag = false;
        try {

//            System.out.println("check existing tables.... ");
            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);
            //Statement dropStatement=null;
            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {
//                    System.out.println(tableName + "  is there");
                    flag = true;
                }
            }
            if (rsDBMeta != null) {
                rsDBMeta.close();
            }
        } catch (SQLException ex) {
        }
        return flag;
    }

    
//    public void quitGame(int score, String username) {
//        Statement statement;
//        try {
//            statement = conn.createStatement();
//            statement.executeUpdate("UPDATE UserInfo SET score=" + score + " WHERE userid='" + username + "'");
//
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
//
//    }
}
