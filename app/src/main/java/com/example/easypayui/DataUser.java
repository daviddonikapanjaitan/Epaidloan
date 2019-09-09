package com.example.easypayui;

public class DataUser {

    //EditText nikKTP, userName, Password, Name, pin

    private String nikKTP;
    private String userName;
    private String password;
    private String name;
    private String pin;
    private String phoneNumber;
    private int balance;

    public String getNikKTP() {
        return nikKTP;
    }

    public String getUserName() {
        return userName;
    }

    public String getPassword() {
        return password;
    }

    public String getName() {
        return name;
    }

    public String getPin() {
        return pin;
    }

    public int getBalance() {
        return balance;
    }

    public String getPhoneNumber(){
        return phoneNumber;
    }

    public DataUser(){

    }

    public DataUser(String nikKTP, String userName, String password, String name, String pin, String phoneNumber,int balance) {
        this.nikKTP = nikKTP;
        this.userName = userName;
        this.password = password;
        this.name = name;
        this.pin = pin;
        this.phoneNumber = phoneNumber;
        this.balance = balance;
    }
}
