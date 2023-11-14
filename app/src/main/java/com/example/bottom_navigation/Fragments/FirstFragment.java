package com.example.bottom_navigation.Fragments;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bottom_navigation.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;


public class FirstFragment extends Fragment {
    private NavController navController;
    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_first, container, false);
        view.findViewById(R.id.btnSend).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendDataToOne(view);
            }
        });

        view.findViewById(R.id.btnGoToThree).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Navigation.findNavController(view).navigate(FirstFragmentDirections.actionFirstFragmentToThirdFragment());
            }
        });
        return view;
    }

    private void sendDataToOne(View v) {
        int value = 22;
        FirstFragmentDirections.ActionFirstFragmentToSecondFragment action =
                FirstFragmentDirections.actionFirstFragmentToSecondFragment().setNumber(22);
        Navigation.findNavController(v).navigate(action);
    }
}
