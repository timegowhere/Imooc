package com.skybatua.recyclerviewdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class StaggerGridLayoutActivity extends AppCompatActivity {
    private RecyclerView mRecyclerView;
    private List<String> mStringList ;
    private StaggerAdapter mStaggerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
        mStaggerAdapter = new StaggerAdapter(this,mStringList);
        mStaggerAdapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void setOnClickListener(View view, int position) {

            }

            @Override
            public void setOnLongClickListener(View view, int position) {
                mStaggerAdapter.delData(position);

            }
        });
        mRecyclerView.setAdapter(mStaggerAdapter);
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL));




    }

    private void initView() {
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);




    }

    private void initDatas() {
        mStringList = new ArrayList<>();
        for(int i = 'A'; i<='z';i++){
            mStringList.add(""+(char)i);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_ListView:

                break;
            case R.id.menu_GridView:

                break;
            case R.id.menu_HorizontalListView:

                break;
            case R.id.menu_HorizontalGridView:
                break;
            case R.id.menu_staggered:
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
