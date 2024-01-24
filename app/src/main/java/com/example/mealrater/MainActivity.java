package com.example.mealrater;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

public class MainActivity extends AppCompatActivity implements ratePicker.SaveRateListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        intiRateButton();
    }

    private void intiRateButton(){
        Button rateButton = findViewById(R.id.rateButton);
        rateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getSupportFragmentManager();
                ratePicker ratePickerDialog = new ratePicker();
                ratePickerDialog.show(fm, "Rate");
            }
        });
    }
    @Override
    public void didFinishedratePicker(RatingBar ratings) {

    }
}