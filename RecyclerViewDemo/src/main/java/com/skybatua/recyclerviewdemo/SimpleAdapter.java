package com.skybatua.recyclerviewdemo;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

/**
 * Created by q6593 on 2016/10/26.
 */

public class SimpleAdapter extends RecyclerView.Adapter<SimpleAdapter.VH>{
    protected LayoutInflater mLayoutInflater;
    protected Context mContext;
    protected List<String> mStringList;
    protected OnItemClickListener mOnItemClickListener;
    interface OnItemClickListener{
        void setOnClickListener(View view,int position);
        void setOnLongClickListener(View view,int position);
    }
    public void setOnItemClickListener(OnItemClickListener onItemClickListener){
        mOnItemClickListener = onItemClickListener;
    }
    public SimpleAdapter(Context context, List<String> stringList) {
        this.mContext = context;
        this.mStringList = stringList;
        mLayoutInflater = LayoutInflater.from(context);

    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mLayoutInflater.inflate(R.layout.item_textview,parent,false);
        VH vh = new VH(view);

        return vh;
    }

    @Override
    public int getItemCount() {
        return mStringList.size();
    }

    @Override
    public void onBindViewHolder(final VH holder, final int position) {

        holder.tv.setText(mStringList.get(position));

//        if (mOnItemClickListener!=null) {
//            holder.itemView.setOnClickListener(new View.OnClickListener() {
//                @Override
//                public void onClick(View view) {
//                    mOnItemClickListener.setOnClickListener(view, holder.getAdapterPosition());
//                }
//            });
//            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
//                @Override
//                public boolean onLongClick(View view) {
//                    mOnItemClickListener.setOnLongClickListener(view,holder.getAdapterPosition());
//                    return true;
//                }
//            });
//        }

    }

    public void addData(int position){
        mStringList.add(position,"new "+position);

        notifyItemInserted(position);
    }
    public void delData(int position){
        mStringList.remove(position);
        notifyItemRemoved(position);
    }
    class VH extends RecyclerView.ViewHolder {
        TextView tv;

        public VH(View itemView) {
            super(itemView);
            tv = (TextView) itemView.findViewById(R.id.tv);
            if (mOnItemClickListener!=null){
                itemView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
//                    Toast.makeText(mContext, "onClick"+getAdapterPosition(), Toast.LENGTH_SHORT).show();
                        mOnItemClickListener.setOnClickListener(view,getAdapterPosition());
                    }
                });
                itemView.setOnLongClickListener(new View.OnLongClickListener() {
                    @Override
                    public boolean onLongClick(View view) {
                        mOnItemClickListener.setOnLongClickListener(view,getAdapterPosition());
                        return true;
                    }
                });
            }

//            if (mOnItemClickListener!=null){
//                tv.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        mOnItemClickListener.setOnClickListener(view,getAdapterPosition());
//                    }
//                });
//                tv.setOnLongClickListener(new View.OnLongClickListener() {
//                    @Override
//                    public boolean onLongClick(View view) {
//                        mOnItemClickListener.setOnLongClickListener(view,getAdapterPosition());
//                        return true;
//                    }
//                });
//            }

        }
    }

}
