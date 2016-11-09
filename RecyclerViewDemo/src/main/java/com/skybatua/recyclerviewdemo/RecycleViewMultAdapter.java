package com.skybatua.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by q6593 on 2016/11/4.
 */

public class RecycleViewMultAdapter extends RecyclerView.Adapter<AbstractViewHolder>{
    private Context mContext;
    private List<DemoModel> mDemoModels = new ArrayList<>();
    private LayoutInflater mLayoutInflater;
    public RecycleViewMultAdapter(Context context){
        mContext =context;

       mLayoutInflater = LayoutInflater.from(mContext);

    }
    public void addDatas(List<DemoModel> demoModels){
        mDemoModels = demoModels;
        notifyDataSetChanged();
    }
    @Override
    public AbstractViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        switch (viewType){
            case DemoModel.TYPE_ONE:
                return new ViewHolderOne(mLayoutInflater.inflate(R.layout.item_one,parent,false));
            case DemoModel.TYPE_TWO:
                return new ViewHolderTwo(mLayoutInflater.inflate(R.layout.item_two,parent,false));

            case DemoModel.TYPE_THREE:
                return new ViewHolderThree(mLayoutInflater.inflate(R.layout.item_three,parent,false));

        }
        return null;
//        View view;

//        if (viewType == 0){
//            view =  mLayoutInflater.inflate(R.layout.item_one,parent,false);
//        }else {
//            view = mLayoutInflater.inflate(R.layout.item_textview_content,parent,false);
//        }
//        VH vh = new VH(view);
//        return vh;
    }

    @Override
    public void onBindViewHolder(AbstractViewHolder holder, int position) {
        holder.setViewData(mDemoModels.get(position));
    }

    @Override
    public int getItemCount() {
        return mDemoModels.size();
    }



    @Override
    public int getItemViewType(int position) {
        return (int) (Math.random()*3+1);
//        if (position%2==0){
//            return 0;
//        }else {
//            return 1;
//        }
//        return super.getItemViewType(position);
    }

    class VH extends RecyclerView.ViewHolder{

        public VH(View itemView) {
            super(itemView);
        }
    }
}
