package com.ahmed.fragment2;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button button1;
    Button button2;
    Button button3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Fragment1 fragment1 = new Fragment1();
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                transaction.add(R.id.linear2,fragment1,"fragment1");
                transaction.commit();

            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment1 fa = (Fragment1) manager.findFragmentByTag("fragment1");
                if(fa != null){
                    transaction.remove(fa);
                    transaction.commit();
                }else {
                    Toast.makeText(MainActivity.this,"Please add fragment first",Toast.LENGTH_SHORT).show();
                }

            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager manager = getSupportFragmentManager();
                FragmentTransaction transaction = manager.beginTransaction();
                Fragment2 fragment2 = new Fragment2();
                Fragment1 fa = (Fragment1) manager.findFragmentByTag("fragment1");
                if(fa != null){
                    transaction.replace(R.id.linear2,fragment2);
                    transaction.commit();
                }else {
                    Toast.makeText(MainActivity.this,"Please add fragment first",Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
