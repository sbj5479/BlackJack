/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package blackjack2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author greay
 */
public class DatabaseTest {
    
    public DatabaseTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
//        Database database = new Database();
//        
//        String url = "jdbc:derby:BlackjackDB;create=true";
//        String dbusername = "pdc";
//        String dbpassword = "pdc";
//        try{
//        Connection connection = DriverManager.getConnection(url, dbusername, dbpassword);
//            Statement statement = connection.createStatement();
//        
//        
//            
//            statement.executeUpdate("DELETE FROM PlayerTable WHERE username = 'James'");
//        } catch (SQLException ex) {
//            Logger.getLogger(Database.class.getName()).log(Level.SEVERE, null, ex);
//        }
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }


    @Test
    public void testCheckName() {
        Database database = new Database();
        database.dbsetup();
        
        System.out.println("checkName");
        String username = "Cam";
        boolean expResult = true;
        
        Data result = database.checkName(username);
        
        assertEquals(expResult, result.loginFlag);
        
    }
    
    
    
    @Test
    public void testCheckName2() {
        Database database = new Database();
        database.dbsetup();
        
        System.out.println("checkName2");
        String username = "Ivan";
        boolean expResult = false;
        
        Data result = database.checkName(username);
        
        assertEquals(expResult, result.loginFlag);
        
    }
    
    
    @Test
    public void testNewName()
    {
        Database database = new Database();
        database.dbsetup();
        
        System.out.println("newName");
        String username = "Cam";
        boolean expResult = false;
       
        Data result = database.newName(username);
        assertEquals(expResult, result.loginFlag);
        
    }
    
    
    @Test
    public void testNewName2()
    {
        Database database = new Database();
        database.dbsetup();
        
        System.out.println("newName2");
        String username = "James";
        boolean expResult = true;
       
        Data result = database.newName(username);
        assertEquals(expResult, result.loginFlag);
        
    }
    
    
    @Test
    public void testAddCoins()
    {
        Database database = new Database();
        database.dbsetup();
        
        System.out.println("addCoins");
        
        User testUser = new User("Cameron", 1001, true);
        
        database.addCoins(testUser);
        
        
        
        assertEquals(1001, testUser.getCoins());
    }
    
}
