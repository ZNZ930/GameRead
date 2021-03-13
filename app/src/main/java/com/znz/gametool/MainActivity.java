package com.znz.gametool;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.znz.gametool.Activity.LiftMapActivity;
import com.znz.gametool.ViewGroup.GameButton;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Context mContext = MainActivity.this;
    private GameButton life_map;
    private GameButton yingdi;
    private GameButton fbjs;
    private GameButton scgl;
    private GameButton about;
    //Intent
    private Intent MapIntent;
    private Intent YingDiIntent;
    private Intent FuBenIntent;
    private Intent LiveGoLueIntent;
    private Intent AboutIntent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    private void initView() {

        life_map = (GameButton) findViewById(R.id.life_map);
        life_map.setOnClickListener(this);
        yingdi = (GameButton) findViewById(R.id.yingdi);
        yingdi.setOnClickListener(this);
        fbjs = (GameButton) findViewById(R.id.fbjs);
        fbjs.setOnClickListener(this);
        scgl = (GameButton) findViewById(R.id.scgl);
        scgl.setOnClickListener(this);
        about = (GameButton) findViewById(R.id.about);
        about.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.life_map:
                StartIntent(MapIntent, LiftMapActivity.class);
                break;
            case R.id.yingdi:

                break;
            case R.id.fbjs:

                break;
            case R.id.scgl:

                break;
            case R.id.about:

                break;
        }
    }

    //启动Activity
    private  void StartIntent(Intent intent,Class intentClass)
    {
        intent = new Intent();
        intent.setClass(MainActivity.this,intentClass);
        startActivity(intent);
    }
}
