package com.skybatua.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.skybatua.recyclerviewdemo.model.DemoModel;
import com.skybatua.recyclerviewdemo.model.DemoModelOne;
import com.skybatua.recyclerviewdemo.model.DemoModelThree;
import com.skybatua.recyclerviewdemo.model.DemoModelTwo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by q6593 on 2016/11/4.
 */

public class RecycleViewMultAdapter extends RecyclerView.Adapter<AbstractViewHolder>{
    private Context mContext;
    private List<DemoModel> mDemoModels = new ArrayList<>();
    private List<DemoModelOne> mDemoModelOnes = new ArrayList<>();
    private List<DemoModelTwo> mDemoModelTwos = new ArrayList<>();
    private List<DemoModelThree> mDemoModelThrees = new ArrayList<>();

    private List<Integer> typeList = new ArrayList<>();
    private Map<Integer,Integer> mPositionMap = new HashMap<>();
    private LayoutInflater mLayoutInflater;
    public RecycleViewMultAdapter(Context context){
        mContext =context;

       mLayoutInflater = LayoutInflater.from(mContext);

    }
//    public void addDatas(List<DemoModel> demoModels){
//        mDemoModels = demoModels;
//        notifyDataSetChanged();
//    }
    public void addDatas(List list1,List list2,List list3){
        addListByType(DemoModel.TYPE_ONE,list1);
        addListByType(DemoModel.TYPE_TWO,list2);
        addListByType(DemoModel.TYPE_THREE,list3);
        mDemoModelOnes = list1;
        mDemoModelTwos = list2;
        mDemoModelThrees = list3;
        notifyDataSetChanged();
    }
    public void addListByType(int type,List list){
        mPositionMap.put(type,typeList.size());
        for (int i=0;i<list.size();i++){
            typeList.add(type);
        }

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
//        holder.setViewData(mDemoModels.get(position));
        int viewType = getItemViewType(position);
        int realPosition = position - mPositionMap.get(viewType);

        switch (viewType){
            case DemoModel.TYPE_ONE:
                 holder.setViewData(mDemoModelOnes.get(realPosition));
                break;
            case DemoModel.TYPE_TWO:
                holder.setViewData(mDemoModelTwos.get(realPosition));
                break;
            case DemoModel.TYPE_THREE:
                holder.setViewData(mDemoModelThrees.get(realPosition));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return typeList.size();
    }



    @Override
    public int getItemViewType(int position) {
        return  typeList.get(position);
//        return (int) (Math.random()*3+1);
//        return mDemoModels.get(position).type;

//        return super.getItemViewType(position);
    }


}
