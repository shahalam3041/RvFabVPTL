package com.example.shahalam.rvfabvptl;

import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {


    EditText title, description;
    FloatingActionButton fab;
    ViewPager mPager;
    TabLayout tabLayout;
    ViewPagerAdapter adapter;
    FragmentCommunicator fragmentCommunicator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mPager = findViewById(R.id.viewPager);
        tabLayout = findViewById(R.id.tabLayout);
        fab = findViewById(R.id.fab);

        adapter = new ViewPagerAdapter(getSupportFragmentManager());


        setupViewPager(mPager);
        tabLayout.setupWithViewPager(mPager);


        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AlertDialog.Builder mBuilder = new AlertDialog.Builder(MainActivity.this);
                View mView = getLayoutInflater().inflate(R.layout.dialog_box, null);

                title = mView.findViewById(R.id.titleDialogBox);
                description = mView.findViewById(R.id.descriptionDialogBox);
                Button btnOK = mView.findViewById(R.id.btnOk);

                mBuilder.setView(mView);
                final AlertDialog dialog = mBuilder.create();
                dialog.show();
                btnOK.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String titleValue = title.getText().toString();
                        String descriptionValue = description.getText().toString();
                        Log.d("DATA", "=====" + titleValue + descriptionValue);
                        List<MyDataModel> myDataModels = new ArrayList<>();
                        MyDataModel model = new MyDataModel(titleValue, descriptionValue);
                        myDataModels.add(model);

                        fragmentCommunicator.sendData(myDataModels);
                        dialog.cancel();
                    }
                });
            }
        });

    }


    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new FragmentOne(), "First Fragment");
        adapter.addFrag(new FragmentTwo(), "Second Fragment");
        viewPager.setAdapter(adapter);
    }

    //Here is new method
    public void passVal(FragmentCommunicator fragmentCommunicator) {
        this.fragmentCommunicator = fragmentCommunicator;

    }

}
