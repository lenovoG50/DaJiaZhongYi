package com.lihui.dajiazhongyi;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            if (msg.what == 0) {
                startActivity(new Intent(StartActivity.this, WelCome.class));
                finish();
            } else {
                startActivity(new Intent(StartActivity.this, Home.class));
                finish();
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        SharedPreferences preferences = getSharedPreferences("open", MODE_PRIVATE);

//        if (preferences.getBoolean("first", true)) {
            handler.sendEmptyMessageDelayed(0, 1000);

//        } else {
//            handler.sendEmptyMessageDelayed(1, 1000);
//        }

    }
}
