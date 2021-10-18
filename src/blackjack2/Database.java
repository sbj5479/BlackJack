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

    //info for database
    Connection connection = null;
    String url = "jdbc:derby:BlackjackDB;create=true";
    String dbusername = "pdc";
    String dbpassword = "pdc";

    String username;
    Data data;

    public Database() {
        //initialize data
        data = new Data(); 
    }

    public void dbsetup() {
        //connect to the database
        try {
            connection = DriverManager.getConnection(url, dbusername, dbpassword);
            Statement statement = connection.createStatement();
            
            //create table if not exist
            String tableName = "PlayerTable";

            if (!checkTableExisting(tableName)) {
//                System.out.println("NEW TABLE");
                statement.execute("CREATE TABLE " + tableName + " (username VARCHAR(20), coins INT)");
            }
//            System.out.println("OLD TABLE");
            statement.close();

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Data checkName(String username) {
        //check for name in database
        try {
            Statement statement = connection.createStatement();
            //select name
            ResultSet rs = statement.executeQuery("SELECT username, coins FROM PlayerTable "
                    + "WHERE username = '" + username + "'");
            //if name exists
            if (rs.next()) {

//                System.out.println("found user");
                //create user
                int pCoins = rs.getInt("coins");
//                System.out.println(pCoins);
                data.user = new User(username, pCoins, true);

                /**
                 * If the username exists in the USERINFO table, and the
                 * password is correct, change the value of relating attributes
                 * of data. Otherwise, keep loginFlag as false.
                 */
                data.loginFlag = true;
                data.reFail = false;

            } else {
                //user does not exist
                System.out.println("no user");
                data.loginFlag = false;
                data.reFail = true;
            }
            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; 
    }

    public Data newName(String username) {
        //create a new user
        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery("SELECT username, coins FROM PlayerTable "
                    + "WHERE username = '" + username + "'");
            //if name does not exist
            if (rs.next() == false) {

//                System.out.println("USER NOT FOUND");
                //create a new user
                statement.executeUpdate("INSERT INTO PlayerTable "
                        + "VALUES('" + username + "', 1000)");
                data.user = new User(username, 1000, true);
                data.loginFlag = true;
                data.reFail = false;

            } 
            //user does exist
            else {
//                System.out.println("TEST");
                
                data.loginFlag = false;
                data.reFail = false;

            }

            rs.close();
//            statement.close();
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }
        return data; 
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
            //select everything form table
            ResultSet rs = statement.executeQuery("SELECT * FROM PlayerTable");
            
            //put name and coins into a map
            while (rs.next()) {
                int pCoins = rs.getInt("coins");
                String pName = rs.getString("username");
                //add to hashmap
                scoreMap.put(pName, pCoins);

            }

        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }


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
        
        try {
            
            //connect to the database
            connection = DriverManager.getConnection(url, dbusername, dbpassword);
            //create new leaderboard table
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
                //insert top 5 players
                statement.executeUpdate("INSERT INTO LeaderboardTable "
                        + "VALUES('" + topScores.get(k).getName() + "', " + topScores.get(k).getCoins()+")");
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
//        
        Statement statement;
        try {
            statement = connection.createStatement();
            //update players coins
            statement.executeUpdate("UPDATE PlayerTable SET coins = " + coins + " "
                    + "WHERE username = '" + name + "'");
        } catch (SQLException ex) {
            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private boolean checkTableExisting(String newTableName) {
        //check table from lab9
        boolean flag = false;
        try {

            String[] types = {"TABLE"};
            DatabaseMetaData dbmd = connection.getMetaData();
            ResultSet rsDBMeta = dbmd.getTables(null, null, null, null);//types);

            while (rsDBMeta.next()) {
                String tableName = rsDBMeta.getString("TABLE_NAME");
                if (tableName.compareToIgnoreCase(newTableName) == 0) {

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

    
}
