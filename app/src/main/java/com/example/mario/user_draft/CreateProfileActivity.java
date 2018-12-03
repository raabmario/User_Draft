package com.example.mario.user_draft;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class CreateProfileActivity extends Activity {

    EditText Vorname;
    EditText Name;
    EditText Email;
    EditText DOB;
    MyDBHelper dbHelper;
    TextView TV;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_profile);
        dbHelper = new MyDBHelper(this, null, null, 1);

        //Spinner layout
        Spinner dropdown = findViewById(R.id.spinnerGeschlecht);
        String[] items = new String[]{"Mann", "Frau"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);

        //Text Connection

        Vorname = (EditText)findViewById(R.id.inputVorname);
        Name = (EditText) findViewById(R.id.inputName);
        Email = (EditText)findViewById(R.id.inputEmail);
        DOB = (EditText)findViewById(R.id.inputDOB);




    }

    public void createButtonClicked(View view) {

        //if(DateCheck() == false){

            //Toast.makeText(CreateProfileActivity.this, "Bitte im Format TT/MM/JJJJ eingeben!",Toast.LENGTH_SHORT).show();
            //return;
        //}

        Spinner mySpinner = findViewById(R.id.spinnerGeschlecht);
        Users user = new Users(Vorname.getText().toString(), Name.getText().toString(), Email.getText().toString(), DOB.getText().toString(), mySpinner.getSelectedItem().toString());
        dbHelper.addUser(user);

        //TV.setText(mySpinner.getSelectedItem().toString());

    }

    public boolean DateCheck(){
        String testDOB = DOB.getText().toString();
        char [] cArray = testDOB.toCharArray();
        int checksum = 0;
        //Check if "/" exists in input
        if(Character.toString(cArray[2]).equals("/") ) {checksum++;}
        if(Character.toString(cArray[5]).equals("/")){checksum++;}
        //Check if stuff between "/" is int
        if(cArray[0] == (int)cArray[0]){checksum++;}
        if(cArray[1] == (int)cArray[0]){checksum++;}
        if(cArray[3] == (int)cArray[0]){checksum++;}
        if(cArray[4] == (int)cArray[0]){checksum++;}
        if(cArray[6] == (int)cArray[0]){checksum++;}
        if(cArray[7] == (int)cArray[0]){checksum++;}
        if(cArray[8] == (int)cArray[0]){checksum++;}
        if(cArray[9] == (int)cArray[0]){checksum++;}

        Toast.makeText(CreateProfileActivity.this, "_"+checksum+"_",Toast.LENGTH_SHORT);

        if(checksum == 10) {return true;}
        else{return false;}
    }


}
//