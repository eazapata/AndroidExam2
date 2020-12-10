package com.example.myapplication;

import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;

import android.view.Menu;
import android.view.MenuItem;
import android.view.animation.Animation;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private ObjectAnimator animator;
    private ObjectAnimator backGroundAnimator;
    private ObjectAnimator backGroundAnimator2;
    private ObjectAnimator backGroundAnimator3;
    private AnimatorSet animatorSet;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

    }


    public void animation(View v){

        int color1 = Color.rgb(65, 156, 197);
        int color2 = Color.rgb(164, 168, 144 );
        int color3 = Color.rgb(222, 165, 51 );
        int color4 = Color.rgb(38, 93, 118);
        int duration = 1500;
        animator = new ObjectAnimator();
        animatorSet = new AnimatorSet();
        ImageView img = findViewById(R.id.imgSun);
        animator = ObjectAnimator.ofFloat(img,"y",1200f);
        animator.setDuration(3000);
        animatorSet.play(animator);
        animatorSet.start();

        AnimatorSet animatorSetBackground = new AnimatorSet();
        backGroundAnimator = new ObjectAnimator();
        backGroundAnimator = ObjectAnimator.ofObject(v, "backgroundColor", new ArgbEvaluator(), color1, color2);
        backGroundAnimator.setDuration(duration);

        backGroundAnimator2 = new ObjectAnimator();
        backGroundAnimator2 = ObjectAnimator.ofObject(v, "backgroundColor", new ArgbEvaluator(), color2, color3);
        backGroundAnimator2.setDuration(duration);

        backGroundAnimator3 = new ObjectAnimator();
        backGroundAnimator3 =  ObjectAnimator.ofObject(v, "backgroundColor", new ArgbEvaluator(), color3, color4);
        backGroundAnimator3.setDuration(duration);
        animatorSetBackground.playSequentially(backGroundAnimator,backGroundAnimator2,backGroundAnimator3);
        animatorSetBackground.start();
    }
    public void changeActivity(View v){
        Intent intent = new Intent (this, SecondActivity.class);
        startActivityForResult(intent, 0);
    }
}