package com.example.fyp_2022;

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

import java.util.HashMap;

//Registration Activity

public class RegisterActivity extends AppCompatActivity {

    ImageView Logoimage;
    TextView Slogan;
    TextInputLayout Username, Phonenumber,Email,Password,Confirmpassword,Sex,Age;
    Button Loginback;
    FirebaseDatabase rootnode;
    DatabaseReference reference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        intia();
        Listners();
    }
    private Boolean validateName() {
        String val= Username.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if(val.isEmpty()){
            Username.setError("Field cannot be Empty");
            return false;
        }
        else if(val.length()>=15){
            Username.setError("Username too Long");
            return false;
        }
        else if(!val.matches(noWhiteSpace)){
            Username.setError("White space not allowed");
            return false;
        }
        else{
            Username.setError(null);
            Username.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validatePhonenumber() {
        String val=Phonenumber.getEditText().getText().toString();

        if(val.isEmpty()){
            Phonenumber.setError("Field cannot be Empty");
            return false;
        }
        else{
            Phonenumber.setError(null);
            Phonenumber.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateEmail(){
        String val=Email.getEditText().getText().toString();
        String emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";

        if(val.isEmpty()){
            Email.setError("Field cannot be Empty");
            return false;
        }
        else if(!val.matches(emailPattern)){
            Email.setError("Inavlid Email type");
            return false;
        }
        else{
            Email.setError(null);
            Email.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val=Password.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";


        if(val.isEmpty()){
            Password.setError("Field cannot be Empty");
            return false;
        }
        else if (!val.matches(passwordVal)) {
            Password.setError("Password is too weak");
            return false;
        }
        else{
            Password.setError(null);
            Password.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validateConfirmPassword(){
        String val=Confirmpassword.getEditText().getText().toString();
        String passwordVal = "^" +
                //"(?=.*[0-9])" +         //at least 1 digit
                //"(?=.*[a-z])" +         //at least 1 lower case letter
                //"(?=.*[A-Z])" +         //at least 1 upper case letter
                "(?=.*[a-zA-Z])" +      //any letter
                "(?=.*[@#$%^&+=])" +    //at least 1 special character
                "(?=\\S+$)" +           //no white spaces
                ".{4,}" +               //at least 4 characters
                "$";


        if(val.isEmpty()){
            Confirmpassword.setError("Field cannot be Empty");
            return false;
        }
        else if (!val.matches(passwordVal)) {
            Confirmpassword.setError("Password is too weak");
            return false;
        }
        else{
            Confirmpassword.setError(null);
            Confirmpassword.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateSex() {
        String val= Sex.getEditText().getText().toString();
        String noWhiteSpace = "\\A\\w{4,20}\\z";

        if(val.isEmpty()){
            Sex.setError("Field cannot be Empty");
            return false;
        }
        else if(val.length()>=15){
            Sex.setError("Too Long");
            return false;
        }
        else if(!val.matches(noWhiteSpace)){
            Sex.setError("White space not allowed");
            return false;
        }
        else{
            Sex.setError(null);
            Sex.setErrorEnabled(false);
            return true;
        }
    }

    private Boolean validateAge() {
        String val=Age.getEditText().getText().toString();

        if(val.isEmpty()){
            Age.setError("Field cannot be Empty");
            return false;
        }
        else{
            Age.setError(null);
            Age.setErrorEnabled(false);
            return true;
        }
    }


    private void Listners(){

        Loginback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Boolean validateName = validateName();
                Boolean validatePhonenumber= validatePhonenumber();
                Boolean validateEmail = validateEmail();
                Boolean validatePassword = validatePassword();
               // Boolean validateConfirmPassword = validateConfirmPassword();
                Boolean validateSex = validateSex();
                Boolean validateAge = validateAge();


                if( !validateName | !validatePhonenumber | !validateEmail | !validatePassword | !validateSex | !validateAge ){
                    return;
                }


                String username= Username.getEditText().getText().toString();
                String phonenumber= Phonenumber.getEditText().getText().toString();
                String email= Email.getEditText().getText().toString();
                String password= Password.getEditText().getText().toString();
                String sex= Sex.getEditText().getText().toString();
                String age= Age.getEditText().getText().toString();


                rootnode=FirebaseDatabase.getInstance();
                reference= rootnode.getReference("Patients").child("General").child(""+(username));


                UserHelperClass helperClass= new UserHelperClass( username,phonenumber,email,password,sex,age);
                reference.setValue(helperClass);

                Toast.makeText(RegisterActivity.this, "Registered", Toast.LENGTH_SHORT).show();

            }
        });

    }

    private void intia(){
        //Logoimage=findViewById(R.id.LogoImage);
        //Slogan=findViewById(R.id.Slogon);
        Username=findViewById(R.id.username);
        Phonenumber=findViewById(R.id.phonenumber);
        Email=findViewById(R.id.email);
        Password=findViewById(R.id.password);
        Age=findViewById(R.id.age);
        Loginback=findViewById(R.id.Loginback);
        Sex=findViewById(R.id.sex);
        Age=findViewById(R.id.age);
    }



}