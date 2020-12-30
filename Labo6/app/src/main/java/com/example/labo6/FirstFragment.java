package com.example.labo6;

import android.content.res.Configuration;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class FirstFragment extends Fragment {
    EditText mFname, mLname, mAge, mProfession, mGender;
    Button teacher, student;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_first,container,false);
        mFname = (EditText)rootView.findViewById(R.id.firstName);
        mLname = (EditText)rootView.findViewById(R.id.lastName);
        mAge = (EditText)rootView.findViewById(R.id.age);
        mProfession = (EditText)rootView.findViewById(R.id.profession);
        mGender = (EditText)rootView.findViewById(R.id.gender);
        teacher = (Button)rootView.findViewById(R.id.teacher);
        student = (Button)rootView.findViewById(R.id.student);
        student.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String firstname = mFname.getText().toString();
                String lastname = mLname.getText().toString();
                String age = mAge.getText().toString();
                String gender = mGender.getText().toString();
                String profession = mProfession.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("firstName" , firstname );
                bundle.putString("lastName" , lastname );
                bundle.putString("age" , age );
                bundle.putString("profession" , profession );
                bundle.putString("gender" , gender );
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();


                ThirdFragment thirdFragment = new ThirdFragment();
                thirdFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.framelayout,thirdFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();





            }
        });
        teacher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String firstname = mFname.getText().toString();
                String lastname = mLname.getText().toString();
                String age = mAge.getText().toString();
                String gender = mGender.getText().toString();
                String profession = mProfession.getText().toString();

                Bundle bundle = new Bundle();
                bundle.putString("firstName" , firstname );
                bundle.putString("lastName" , lastname );
                bundle.putString("age" , age );
                bundle.putString("profession" , profession );
                bundle.putString("gender" , gender );
                FragmentManager fragmentManager = getActivity().getSupportFragmentManager();
                FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

                SecondFragment secondFragment = new SecondFragment();
                secondFragment.setArguments(bundle);
                fragmentTransaction.replace(R.id.framelayout,secondFragment);
                fragmentTransaction.addToBackStack(null);
                fragmentTransaction.commit();

            }
        });

        return rootView;
    }
}

/*
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public FirstFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FirstFragment.
     */
 /*   // TODO: Rename and change types and number of parameters
    public static FirstFragment newInstance(String param1, String param2) {
        FirstFragment fragment = new FirstFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/
