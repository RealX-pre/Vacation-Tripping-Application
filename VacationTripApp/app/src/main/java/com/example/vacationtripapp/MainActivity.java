package com.example.vacationtripapp;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.vacationtripapp.adapter.RecentsAdapter;
import com.example.vacationtripapp.adapter.TopPlacesAdapter;
import com.example.vacationtripapp.model.RecentsData;
import com.example.vacationtripapp.model.TopPlacesData;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    RecyclerView recentRecycler;
    RecentsAdapter recentsAdapter;
    TopPlacesAdapter topPlacesAdapter;
    RecyclerView topPlacesRecycler;
    TextView mFname , mLname  ;
    FirebaseAuth fAuth;
    FirebaseFirestore fStore;
    String userID;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fAuth = FirebaseAuth.getInstance();
        fStore= FirebaseFirestore.getInstance();
        userID = fAuth.getCurrentUser().getUid();
        mFname = findViewById(R.id.profileFname);
        mLname= findViewById(R.id.profileLname);

        DocumentReference documentReference = fStore.collection("users").document(userID);
        documentReference.addSnapshotListener(this, new EventListener<DocumentSnapshot>() {
            @Override
            public void onEvent(@Nullable DocumentSnapshot documentSnapshot, @Nullable FirebaseFirestoreException e) {
                mFname.setText(documentSnapshot.getString("fName"));
                mLname.setText(documentSnapshot.getString("lName"));
            }
        });

        List<RecentsData> recentsDataList=new ArrayList<>();
        recentsDataList.add(new RecentsData("АРХАНГАЙ АЙМАГ","Тэрхийн цагаан нуур","520KM",R.drawable.aimag1));
        recentsDataList.add(new RecentsData("БАЯН-ӨЛГИЙ АЙМАГ","Бага түргэний хүрхрээ","1279KM",R.drawable.aimag2));
        recentsDataList.add(new RecentsData("БАЯНХОНГОР АЙМАГ","Цагаан агуй","605KM",R.drawable.aimag3));
        recentsDataList.add(new RecentsData("БУЛГАН АЙМАГ","Уран тогоо уул","318KM",R.drawable.aimag4));
        recentsDataList.add(new RecentsData("Уран тогоо уул","Сутай хайрхан уул","650KM",R.drawable.aimag5));
        setRecentRecycler(recentsDataList);



        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Чингисийн талбай","Сүхбаатар дүүрэг",R.drawable.suhee));
        topPlacesDataList.add(new TopPlacesData("Зайсан толгой","Хан-Уул дүүрэг",R.drawable.hot2));
        topPlacesDataList.add(new TopPlacesData("Гандантэгчилэн хийд","Чингэлтэй дүүрэг",R.drawable.hot3));
        topPlacesDataList.add(new TopPlacesData("Парк","Сүхбаатар дүүрэг",R.drawable.hot4));
        topPlacesDataList.add(new TopPlacesData("Цэцэрлэгт хүрээлэн","Хан-Уул дүүрэг",R.drawable.hot5));
        setTopPlacesRecycler(topPlacesDataList);

    }
    private void setRecentRecycler(List<RecentsData> recentsDataList){
        recentRecycler = findViewById(R.id.recent_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.HORIZONTAL,false);
        recentRecycler.setLayoutManager(layoutManager);
        recentsAdapter = new RecentsAdapter(this,recentsDataList);
        recentRecycler.setAdapter(recentsAdapter);
    }
    private void setTopPlacesRecycler(List<TopPlacesData> topPlacesDataList){
        topPlacesRecycler = findViewById(R.id.top_places_recycler);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this,RecyclerView.VERTICAL,false);
        topPlacesRecycler.setLayoutManager(layoutManager);
        topPlacesAdapter = new TopPlacesAdapter(this,topPlacesDataList);
        topPlacesRecycler.setAdapter(topPlacesAdapter);
    }
    public void homeScreen(View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }
    public void tourScreen(View view){
        startActivity(new Intent(getApplicationContext(),ChooseTour.class));
    }
    public void logout (View view){
        startActivity(new Intent(getApplicationContext(),Login.class));
    }
    public void gmap (View view){
        startActivity(new Intent(getApplicationContext(),FindLocation.class));
    }


}

