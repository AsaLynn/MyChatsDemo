package com.zxn.chatsdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/**
 * Created by zxn on 2019-2-15 14:44:12.
 */
public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_main);

        getSupportFragmentManager().beginTransaction()
//                .add(android.R.id.content, new BarChartFragment())
                .add(android.R.id.content, new RoundBarChartFrag())
                .commitAllowingStateLoss();
    }
}
