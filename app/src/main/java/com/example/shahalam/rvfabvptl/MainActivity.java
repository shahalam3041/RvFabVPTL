package com.example.shahalam.rvfabvptl;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {



    EditText title, description;
    FloatingActionButton fab;
    ViewPager mPager;
    TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        fab = findViewById(R.id.fab);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_box,null);

                title = mView.findViewById(R.id.titleDialogBox);
                description = mView.findViewById(R.id.descriptionDialogBox);
                Button btnOK = mView.findViewById(R.id.btnOk);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        FragmentManager fm = getSupportFragmentManager();
                         FragmentTransaction ft = fm.beginTransaction();
                         FragmentOne fragOne = new FragmentOne();
                        Bundle mBundle = new Bundle();

                        mBundle.putString("title", "Hello Title");    ///title.getText().toString())
                        mBundle.putString("description","Hello description"); //description.getText().toString()

                        //PASS OVER THE BUNDLE TO OUR FRAGMENT
                        fragOne.setArguments(mBundle);
                        ft.add(R.id.linearLayoutFragmentOne,fragOne);
                        ft.commit();
                        dialog.cancel();
                    }
                });
            }
        });

        ViewPagerAdapter pagerAdapter = new ViewPagerAdapter(getSupportFragmentManager());
        mPager.setAdapter(pagerAdapter);

        tabLayout.setupWithViewPager(mPager);

    }

}
