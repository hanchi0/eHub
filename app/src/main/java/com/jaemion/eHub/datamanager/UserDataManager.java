package com.jaemion.eHub.datamanager;

import com.jaemion.eHub.network.NetworkInterface;
import com.jaemion.eHub.network.model.OrderListData;
import com.jaemion.eHub.network.model.UserData;

public class UserDataManager {
    private static UserDataManager instance;

    public static UserDataManager getInstance() {
        if (instance == null)
            instance = new UserDataManager();
        return instance;
    }

    private NetworkInterface network;
    private UserData userData;
    private OrderListData listData;

    public UserDataManager() {
        network = NetworkInterface.retrofit.create(NetworkInterface.class);
    }

    public UserData getUserData() {
        if (userData != null)
            return userData;

        return userData;
    }
    public void setUserData(UserData userData){
        this.userData = userData;
    }
}
