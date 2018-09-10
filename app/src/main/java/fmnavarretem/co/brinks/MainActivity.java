package fmnavarretem.co.brinks;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import fmnavarretem.co.brinks.View.AppsList.AppsList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Intent appsList = new Intent(this, AppsList.class);
        startActivity(appsList);
        finish();
    }
}
