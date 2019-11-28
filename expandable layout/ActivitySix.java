package com.example.app14;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

public class ActivitySix extends AppCompatActivity {


    private Context mContext;


    private void expand(ViewGroup layout, ImageView image) {
        if (layout.getVisibility() == View.VISIBLE) {
            layout.setVisibility(View.GONE);
            image.setImageDrawable(getDrawable(R.drawable.plus_icon));
        }
        else {
            layout.setVisibility(View.VISIBLE);
            image.setImageDrawable(getDrawable(R.drawable.minus_icon));
        }
    }//method-expand


    public void imageFirstClick(View v) {
        LinearLayout linear = findViewById(R.id.linear_second);
        ImageView img = findViewById(R.id.image_first);

        expand(linear, img);
    }//method-imageFirstClick


    public void imageSecondClick(View v) {
        ConstraintLayout constraint = findViewById(R.id.constraint_fourth);
        ImageView img = findViewById(R.id.image_second);

        expand(constraint, img);
    }//method-imageSecondClick


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_six);


        mContext = this;
    }//on-create
}//class
