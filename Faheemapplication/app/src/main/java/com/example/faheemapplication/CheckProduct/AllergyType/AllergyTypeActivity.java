package com.example.faheemapplication.CheckProduct.AllergyType;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.RadioButton;


import com.example.faheemapplication.HomeScreen.mainScreen;
import com.example.faheemapplication.R;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class AllergyTypeActivity extends AppCompatActivity {
    ChildInfo info;
    String id;
    DatabaseReference Reference;
    Button saveButton;
    ImageButton backButton;
    AllergyType allergies;
    RadioButton RadioButton1,RadioButton2,RadioButton3,RadioButton4;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_allergy_type);
        getSupportActionBar().hide(); // Hide the action bar in the screen


        Reference = FirebaseDatabase.getInstance().getReference("child_info");
        saveButton = findViewById(R.id.actionButton);
        RadioButton1 = findViewById(R.id.RadioButton1); // Milk
        RadioButton2 = findViewById(R.id.RadioButton2); // Wheat
        RadioButton3 = findViewById(R.id.RadioButton3); // Egg
        RadioButton4 = findViewById(R.id.RadioButton4); // Nuts



        allergies = new AllergyType();
        id = Reference.push().getKey(); // Generate unique key for the user

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (RadioButton1.isChecked()){
                   allergies.setAllergy1("Milk");
                   Reference.child(id).child("typeOfallergy").setValue(allergies);
                }
                if (RadioButton2.isChecked()){
                    allergies.setAllergy2("Wheat");
                    Reference.child(id).child("typeOfallergy").setValue(allergies);
                }
                if (RadioButton3.isChecked()){
                    allergies.setAllergy3("Egg");
                    Reference.child(id).child("typeOfallergy").setValue(allergies);
                }
                if (RadioButton4.isChecked()){
                    allergies.setAllergy4("Nuts");
                    Reference.child(id).child("typeOfallergy").setValue(allergies);
                }

                info = new ChildInfo(id, allergies);
                Reference.child(id).setValue(info);


                Intent intent = new Intent(AllergyTypeActivity.this , AllergyTypeActivityInfoSaved.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(intent);
            }
        });

        backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mainActivity(); // call mainActivity function so when user click the button the mainActivity is opened
            }
        });
    }
    public void mainActivity(){
        Intent intent = new Intent(this, mainScreen.class);
        startActivity(intent);
    }
}
