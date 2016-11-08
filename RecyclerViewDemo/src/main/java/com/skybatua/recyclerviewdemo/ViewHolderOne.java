package com.skybatua.recyclerviewdemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by q6593 on 2016/11/8.
 */

public class ViewHolderOne extends AbstractViewHolder{
    private ImageView iv_avatar;
    private TextView tv_name;

    public ViewHolderOne(View itemView) {
        super(itemView);
        iv_avatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
    }

    @Override
    public void setViewData(DemoModel demoModel) {
        super.setViewData(demoModel);
        iv_avatar.setImageResource(demoModel.avatarColor);
        tv_name.setText(demoModel.name);
    }

}
