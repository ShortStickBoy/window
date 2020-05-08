package com.sunzn.window.sample;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.sunzn.window.library.FloatWindow;

public class B_Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);
        setTitle("B");
        FloatWindow.get().show();
    }

    public void change(View view) {
        startActivity(new Intent(this, C_Activity.class));
    }

    public void back(View view) {
        finish();
    }

}
