package com.imooc.skybatua.ripple;

import android.graphics.Outline;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.View;
import android.view.ViewOutlineProvider;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private TextView tv4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        tv4 = (TextView) findViewById(R.id.tv4);
//        CircleOutlineProvider circleOutlineProvider = new CircleOutlineProvider();
//        tv4.setOutlineProvider(circleOutlineProvider);
//        ImageView iv = (ImageView) findViewById(R.id.iv);
//
//        AnimatorSet animatorSet = (AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.property_animator);
//        animatorSet.setTarget(iv);
//        animatorSet.start();

    }
    private class CircleOutlineProvider extends ViewOutlineProvider{

        @Override
        public void getOutline(View view, Outline outline) {
            outline.setOval(0,0,view.getWidth(),view.getHeight());
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        return super.onCreateOptionsMenu(menu);
    }
}
