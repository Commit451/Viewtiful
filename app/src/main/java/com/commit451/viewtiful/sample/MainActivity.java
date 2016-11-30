package com.commit451.viewtiful.sample;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import com.commit451.viewtiful.Viewtiful;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView view = (TextView) findViewById(R.id.text);

        Viewtiful.onPreDraw(view, new Runnable() {
            @Override
            public void run() {
                Log.d("Hello", "The view is about to draw.");
                Toast.makeText(MainActivity.this, "The view is about to draw!!! How exciting", Toast.LENGTH_SHORT).show();
            }
        });

        Viewtiful.onGlobalLayout(view, new Runnable() {
            @Override
            public void run() {
                Log.d("Hello", "The view has been laid out. Also exciting!");
            }
        });
        Toast.makeText(this, "Nav on bottom? " + Viewtiful.isNavigationBarOnBottom(this), Toast.LENGTH_SHORT).show();
    }
}
