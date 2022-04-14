package com.example.fyp_2022;

import static com.example.fyp_2022.LoginActivity.getUsername;

import androidx.appcompat.app.AppCompatActivity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class HomeActivity extends AppCompatActivity {

    ImageView Logoimage;
    TextView Slogan;
    TextInputLayout  Pulserate, Weight, Height, BodyTemp, BloodTemp, SugarLevel;
    Button Loginback;
    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        intia();
        Listners();
    }

    private Boolean validatePulserate() {
        String val = Pulserate.getEditText().getText().toString();

        if (val.isEmpty()) {
            Pulserate.setError("Field cannot be Empty");
            return false;
        } else {
            Pulserate.setError(null);
            Pulserate.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateWeight() {
        String val = Weight.getEditText().getText().toString();

        if (val.isEmpty()) {
            Weight.setError("Field cannot be Empty");
            return false;
        } else {
            Weight.setError(null);
            Weight.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateHeight() {
        String val = Height.getEditText().getText().toString();

        if (val.isEmpty()) {
            Height.setError("Field cannot be Empty");
            return false;
        } else {
            Height.setError(null);
            Height.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateBodyTemp() {
        String val = BodyTemp.getEditText().getText().toString();

        if (val.isEmpty()) {
            BodyTemp.setError("Field cannot be Empty");
            return false;
        } else {
            BodyTemp.setError(null);
            BodyTemp.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateBloodTemp() {
        String val = BloodTemp.getEditText().getText().toString();

        if (val.isEmpty()) {
            BloodTemp.setError("Field cannot be Empty");
            return false;
        } else {
            BloodTemp.setError(null);
            BloodTemp.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateSugarLevel() {
        String val = SugarLevel.getEditText().getText().toString();

        if (val.isEmpty()) {
            SugarLevel.setError("Field cannot be Empty");
            return false;
        } else {
            SugarLevel.setError(null);
            SugarLevel.setErrorEnabled(false);
            return true;
        }
    }

//    private Boolean validateName() {
//        String val = Username.getEditText().getText().toString();
//        String noWhiteSpace = "\\A\\w{4,20}\\z";
//
//        if (val.isEmpty()) {
//            Username.setError("Field cannot be Empty");
//            return false;
//        } else if (val.length() >= 15) {
//            Username.setError("Username too Long");
//            return false;
//        } else if (!val.matches(noWhiteSpace)) {
//            Username.setError("White space not allowed");
//            return false;
//        } else {
//            Username.setError(null);
//            Username.setErrorEnabled(false);
//            return true;
//        }
//    }


    private void Listners() {

        Loginback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               // Boolean validateName = validateName();
                Boolean validatePulserate = validatePulserate();
                Boolean validateWeight = validateWeight();
                Boolean validateHeight = validateHeight();
                Boolean validateBodyTemp = validateBodyTemp();
                // Boolean validateConfirmPassword = validateConfirmPassword();
                Boolean validateBloodTemp = validateBloodTemp();
                Boolean validateSugarLevel = validateSugarLevel();


                if (!validatePulserate | !validateWeight | !validateHeight | !validateBodyTemp | !validateBloodTemp | !validateSugarLevel) {
                    return;
                }


               // String username = Username.getEditText().getText().toString();
                String pulserate = Pulserate.getEditText().getText().toString();
                String weight = Weight.getEditText().getText().toString();
                String height = Height.getEditText().getText().toString();
                String bodytemp = BodyTemp.getEditText().getText().toString();
                String bloodtemp = BloodTemp.getEditText().getText().toString();
                String sugarlevel = SugarLevel.getEditText().getText().toString();

                Intent intent = getIntent();
                String username=intent.getStringExtra("username");

                rootnode = FirebaseDatabase.getInstance();
                reference = rootnode.getReference("Patients").child("Medical-Data").child("" + (username));


                AdddataUserClass helperClass = new AdddataUserClass(pulserate, weight, height, bodytemp, bloodtemp, sugarlevel);
                reference.setValue(helperClass);

                Toast.makeText(HomeActivity.this, "Data Added", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void intia() {
        //Logoimage=findViewById(R.id.LogoImage);
        //Slogan=findViewById(R.id.Slogon);
        //Username = findViewById(R.id.username);
        Pulserate = findViewById(R.id.pulserate);
        Weight = findViewById(R.id.weight);
        Height = findViewById(R.id.height);
        BodyTemp = findViewById(R.id.bodytemp);
        Loginback = findViewById(R.id.adddata);
        BloodTemp = findViewById(R.id.bp);
        SugarLevel = findViewById(R.id.sugarlevel);
    }

}
