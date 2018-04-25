package com.example.pramod.udacitypracticalquiz;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    EditText uet,eet,det;
    private SharedPreferences sharedPreferences;
    private String sharePrefFile = "com.example.pramod.udacitypracticalquiz";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        uet = (EditText) findViewById(R.id.et_username);
        eet = (EditText) findViewById(R.id.et_email);
        det = (EditText) findViewById(R.id.et_desc);

        if(savedInstanceState!=null){
            uet.setText(savedInstanceState.getString("ma_uname"));
            eet.setText(savedInstanceState.getString("ma_email"));
            det.setText(savedInstanceState.getString("ma_desc"));

        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if(item.getItemId()==R.id.profile) {
                startActivity(new Intent(this, DetailsActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putString("ma_uname",uet.getText().toString().trim());
        outState.putString("ma_email",eet.getText().toString().trim());
        outState.putString("ma_desc",det.getText().toString().trim());
        super.onSaveInstanceState(outState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        if(savedInstanceState!=null){
            uet.setText(savedInstanceState.getString("ma_uname"));
            eet.setText(savedInstanceState.getString("ma_email"));
            det.setText(savedInstanceState.getString("ma_desc"));

        }
    }

    public void next(View view){

        sharedPreferences = getApplicationContext().getSharedPreferences(sharePrefFile,MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("Name",uet.getText().toString().trim());

        editor.putString("Email",eet.getText().toString().trim());

        editor.putString("Desc",det.getText().toString().trim());

        editor.apply();

        startActivity(new Intent(this, DetailsActivity.class));

    }
}
