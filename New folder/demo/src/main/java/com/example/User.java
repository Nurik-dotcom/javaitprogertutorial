package com.example;

public class User {
    private String nam;
    private String surname;
    private String usrname;
    private String pswrd;
    private String gender;
    private String location;
    private String email;

    public User(String nam, String surname, String usrname, String pswrd, String gender, String location, String email){
        this.nam = nam;
        this.surname = surname;
        this.usrname = usrname;
        this.pswrd = pswrd;
        this.gender = gender;
        this.location = location;
        this.email = email;
    }

    public User(){
        
    }

    public String getFirstName(){
        return nam;
    }
    public void SetFirstName(String nam){
        this.nam = nam;
    }

    public String getSurName(){
        return surname;
    }
    public void SetSurName(String surname){
        this.surname = surname;
    }

    public String getUserName(){
        return usrname;
    }
    public void SetUserName(String usrname){
        this.usrname = usrname;
    }

    public String getPassword(){
        return pswrd;
    }
    public void SetPassword(String pswrd){
        this.pswrd = pswrd;
    }

    public String getGender(){
        return gender;
    }
    public void SetGender(String gender){
        this.gender = gender;
    }

    public String getLocation(){
        return location;
    }
    public void SetLocation(String location){
        this.location = location;
    }

    public String getEmail(){
        return email;
    }
    public void SetEmail(String email){
        this.email = email;
    }
}
