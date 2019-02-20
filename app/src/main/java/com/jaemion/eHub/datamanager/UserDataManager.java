package com.jaemion.eHub.datamanager;

import com.jaemion.eHub.network.NetworkInterface;
import com.jaemion.eHub.network.model.OrderListData;
import com.jaemion.eHub.network.model.UserDataModel;

public class UserDataManager {
    private static UserDataManager instance;

    public static UserDataManager getInstance() {
        if (instance == null)
            instance = new UserDataManager();
        return instance;
    }

    private NetworkInterface network;
    private UserDataModel userDataModel;
    private OrderListData listData;

    public UserDataManager() {
        network = NetworkInterface.retrofit.create(NetworkInterface.class);
    }

    public UserDataModel getUserDataModel() {
        if (userDataModel != null)
            return userDataModel;

        return userDataModel;
    }
    public void setUserDataModel(UserDataModel userDataModel){
        this.userDataModel = userDataModel;
    }
}
