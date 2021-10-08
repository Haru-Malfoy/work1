package com.example.myapplication;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import android.app.Fragment;

public class naigaiFragment extends Fragment {
    public naigaiFragment(){

    }
    @Override
    public View onCreateView( LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {

//        return super.onCreateView(inflater, container, savedInstanceState);
        return inflater.inflate(R.layout.naigai_fragment_wechat,container,false);
    }
}
