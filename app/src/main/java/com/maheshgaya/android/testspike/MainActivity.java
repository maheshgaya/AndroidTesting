package com.maheshgaya.android.testspike;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView titleTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        titleTextView = findViewById(R.id.text_box);
        setTitleInTextView("ToDo List");
    }

    public void setTitleInTextView(String title) {
        titleTextView.setText(title);
    }
}
