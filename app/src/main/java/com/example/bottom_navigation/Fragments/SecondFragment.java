package com.example.bottom_navigation.Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.bottom_navigation.R;


public class SecondFragment extends Fragment {
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_second, container, false);
        assert getArguments() != null;
        int Num=SecondFragmentArgs.fromBundle(getArguments()).getNumber();
        Toast.makeText(requireContext(), "Hello : "+Num, Toast.LENGTH_SHORT).show();
        return view;
    }
}