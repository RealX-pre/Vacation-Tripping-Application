package com.example.labo6;

import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

public class ThirdFragment extends Fragment {
    TextView mFname, mLname, mAge, mProfession, mGender;
    EditText mUniversity, mClass, mCourse, mGPA;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment_third, container, false);


        Bundle bundle = getArguments();
        String firstName = bundle.getString("firstName");
        String lastName = bundle.getString("lastName");
        String age = bundle.getString("age");
        String profession = bundle.getString("profession");
        String gender = bundle.getString("gender");
        mFname = (TextView) rootView.findViewById(R.id.firstName);
        mLname = (TextView) rootView.findViewById(R.id.lastName);
        mAge = (TextView) rootView.findViewById(R.id.age);
        mProfession = (TextView) rootView.findViewById(R.id.profession);
        mGender = (TextView) rootView.findViewById(R.id.gender);
        mClass = (EditText) rootView.findViewById(R.id.cla);
        mCourse = (EditText) rootView.findViewById(R.id.course);
        mUniversity = (EditText) rootView.findViewById(R.id.university);
        mGPA = (EditText) rootView.findViewById(R.id.gpa);
        mFname.setText(firstName);
        mLname.setText(lastName);
        mAge.setText(age);
        mProfession.setText(profession);
        mGender.setText(gender);

        return rootView;
    }
}




/*   /**
 * Use this factory method to create a new instance of
 * this fragment using the provided parameters.
 *
 * @param param1 Parameter 1.
 * @param param2 Parameter 2.
 * @return A new instance of fragment SecondFragment.
 */
// TODO: Rename and change types and number of parameters
  /*  public static SecondFragment newInstance(String param1, String param2) {
        SecondFragment fragment = new SecondFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }*/
/*
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }
*/
