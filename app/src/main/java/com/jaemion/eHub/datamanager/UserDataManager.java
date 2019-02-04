package com.jaemion.eHub.datamanager;

public class UserDataManager {
    private static UserDataManager instance;

    public static UserDataManager getInstance() {
        if (instance == null)
            instance = new UserDataManager();
        return instance;
    }

    public UserDataManager() {

    }
}
