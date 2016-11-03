package com.imooc.skybatua;

import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        
        Toolbar tb = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(tb);
        DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this,drawerLayout,tb,R.string.navigation_drawer_open,R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();
    }

    @Override
    protected void onStart() {
        super.onStart();
//        Rect rect = new Rect();
//        getWindow().getDecorView().getWindowVisibleDisplayFrame(rect);
//        int statusBarHeight = rect.top;
//        Log.i(TAG, "onCreate: statusBarHeight="+statusBarHeight);


//        Resources resources = this.getResources();
//        int resourceId = resources.getIdentifier("status_bar_height","dimen","android");
//        int height = resources.getDimensionPixelSize(resourceId);
//        Log.i(TAG, "onCreate: statusBarHeight="+height);
    }
}
