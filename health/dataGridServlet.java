package com.teembinsys;
import java.io.IOException;
import java.util.Enumeration;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Cookie;
import com.teembinsys.userServices;
 
public class dataGridServlet extends HttpServlet {
 
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         
    	System.out.println("Reached the servlet dataGridServlet");
    	
        String actionValue = "";
        String useridselected = "";
        Enumeration en = request.getParameterNames();
        while (en.hasMoreElements()) {
            useridselected = (String) en.nextElement();            
            actionValue = request.getParameter(useridselected);  
        }
        if(useridselected.trim().equalsIgnoreCase("")){
            request.setAttribute("errorMessage","Cannot find user id");
            clearCookieUserManager(request, response);
            request.getRequestDispatcher("/Login.jsp").forward(request, response);
        }else{            
            if(actionValue.contains("Remove")){    
                userServices userServis = new userServices();
                if(userServis.deleteUser(useridselected)){
                    request.setAttribute("successMessage", "Successfully delete user: <b>" + useridselected + "</b>");
                    clearCookieUserManager(request, response);
                    request.getRequestDispatcher("/Login.jsp").forward(request, response);
                }else{
                    request.setAttribute("errorMessage", "Failed to delete user: <b>" + useridselected + "</b>, please try again");
                    clearCookieUserManager(request, response);
                   request.getRequestDispatcher("/Login.jsp").forward(request, response);
                }                
            }else{
                //process redirect to modify user page with query string user id
                //redirect to modify page
           }
        }
    }

    public static void clearCookieUserManager(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] collectionCookies = request.getCookies();
        for (Cookie c : collectionCookies) {
            if (c.getName().equalsIgnoreCase("FirstTimeAccessUserManager")) {
                c.setValue("");
                response.addCookie(c);
                break;
            }
        }
    }
}
