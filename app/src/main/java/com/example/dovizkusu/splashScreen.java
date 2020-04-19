package com.example.dovizkusu;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.airbnb.lottie.LottieAnimationView;

public class splashScreen extends AppCompatActivity {
    ImageView title ;
    LottieAnimationView bird,money ;

    Animation fromBottom,fromSide,fromUp ;
    int gosterim_suresi = 3000;
    int x = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);

        bird = (LottieAnimationView) findViewById(R.id.coinfall);
        money = (LottieAnimationView) findViewById (R.id.birds);
        title = (ImageView) findViewById(R.id.baslik);

        fromBottom = AnimationUtils.loadAnimation(this,R.anim.frombottom) ;
        bird.setAnimation(fromBottom);

        fromSide = AnimationUtils.loadAnimation(this,R.anim.fromright);
        title.setAnimation(fromSide);

        fromUp = AnimationUtils.loadAnimation(this,R.anim.fromtop);
        money.setAnimation(fromUp);


            new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    Intent i = new Intent(getApplicationContext(), MainActivity.class);
                    startActivity(i);
                    finish();
                }
            }, gosterim_suresi);
    }
   /* public void screenTapped(View view) {
        Intent i = new Intent(getApplicationContext(), MainActivity.class);
        startActivity(i);
    }*/

}
