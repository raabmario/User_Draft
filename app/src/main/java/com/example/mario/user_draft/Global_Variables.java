package com.example.mario.user_draft;

import android.app.Application;

public class Global_Variables extends Application {
    int selected_userID;


    public int getSelected_userID() {
        return selected_userID;
    }

    public void setSelected_userID(int selected_userID) {
        this.selected_userID = selected_userID;
    }
}
