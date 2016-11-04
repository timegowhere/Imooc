package com.skybatua.recyclerviewdemo;

import android.content.Context;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by q6593 on 2016/10/26.
 */

public class StaggerAdapter extends SimpleAdapter {
//    private LayoutInflater mLayoutInflater;

    private List<Integer> mIntegerList;

    public StaggerAdapter(Context context, List<String> stringList) {
        super(context, stringList);

//        mLayoutInflater = LayoutInflater.from(context);
        mIntegerList = new ArrayList<>();
        for (int i = 0; i < stringList.size(); i++) {

            mIntegerList.add((int) (100 + Math.random() * 300));
        }
    }

//    @Override
//    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
//
//        View view = mLayoutInflater.inflate(R.layout.item_textview,parent,false);
//        VH vh = new VH(view);
//
//        return vh;
//    }
//
//    @Override
//    public int getItemCount() {
//        return mStringList.size();
//    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mIntegerList.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(mStringList.get(position));

    }
//    class VH extends RecyclerView.ViewHolder {
//        TextView tv;
//
//        public VH(View itemView) {
//            super(itemView);
//            tv = (TextView) itemView.findViewById(R.id.tv);
//        }
//    }

}
