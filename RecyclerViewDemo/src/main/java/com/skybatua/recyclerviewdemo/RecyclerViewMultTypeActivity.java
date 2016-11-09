package com.skybatua.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewMultTypeActivity extends AppCompatActivity {
    private static final String TAG = "RecyclerViewMultTypeAct";
    private RecyclerView mRecyclerView;
    private RecycleViewMultAdapter mRecycleViewMultAdapter;
    private int[] mColors = {
            android.R.color.holo_red_light,
            android.R.color.holo_green_light,
            android.R.color.holo_blue_light,
            android.R.color.holo_orange_light
    };
    private List<DemoModel> mDemoModels = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view_mult_type);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mRecyclerView.setLayoutManager(gridLayoutManager);
        mRecycleViewMultAdapter = new RecycleViewMultAdapter(this);
        mRecyclerView.setAdapter(mRecycleViewMultAdapter);
        initData();

    }

    private void initData() {
        for (int i = 0; i < 20; i++) {
            DemoModel demoModel = new DemoModel();
            demoModel.type = (int) (Math.random()*3+1);
            demoModel.avatarColor = mColors[i%4];
            demoModel.name = "name "+i;
            demoModel.content = "content "+i;
            demoModel.contentColor = mColors[(int) (Math.random()*4)];
//            demoModel.setType ((int) (Math.random()*3+1));
//            demoModel.setAvatarColor(mColors[20%3]);
//            demoModel.setName("name "+i);
//            demoModel.setContent("content "+i);
//            demoModel.setContentColor(mColors[(int) (Math.random()*3)]);
            mDemoModels.add(demoModel);

        }
        mRecycleViewMultAdapter.addDatas(mDemoModels);
        Log.i(TAG, "initData: demoModel.toString()="+mDemoModels.toString());
    }
}
