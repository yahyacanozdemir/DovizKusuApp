package com.example.dovizkusu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import com.airbnb.lottie.LottieAnimationView;

public class splashScreen extends AppCompatActivity {
    ImageView title ;
    LottieAnimationView money ;
    ImageView bird;

    SharedPreferences isFirstTime ;
    Boolean isFirst=true;

    Animation fromBottom,fromSide,fromUp ;
    int gosterim_suresi;
    int x = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bird = (ImageView) findViewById(R.id.birds);
        money = (LottieAnimationView) findViewById (R.id.coinfall);
        title = (ImageView) findViewById(R.id.baslik);
        isFirstTime =this.getSharedPreferences("com.example.dovizkusu", Context.MODE_PRIVATE);

        isFirst =isFirstTime.getBoolean("valueOfFirst",true);
        isFirstTime.edit().putBoolean("valueOfFirst",false).apply();


        if(isFirst){
            gosterim_suresi = 2000;
            fromBottom = AnimationUtils.loadAnimation(this,R.anim.frombottom) ;
            money.setAnimation(fromBottom);

            fromSide = AnimationUtils.loadAnimation(this,R.anim.fromright);
            title.setAnimation(fromSide);

            fromUp = AnimationUtils.loadAnimation(this,R.anim.fromtop);
            bird.setAnimation(fromUp);
        }
        else
            gosterim_suresi=10;

            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }, gosterim_suresi);
    }

}
