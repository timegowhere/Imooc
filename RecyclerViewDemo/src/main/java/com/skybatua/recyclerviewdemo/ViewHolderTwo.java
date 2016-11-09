package com.skybatua.recyclerviewdemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skybatua.recyclerviewdemo.model.DemoModelTwo;

/**
 * Created by q6593 on 2016/11/8.
 */

public class ViewHolderTwo extends AbstractViewHolder<DemoModelTwo> {
    private ImageView iv_avatar;
    private TextView tv_name;
    private TextView tv_content;

    public ViewHolderTwo(View itemView) {
        super(itemView);
        iv_avatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
    }

    @Override
    public void setViewData(DemoModelTwo demoModel) {
        super.setViewData(demoModel);
        iv_avatar.setImageResource(demoModel.avatarColor);
        tv_name.setText(demoModel.name);
        tv_content.setText(demoModel.content);
    }
}
