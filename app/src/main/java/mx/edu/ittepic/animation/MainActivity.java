package mx.edu.ittepic.animation;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewPropertyAnimator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.CycleInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.widget.ImageView;
import android.widget.RelativeLayout;

public class MainActivity extends AppCompatActivity {

    private ImageView imageView;
    private RelativeLayout canvas;
    int pos=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.faceIcon);
        canvas = (RelativeLayout) findViewById(R.id.animationCanvas);
    }

    public void onButtonClick(View v) {

        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        if(pos==0){
            ObjectAnimator animator = ObjectAnimator.ofFloat(
                    imageView, "y", 0, targetY)
                    .setDuration(1000);
            animator.setInterpolator(new BounceInterpolator());
            animator.start();
            pos=1;
        }else{
            ObjectAnimator animator = ObjectAnimator.ofFloat(
                    imageView, "y", screenHeight, 0)
                    .setDuration(1000);
            animator.setInterpolator(new BounceInterpolator());
            animator.start();
            pos=0;
        }

    }

    public void Acelerar(View v) {
        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", 0, targetY)
                .setDuration(5000);

        animator.setInterpolator(new DecelerateInterpolator());
        animator.start();

    }
    public void DesAcelerar(View v) {
        int screenHeight = canvas.getHeight();
        int targetY = screenHeight - imageView.getHeight();
        ObjectAnimator animator = ObjectAnimator.ofFloat(
                imageView, "y", screenHeight, 0)
                .setDuration(5000);

        animator.setInterpolator(new AccelerateInterpolator());
        animator.start();

    }



    public void ciclos(View v) {

        CycleInterpolator ci = new CycleInterpolator(5f);
        ViewPropertyAnimator anim = imageView.animate();
        anim.alpha(0);
        anim.setDuration(10000);
        anim.setInterpolator(ci);


    }
}
