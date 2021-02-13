package com.example.faheemapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.Selection;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import com.chaos.view.PinView;

public class authenticationOTPActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_authentication_o_t_p);
        getSupportActionBar().hide(); // Hide the action bar in the screen


        ////
        // When click on back button take the user back to the main screen
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                authenticationActivity(); // call authenticationActivity function so when user click the button the authenticationActivity is opened
            }
        });
        Button verifyButton = findViewById(R.id.actionButton);
        PinView OTPCode = findViewById(R.id.OTP_Pin);
        verifyButton.setEnabled(false); // By default make the button disable until the condition in the if statement is triggered

        OTPCode.addTextChangedListener(new TextWatcher() { // Use TextWatcher method to track any changes in the textEdit
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (s.toString().length() == 4){
                    verifyButton.setEnabled(true);
                }
                else
                    verifyButton.setEnabled(false);
            }
            @Override
            public void afterTextChanged(Editable s) {
            }
        });
        verifyButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                allergyTypeActivity();
            }
        });
    }
    public void authenticationActivity() {
        Intent intent = new Intent(this, authenticationActivity.class);
        startActivity(intent);
    }
    public void allergyTypeActivity(){
        Intent intent = new Intent(this, AllergyTypeActivity.class);
        startActivity(intent);
    }

    ////
}