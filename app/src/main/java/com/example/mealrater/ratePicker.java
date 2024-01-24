package com.example.mealrater;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RatingBar;
import androidx.fragment.app.DialogFragment;

public class ratePicker extends DialogFragment {
    //declare the rate
    RatingBar selectedRate;
    //
    public interface SaveRateListener {
        void didFinishedratePicker(RatingBar ratings);
    }
        //empty constructor
        public ratePicker(){

        }
        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle saveInstanceSate){
            final View view = inflater.inflate(R.layout.rate_layout, container);

            getDialog().setTitle("Rate");
            //A listener that captures the change of the rating
            final RatingBar rv = view.findViewById(R.id.ratingBar);
            //create the listener
            rv.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
                @Override
                public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                    selectedRate.setRating(rating);//set the new rating
                }
            });
            Button saveButton = view.findViewById(R.id.rateButton);
            saveButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    saveItem(selectedRate);
                }
            });
            return view;
        }
        private void saveItem(RatingBar rating){
        SaveRateListener activity = (SaveRateListener) getActivity();
        activity.didFinishedratePicker(rating);
        getDialog().dismiss();
        }

}

