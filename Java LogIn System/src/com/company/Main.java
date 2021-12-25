package com.company;

public class Main {

    public static void main(String[] args) {

        IDAndPasswords idAndPasswords = new IDAndPasswords();


        LogInPage logInPage = new LogInPage(idAndPasswords.getLogInInfo());

    }
}
