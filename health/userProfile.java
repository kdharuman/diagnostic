package com.teembinsys;
public class userProfile {
    private String _userid;
    private String _firstName;
    private String _lastName;
    private String _emailAddress;   
 
    public userProfile(){
        _userid = "";
        _firstName = "";
        _lastName = "";
        _emailAddress = "";      
    }
    public String getUserid() {
        return _userid;
    }
    public void setUserid(String userid) {
        this._userid = userid;
        System.out.println("User ID: " + this._userid);
    }
    public String getFirstName() {
        return _firstName;
    }
    public void setFirstName(String firstName) {
        this._firstName = firstName;
        System.out.println("User ID: " + this._firstName);
    }   
    public String getLastName() {
        return _lastName;
    }
    public void setLastName(String lastName) {
        this._lastName = lastName;
        System.out.println("User ID: " + this._lastName);
    }
    public String getEmailAddress() {
        return _emailAddress;
    }
    public void setEmailAddress(String emailAddress) {
        this._emailAddress = emailAddress;
        System.out.println("User ID: " + this._emailAddress);
    } 
}
