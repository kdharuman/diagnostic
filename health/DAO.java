package com.teembinsys;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.List;
import java.util.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class DAO
{
	public static List getMediums(){ 
        PreparedStatement pStmt = null; 
        Connection conn = null; 
        boolean success = false; 
        ResultSet rs = null; 
        List medList = new ArrayList(); 
     
        try{ 
        	conn = getConnection(); 
          
        	String sql = " select * from MEDIUM "; 
        	pStmt = conn.prepareStatement(sql); 
                   
        	rs = pStmt.executeQuery(); 
        	while(rs.next()){ 
        		Medium med = new Medium(); 
        		med.setMedId(rs.getInt("MED_ID")); 
        		med.setMedName(rs.getString("MEDIUM_NAME")); 
        		medList.add(med); 
             } 
     
        }catch(Exception e){ 
        	e.printStackTrace(); 
          
        }finally{ 
        	closeConnectionProp(conn,pStmt,rs); 
        } 
         
     return medList; 
     
    } 
}
