package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;

import androidx.fragment.app.DialogFragment;

public class ratePicker extends DialogFragment {

    RatingBar selectRate;

    public interface OnRatingBarListerner {
        void didFinishedRateDialog(RatingBar selectedRate);
    }

    public ratePicker(){

    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedIntanceState) {

        final View view = inflater.inflate(R.layout.rate_layout, container);
        getDialog().setTitle("Rate");
        //this initializes the rating bar...
        selectRate = view.findViewById(R.id.ratingBar);

        Button saveButton = view.findViewById(R.id.rateButton);
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveItem(selectRate);
            }
        });
        return view;
    }
    private void saveItem(RatingBar selectedRate) {
         OnRatingBarListerner activity = (OnRatingBarListerner) getActivity();
         activity.didFinishedRateDialog(selectedRate);
         getDialog().dismiss();
    }
}

