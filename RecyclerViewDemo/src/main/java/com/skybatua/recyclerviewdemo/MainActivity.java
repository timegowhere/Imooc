package com.skybatua.recyclerviewdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    private List<String> mStringList ;
    private SimpleAdapter mSimpleAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initDatas();
        mSimpleAdapter = new SimpleAdapter(this,mStringList);
        mRecyclerView.setAdapter(mSimpleAdapter);
//        GridLayoutManager gridLayoutManager = new GridLayoutManager()
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mSimpleAdapter.setOnItemClickListener(new SimpleAdapter.OnItemClickListener() {
            @Override
            public void setOnClickListener(View view, int position) {
                Toast.makeText(MainActivity.this, "click "+position, Toast.LENGTH_SHORT).show();
            }

            @Override
            public void setOnLongClickListener(View view, int position) {
                Toast.makeText(MainActivity.this, "long click "+position, Toast.LENGTH_SHORT).show();

            }
        });
//        mRecyclerView.setItemAnimator(new DefaultItemAnimator());
//        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, com.skybatua.recyclerviewdemo.DividerItemDecoration.VERTICAL_LIST);
////        android.support.v7.widget.DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
//        mRecyclerView.addItemDecoration(dividerItemDecoration);




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
            case R.id.menu_add:
                mSimpleAdapter.addData(2);
                break;
            case R.id.menu_del:
                mSimpleAdapter.delData(2);
                break;
            case R.id.menu_ListView:
                Toast.makeText(this, "menu_ListView", Toast.LENGTH_SHORT).show();
                LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false);
                mRecyclerView.setLayoutManager(linearLayoutManager);
//                DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, com.skybatua.recyclerviewdemo.DividerItemDecoration.VERTICAL_LIST);
////        android.support.v7.widget.DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this,DividerItemDecoration.VERTICAL);
//                mRecyclerView.addItemDecoration(dividerItemDecoration);
                break;
            case R.id.menu_GridView:
                Toast.makeText(this, "menu_GridView", Toast.LENGTH_SHORT).show();
//                GridLayoutManager gridLayoutManager = new GridLayoutManager(MainActivity.this,5,GridLayoutManager.VERTICAL,false);
//                mRecyclerView.setLayoutManager(gridLayoutManager);
//                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.VERTICAL));
                mRecyclerView.setLayoutManager(new GridLayoutManager(this,5));
                break;
            case R.id.menu_HorizontalListView:
                mRecyclerView.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
                break;
            case R.id.menu_HorizontalGridView:
//                mRecyclerView.setLayoutManager(new GridLayoutManager(this,5,GridLayoutManager.HORIZONTAL,false));
                mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(5,StaggeredGridLayoutManager.HORIZONTAL));
                break;
            case R.id.menu_staggered:
                startActivity(new Intent(this,StaggerGridLayoutActivity.class));

                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
