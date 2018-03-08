package com.jstrait.slideshow;

import android.content.Intent;
import android.media.Image;
import android.support.v4.view.MotionEventCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    protected int[] images = {R.drawable.pupper,R.drawable.pupper2,R.drawable.pupper3};
    protected ImageView theImage;
    protected int num = 0;
    protected double xaxis = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        theImage = (ImageView)findViewById(R.id.image);

    }

    public void leftClicked(View view){
       leftSwipe();

    }

    private void leftSwipe(){
        num--;
        if(num < 0){
            num = images.length-1;
        }
        theImage.setImageResource(images[num]);
    }

    public void rightClicked(View view){
       rightSwipe();

    }
    private void rightSwipe(){
        num++;
        if(num >= images.length){
            num = 0;
        }
        theImage.setImageResource(images[num]);
    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        int action = MotionEventCompat.getActionMasked(event);
        switch (action) {
            case (MotionEvent.ACTION_DOWN) :
                xaxis = event.getRawX();

                return true;

            case (MotionEvent.ACTION_UP) :

                if(xaxis < event.getRawX()){
                    //Log.d("Josh", "Right" );
                    leftSwipe();
                }else{
                    //Log.d("Josh", "Left" );
                    rightSwipe();

                }

                return true;

            default :
                return super.onTouchEvent(event);
        }
    }

    public void bye(View view){
        Intent intent = new Intent(this, MoreFun.class);
        startActivity(intent);
    }
}
