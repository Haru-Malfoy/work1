package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;

public class MainActivity2 extends AppCompatActivity {
//onCreate：第一个被调用的方法，进行activity的初始化
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        Intent intent=getIntent();

        Log.d("life","Activity2 is onCreate...");
    }
    //当activity显示在屏幕上时，该方法被调用
    @Override
    protected void onStart() {
        Log.d("life","Activity2 is Start");
        super.onStart();
    }
    //当activity对用户不可见，被调用进入停止状态
    @Override
    protected void onStop() {
        Log.d("life","Activity2 is Stop");
        super.onStop();

    }
    //当activity被终止前调用
    @Override
    protected void onDestroy() {
        Log.d("life","Activity2 is Destroy");
        super.onDestroy();

    }
}