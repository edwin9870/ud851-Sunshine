package com.example.android.sunshine;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class DetailActivity extends AppCompatActivity {

    private static final String FORECAST_SHARE_HASHTAG = " #SunshineApp";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        TextView dataTextView = (TextView) findViewById(R.id.tv_data);

        // TODO (2) Display the weather forecast that was passed from MainActivity
        Intent parentIntent = getIntent();
        String dataReceived = parentIntent.getStringExtra(Intent.EXTRA_TEXT);
        Log.d(DetailActivity.class.getSimpleName(), "Data received: "+ dataReceived);

        dataTextView.setText(dataReceived);

    }
}