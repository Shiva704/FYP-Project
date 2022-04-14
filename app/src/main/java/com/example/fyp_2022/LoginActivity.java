package com.example.fyp_2022;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputLayout;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.textfield.TextInputEditText;

public class LoginActivity extends AppCompatActivity {

//    MaterialButton loginButton;
//    TextInputEditText textInputEditText;
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_login);
//        init();
//        loginButtonListener();
//
//    }
//
//    private void init() {
//        loginButton = findViewById(R.id.loginButton);
//        textInputEditText = findViewById(R.id.email_editTextInput);
//    }
//
//    public void loginButtonListener(){
//        loginButton.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
////                Intent loginToHomeIntent = new Intent(LoginActivity.this, HomeActivity.class);
////                loginToHomeIntent.putExtra("email", ""+(textInputEditText.getText().toString()));
////                startActivity(loginToHomeIntent);
//            }
//        });
//    }
//}

    private static String user_name;
    ImageView declaration;
    TextView Hello, Sign_up;
    TextInputLayout Username, Password;
    Button Login_in , Forgot_password,Store;
    FirebaseDatabase rootnode;
    DatabaseReference reference;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        intia();
        Listeners();
    }

    private Boolean validateName() {
        String val= Username.getEditText().getText().toString();

        if(val.isEmpty()){
            Username.setError("Field cannot be Empty");
            return false;
        }
        else{
            Username.setError(null);
            Username.setErrorEnabled(false);
            return true;
        }
    }
    private Boolean validatePassword(){
        String val=Password.getEditText().getText().toString();


        if(val.isEmpty()){
            Password.setError("Field cannot be Empty");
            return false;
        }
        else{
            Password.setError(null);
            Password.setErrorEnabled(false);
            return true;
        }
    }
    private  void isUser() {
        String UsernameEnteredValue= Username.getEditText().getText().toString().trim();
        String PasswordEnteredValue= Password.getEditText().getText().toString().trim();
        DatabaseReference reference = FirebaseDatabase.getInstance().getReference("Patients").child("General");

        //Toast.makeText(LoginActivity.this, ""+(UsernameEnteredValue), Toast.LENGTH_SHORT).show();

        Query CheckUser = reference.orderByChild("username").equalTo(UsernameEnteredValue);

        CheckUser.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                if(dataSnapshot.exists()){
                    Toast.makeText(LoginActivity.this, "1", Toast.LENGTH_SHORT).show();
                    Username.setError(null);
                    Username.setErrorEnabled(false);

                    String PasswordFromDB = dataSnapshot.child(UsernameEnteredValue).child("password").getValue(String.class);

                    if(PasswordFromDB.equals(PasswordEnteredValue)){
                        Password.setError(null);
                        Password.setErrorEnabled(false);

                        String usernameFromDB = dataSnapshot.child(UsernameEnteredValue).child("username").getValue(String.class);
                        Toast.makeText(LoginActivity.this, ""+(usernameFromDB), Toast.LENGTH_SHORT).show();
                        Intent intent= new Intent(getApplicationContext(),HomeActivity.class);
                        intent.putExtra("username",usernameFromDB);
                        user_name=usernameFromDB;
                        startActivity(intent);

                    }
                    else {
                        Password.setError("wrong password");
                        Password.requestFocus();
                    }
                } else{
                    Username.setError("User not Found");
                    Username.requestFocus();
                }
            }


            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }


    private void Listeners(){

        Sign_up.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });

        Login_in.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Boolean validateName= validateName();
                Boolean validatePassword= validatePassword();

                if(!validateName | !validatePassword){
                    return;
                }
                else{
                    isUser();
                }

            }
        });

//        Store.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Intent intent= new Intent(LoginActivity.this,StoreLogin.class);
//                startActivity(intent);
//            }
//        });
    }
    private void intia(){
       // Logoimage= findViewById(R.id.LogoImage);
        //Hello= findViewById(R.id.Hello);
        declaration= findViewById(R.id.main_logo);
        Username= findViewById(R.id.username);
        Password= findViewById(R.id.password);
        Login_in= findViewById(R.id.Login_in);
        Sign_up= findViewById(R.id.Sign_up);
        //Forgot_password= findViewById(R.id.Forgot_Password);
       // Store=findViewById(R.id.Store);
    }

    public static String getUsername(){
        return user_name;
    }
}
