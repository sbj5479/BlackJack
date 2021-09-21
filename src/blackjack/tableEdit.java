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
import java.sql.Connection;
import java.sql.DatabaseMetaData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.sql.ResultSet;

public class tableEdit {

    private final DBManager dbManager;
    private final Connection conn;
    private Statement statement;

    public tableEdit() {
        dbManager = new DBManager();
        conn = dbManager.getConnection();
    }

    public void createPlayerTable(ResultSet rs) {
        //use the conn, initialize database by creating BOOK Table and insert records
        try{
            dbManager.establishConnection();
            Statement statement = conn.createStatement();
            
            DatabaseMetaData dbmd = conn.getMetaData();
            ResultSet resultTables = dbmd.getTables(null, null, "PLAYER", null);
            if(resultTables.next())
                statement.execute("DROP TABLE PLAYER");
            
            
            String sqlCreateTable="CREATE TABLE PLAYER (NAME VARCHAR(50), SCORE FLOAT)";

            statement.executeUpdate(sqlCreateTable);
            
            
             while(rs.next())
            {
                String name = rs.getString(1);
                float score = rs.getFloat(2);
                
                String sqlInsert="INSERT INTO PLAYER VALUES ('" + name + "', " + score + ")";
                statement.executeUpdate(sqlInsert);
            }
            
            
            
            rs.close();
            
            
        }catch(SQLException e){
            System.err.println("SQLException: " + e.getMessage());
        }
            
            
    }

    

    public ResultSet getPlayer() {
        /* You may need the following SQL statements for this method:

        * Query multiple tables:
        
          SELECT TITLE, PRICE, DISCOUNT FROM BOOK, PROMOTION WHERE BOOK.CATEGORY=PROMOTION.CATEGORY;

         */

        ResultSet rs = null;
        try{
            Statement statement = conn.createStatement();
            String sqlQuery = "SELECT NAME, SCORE FROM PLAYER";
            rs=statement.executeQuery(sqlQuery);
            
            
        }catch(SQLException e){
            Logger.getLogger(tableEdit.class.getName()).log(Level.SEVERE, null, e);
        }

        return (rs);

    }
    
    public void addNewPlayer(String name, Float score)
    {
        try{
            dbManager.establishConnection();
            Statement statement = conn.createStatement();
            
            
            
            
            
            String sqlInsert="INSERT INTO PLAYER VALUES ('" + name + "', " + score + ")";
            statement.executeUpdate(sqlInsert);
            
            
            
            
            
            
            
        }catch(SQLException e){
            System.err.println("SQLException: " + e.getMessage());
        }
    }

}