package com.example.pramod.udacitypracticalquiz;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailsActivity extends AppCompatActivity {

    TextView tvUname, tvEmail, tvDesc;
    private SharedPreferences sharedPreferences;
    private String sharePrefFile = "com.example.pramod.udacitypracticalquiz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);
        ActionBar actionBar=getSupportActionBar();
        if (actionBar!=null){
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        tvUname = (TextView) findViewById(R.id.tv_name);
        tvEmail = (TextView) findViewById(R.id.tv_email);
        tvDesc = (TextView) findViewById(R.id.tv_desc);
        restore();

        if(savedInstanceState!=null){
            tvUname.setText(savedInstanceState.getString("name"));
            tvEmail.setText(savedInstanceState.getString("email"));
            tvDesc.setText(savedInstanceState.getString("desc"));
        }
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString("name",tvUname.getText().toString());
        outState.putString("email",tvEmail.getText().toString());
        outState.putString("desc",tvDesc.getText().toString());

        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        if(savedInstanceState!=null){
            tvUname.setText(savedInstanceState.getString("name"));
            tvEmail.setText(savedInstanceState.getString("email"));
            tvDesc.setText(savedInstanceState.getString("desc"));
        }
        super.onRestoreInstanceState(savedInstanceState);
    }

    private void restore(){
        sharedPreferences = getApplicationContext().getSharedPreferences(sharePrefFile, MODE_PRIVATE);
        if(sharedPreferences!=null){
            tvUname.setText(sharedPreferences.getString("Name",getString(R.string.username)));
            tvEmail.setText(sharedPreferences.getString("Email",getString(R.string.email)));
            tvDesc.setText(sharedPreferences.getString("Desc",getString(R.string.description)));
        }
    }
}

