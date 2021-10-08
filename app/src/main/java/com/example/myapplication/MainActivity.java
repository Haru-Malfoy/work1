package com.example.myapplication;

import androidx.annotation.ColorRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.app.Activity;
import android.app.Fragment;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
//#185.31.16.184 github.global.ssl.fastly.net
public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    private Fragment zhenzhuFragment=new zhenzhuFragment();
    private Fragment naigaiFragment=new naigaiFragment();
    private Fragment budingFragment=new budingFragment();
    private Fragment chadongFragment=new chadongFragment();

    private FragmentManager fragmentManager;
    private LinearLayout mTzhenzhu,mTchadong,mTnaigai,mTbuding;
    private ImageButton mTmgZhenZhu;
    private ImageButton mTmgChaDong;
    private ImageButton mTmgNaiGai;
    private ImageButton mTmgBuDing;

    private TextView text_zhenzhu;
    private TextView text_chadong;
    private TextView text_naigai;
    private TextView text_buding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.lactivity_main);
        mTzhenzhu=(LinearLayout) findViewById(R.id.bottom_zhenzhu_bar);
        mTchadong=(LinearLayout)findViewById(R.id.bottom_chadong_bar);
        mTnaigai=(LinearLayout)findViewById(R.id.bottom_naigai_bar);
        mTbuding=(LinearLayout)findViewById(R.id.bottom_buding_bar);


        mTmgZhenZhu=(ImageButton)findViewById(R.id.bottom_zhenzhu_image);
        mTmgChaDong=(ImageButton)findViewById(R.id.bottom_chadong_image);
        mTmgNaiGai=(ImageButton)findViewById(R.id.bottom_naigai_image);
        mTmgBuDing=(ImageButton)findViewById(R.id.bottom_buding_image);

        text_zhenzhu=findViewById(R.id.bottom_zhenzhu_text);
        text_chadong=findViewById(R.id.bottom_chadong_text);
        text_naigai=findViewById(R.id.bottom_naigai_text);
        text_buding=findViewById(R.id.bottom_buding_text);

        mTzhenzhu.setOnClickListener(this);
        mTbuding.setOnClickListener(this);
        mTnaigai.setOnClickListener(this);
        mTchadong.setOnClickListener(this);


        initFragment();
        showfagment(0);
    }
    private void initFragment(){
        fragmentManager=getFragmentManager();
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        transaction.add(R.id.id_content,budingFragment);
        transaction.add(R.id.id_content,naigaiFragment);
        transaction.add(R.id.id_content,zhenzhuFragment);
        transaction.add(R.id.id_content,chadongFragment);
        transaction.commit();
    }


    private void showfagment(int i){
        FragmentTransaction transaction=fragmentManager.beginTransaction();
        hideFragment(transaction);
        switch (i){
            case 0:
                Log.d("showfagment","1");
                transaction.show(zhenzhuFragment);
                mTmgZhenZhu.setImageResource(R.drawable.zhenzhu);
                text_chadong.setTextColor(Color.parseColor("#FFFFFF"));
                text_naigai.setTextColor(Color.parseColor("#FFFFFF"));
                text_buding.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case 1:
//                Log.d("")
                transaction.show(chadongFragment);
                mTmgChaDong.setImageResource(R.drawable.milktea1);
                text_zhenzhu.setTextColor(Color.parseColor("#FFFFFF"));
                text_naigai.setTextColor(Color.parseColor("#FFFFFF"));
                text_buding.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case 2:
//                Log.d("")
                transaction.show(naigaiFragment);
                mTmgNaiGai.setImageResource(R.drawable.milktea2);
                text_zhenzhu.setTextColor(Color.parseColor("#FFFFFF"));
                text_chadong.setTextColor(Color.parseColor("#FFFFFF"));
                text_buding.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            case 3:
//                Log.d("")
                transaction.show(budingFragment);
                mTmgBuDing.setImageResource(R.drawable.milktea3);
                text_zhenzhu.setTextColor(Color.parseColor("#FFFFFF"));
                text_chadong.setTextColor(Color.parseColor("#FFFFFF"));
                text_naigai.setTextColor(Color.parseColor("#FFFFFF"));
                break;
            default:
                break;

        }
        transaction.commit();
    }
    private void hideFragment(FragmentTransaction transaction){
        transaction.hide(zhenzhuFragment);
        transaction.hide(chadongFragment);
        transaction.hide(naigaiFragment);
        transaction.hide(budingFragment);
    }

    @Override
    public void onClick(View v) {
        Log.d("onClick","2");
        switch (v.getId()){
            case R.id.bottom_zhenzhu_bar:
                text_zhenzhu.setTextColor(Color.parseColor("#BB86FC"));
                showfagment(0);
                break;
            case R.id.bottom_chadong_bar:
                text_chadong.setTextColor(Color.parseColor("#BB86FC"));
                showfagment(1);
                break;
            case R.id.bottom_naigai_bar:
                text_naigai.setTextColor(Color.parseColor("#BB86FC"));
                showfagment(2);
                break;
            case R.id.bottom_buding_bar:
                text_buding.setTextColor(Color.parseColor("#BB86FC"));
                showfagment(3);
                break;
            default:
                break;
        }
    }
}

















//button1=findViewById(R.id.button);
////        textview1=findViewById(R.id.textView4);
////        imageView1=findViewById(R.id.imageView);
////        button1.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View view) {
////                textview1.setText("这是一个按钮的演示");
////                imageView1.setImageDrawable(getDrawable(R.drawable.p1));
////            }
////        });