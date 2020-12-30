package com.example.vacationapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.vacationapp.adapter.RecentsAdapter;
import com.example.vacationapp.adapter.TopPlacesAdapter;
import com.example.vacationapp.model.RecentsData;
import com.example.vacationapp.model.TopPlacesData;
import com.google.firebase.auth.FirebaseAuth;
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
    TextView mFname , mLname ;

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
        mFname = findViewById(R.id.profileLname);
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
        recentsDataList.add(new RecentsData("АРХАНГАЙ АЙМАГ","Тэрхийн цагаан нуур","From$200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("БАЯН-ӨЛГИЙ АЙМАГ","Бага түргэний хүрхрээ","From$300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("БАЯНХОНГОР АЙМАГ","Цагаан агуй","From$200",R.drawable.recentimage1));
        recentsDataList.add(new RecentsData("БУЛГАН АЙМАГ","Уран тогоо уул","From$300",R.drawable.recentimage2));
        recentsDataList.add(new RecentsData("Уран тогоо уул","Сутай хайрхан уул","From$200",R.drawable.recentimage1));

        setRecentRecycler(recentsDataList);



        List<TopPlacesData> topPlacesDataList = new ArrayList<>();
        topPlacesDataList.add(new TopPlacesData("Чингисийн талбай","Сүхбаатар дүүрэг",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Зайсан толгой","Хан-Уул дүүрэг",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Гандантэгчилэн хийд","Чингэлтэй дүүрэг",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Парк","Сүхбаатар дүүрэг",R.drawable.topplaces));
        topPlacesDataList.add(new TopPlacesData("Цэцэрлэгт хүрээлэн","Хан-Уул дүүрэг",R.drawable.topplaces));

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
        startActivity(new Intent(getApplicationContext(),Tours.class));
    }
    public void proScreen(View view){
        startActivity(new Intent(getApplicationContext(),MainActivity.class));
    }


}

