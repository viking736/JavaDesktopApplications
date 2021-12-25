package com.company;

import java.util.HashMap;

public class IDAndPasswords {

    private HashMap<String, String> logInInfo = new HashMap<String, String>();

    IDAndPasswords(){

        logInInfo.put("John", "rice");
        logInInfo.put("Andrew", "ArandomPassword");
        logInInfo.put("Jack", "barcelona_fan");

    }

    protected HashMap<String, String> getLogInInfo() {
        return logInInfo;
    }
}
