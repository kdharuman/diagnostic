package com.teembinsys;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
//import com.teembinsys.*;
 
public class userServices {
    public Connection getDbConn() {
        if(_dbConn == null){ 
           _dbConn = CheckConnection();
        }
        return _dbConn;
    }
    public void setDbConn(Connection aDbConn) {
        _dbConn = aDbConn;
    }
    public static String getDbUrl() {
        return _dbUrl;
    }
    public static void setDbUrl(String aDbUrl) {
 
        _dbUrl = aDbUrl;
 
    }  
    public static String getUser() {
        return _user;
    }
    public static void setUser(String aUser) {
        _user = aUser;
    }
    public static String getDbPassword() {
        return _dbPassword;
    }
 
    public static void setDbPassword(String aDbPassword) {
        _dbPassword = aDbPassword;
    }
 
    private List<userProfile> _collectionOfUserProfile;
    private static Connection _dbConn;
    private static String _dbUrl = "jdbc:oracle:thin:@localhost:1521/orcl";
    private static String _user = "scott";
    private static String _dbPassword = "a5newdelhi";
    private final static Logger LOGGER = Logger.getLogger(userServices.class.getName());
 
    public userServices() {
        _collectionOfUserProfile = new ArrayList<>();
        _dbUrl = "jdbc:oracle:thin:@localhost:1521/orcl";
        _user = "scott";
        _dbPassword = "a5newdelhi";
    }
    public List<userProfile> getAllUsers(int limitStart, int limitMax) {
        ResultSet rs = null;
        String strsql = "select username,firstname,lastname,email from signin where rownum > " + 
                                        Integer.toString(limitStart) + " and rownum <=" + 
        		                        Integer.toString(limitMax) +" order by username DESC";

        System.out.println("Inside getAllUsers");
        
        System.out.println("SQL string : " + strsql);
        
        Connection conn = null;
        try {
            conn = CheckConnection();
            conn.setAutoCommit(true);
            PreparedStatement prepStatement = conn.prepareStatement(strsql);
            rs = prepStatement.executeQuery();
 
            while (rs.next()) {
                userProfile user = new userProfile();
                user.setUserid(rs.getString("username"));
                user.setFirstName(rs.getString("firstname"));
                user.setLastName(rs.getString("lastname"));
                user.setEmailAddress(rs.getString("email"));
                _collectionOfUserProfile.add(user);
            }
 
        } catch (SQLException ex) {
            //handle catch
        } finally {
            closeConnection();
        }
        return _collectionOfUserProfile;
 
    }    
 
     public boolean deleteUser(String userid){
        boolean isSuccess = false;
        ResultSet rs = null;
        String strsql = "delete from signin where username=?";
        PreparedStatement prepStatement = null;        
        Connection conn = null;
        try {
            conn = CheckConnection();
            conn.setAutoCommit(true);
            int rtnCode = 0;
            getDbConn().setAutoCommit(false);
            prepStatement = conn.prepareStatement(strsql);
            prepStatement.setString(1, userid);
            rtnCode = prepStatement.executeUpdate();
            if (rtnCode > 0) {
                _dbConn.commit();
                isSuccess  =true;
            }else{                
                _dbConn.rollback();
                isSuccess  = false;
            }     
 
        } catch (SQLException ex) {
           //catch handler
        } finally {
            closeConnection();
        }       
 
        return isSuccess;
    }
    public int countTableDataRow(String TableName) {
        int ValCount = 0;
        Statement stmt = null;
        Connection conn = null;
        try {
            conn = CheckConnection();
            conn.setAutoCommit(true);
            String strsql = "SELECT Count(*) FROM " + TableName;
            System.out.println("Inside countTableDataRow function: ");
            System.out.println("SQL string: " + strsql);
            
            stmt = conn.createStatement();
            try (ResultSet rs = stmt.executeQuery(strsql)) {
                rs.next();
                ValCount = rs.getInt(1);
            }
        } catch (SQLException se) {
            //handle catch
        } finally {
            closeConnection();
        }
        return ValCount;
    }
    public void closeConnection() {
        try {
            if (_dbConn != null) {
                _dbConn.close();
            }
        } catch (SQLException ex) {
            //handle catch
        }
    }
    public Connection CheckConnection() {
        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
        } catch (ClassNotFoundException e) {
            LOGGER.info(e.getMessage());                    
        }     
 
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(_dbUrl, _user, _dbPassword);
        } catch (SQLException e) {
            LOGGER.info(e.getMessage());         
        }
        if (connection != null) {
            LOGGER.info("You made it, take control your database now!");            
             
        } else {
            LOGGER.info("Failed to make connection!");    
        }
        return connection;
    }
    public List<userProfile> getCollectionOfUserProfile() {
        return _collectionOfUserProfile;
    }
    public void setCollectionOfUserProfile(List<userProfile> collectionOfUserProfile) {
        this._collectionOfUserProfile = collectionOfUserProfile;
    }
}
