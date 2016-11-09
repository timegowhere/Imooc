package com.skybatua.recyclerviewdemo;

import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by q6593 on 2016/11/8.
 */

public abstract class AbstractViewHolder<T> extends RecyclerView.ViewHolder{
    public AbstractViewHolder(View itemView) {
        super(itemView);
    }
    public void setViewData(T demoModel){

    }
}
