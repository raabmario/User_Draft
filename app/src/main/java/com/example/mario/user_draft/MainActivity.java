package com.example.mario.user_draft;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity {
    Button createProfileBtn;
    Button selectProfileBtn;
    Button test_area_Btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Global_Variables global_variables = (Global_Variables) getApplicationContext();
        global_variables.setSelected_userID(0);

        createProfileBtn = (Button) findViewById(R.id.createButton);
        selectProfileBtn = (Button) findViewById(R.id.selectButton);
        test_area_Btn = (Button) findViewById(R.id.button_to_test_area);

    }
    public void openCreateProfileActivity(){
        Intent intent = new Intent(this, CreateProfileActivity.class);
        startActivity(intent);
    }
    public void openDisplayProfileActivity(){
        Intent intent = new Intent(this, EditProfile.class);
        startActivity(intent);
    }

    public void openTestActivity(){
        Intent intent = new Intent(this, UserSelectionListActivity.class);
        startActivity(intent);
    }

    public void selectButtonClicked(View view) {
        openDisplayProfileActivity();
    }

    public void createButtonClicked(View view) {
        openCreateProfileActivity();
    }

    public void button_to_test_area_clicked(View view){
        openTestActivity();
    }
}
