package com.example.animation;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView object;
    Button button1, button2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        object = findViewById(R.id.object);
        button1 = findViewById(R.id.button1);
        button2 = findViewById(R.id.button2);

        // Play Animation 1
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AnimationSet as = new AnimationSet(true);

                // 1-3 seconds the object should rotate counter clockwise 2 times in total, pivot from the center.
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_couter_twice);
                animation1.setStartOffset(1000);


                // 0-5 seconds the object should fade to 50%.
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade_50_5sec);

                // for 6-10 seconds the object should slide down then back to center
                Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down);
                animation3.setStartOffset(6000);

                Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up);
                animation4.setStartOffset(8000);

                as.addAnimation(animation1);
                as.addAnimation(animation2);
                as.addAnimation(animation3);
                as.addAnimation(animation4);


                object.startAnimation(as);
            }
        });

        // Play Animation 2
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                AnimationSet as = new AnimationSet(true);

                // 0-2 seconds the object should grow from the center, doubling in size.
                Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.zoom_anim);

                // for 1-4 seconds the object should rotate 3 times in total, pivot in the bottom left corner.
                Animation animation2 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_from_left);
                animation2.setStartOffset(1000);

                // for 5-6 seconds the object should slide down then back to center
                Animation animation3 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_down_2);
                animation3.setStartOffset(6000);

                Animation animation4 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up_2);
                animation4.setStartOffset(6500);

                // for 6-7 seconds the object should slide left then back to center
                Animation animation5 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_left);
                animation5.setStartOffset(7000);

                Animation animation6 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_right);
                animation6.setStartOffset(7500);


                // for 7-8 seconds the object should slide up then back to center.
                Animation animation7 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide_up_3);

                animation6.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        object.startAnimation(animation7);
                    }
                });

                as.addAnimation(animation1);
                as.addAnimation(animation2);
                as.addAnimation(animation3);
                as.addAnimation(animation4);
                as.addAnimation(animation5);
                as.addAnimation(animation6);

                object.startAnimation(as);
            }
        });
    }
}