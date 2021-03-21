package com.example.movies_efrei;

import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragmentC#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentC extends Fragment {

    public FragmentC() {
        // Required empty public constructor
    }

    public static FragmentC newInstance(String param1, String param2) {
        FragmentC fragment = new FragmentC();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }
    Button getStarted;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_c, container, false);

        Button getStarted = view.findViewById(R.id.buttonGetStarted);
        getStarted.setOnClickListener(v -> {
            Log.i("MyActivity", "buttonPressed");
            MainActivity.start= true;
            Intent intent = new Intent(getActivity(), MainActivity.class);
            startActivity(intent);
        });
        // Inflate the layout for this fragment
        return view;
    }
}