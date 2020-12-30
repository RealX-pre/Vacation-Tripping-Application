package com.example.vacationapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;

import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;


public class Profile extends AppCompatActivity {
    TextView mFname , mLname , mPhone , mEmail ;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;
    Button changeProfileButton;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        mFname = findViewById(R.id.profileFname);
        mLname = findViewById(R.id.profileLname);
        mEmail = findViewById(R.id.profileEmail);
        mPhone = findViewById(R.id.profilePhone);
        changeProfileButton = findViewById(R.id.changeproButton);

        userID = fAuth.getCurrentUser().getUid();
        fAuth = FirebaseAuth.getInstance();
        fStore = FirebaseFirestore.getInstance();
        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mFname.setText(documentSnapshot.getString("fName"));
                mLname.setText(documentSnapshot.getString("lName"));
                mEmail.setText(documentSnapshot.getString("email"));
                mPhone.setText(documentSnapshot.getString("phone"));
            }
        });


    }
    public void back(View view){
        startActivity(new Intent(getApplicationContext(), MainActivity.class));
    }
    public void logout(View view){
        startActivity(new Intent(getApplicationContext(), Login.class));
    }


}