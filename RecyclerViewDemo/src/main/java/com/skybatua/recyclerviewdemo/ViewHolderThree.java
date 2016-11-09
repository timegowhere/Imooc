package com.skybatua.recyclerviewdemo;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.skybatua.recyclerviewdemo.model.DemoModelThree;

/**
 * Created by q6593 on 2016/11/8.
 */

public class ViewHolderThree extends AbstractViewHolder<DemoModelThree> {
    private ImageView iv_avatar;
    private TextView tv_name;
    private TextView tv_content;
    private ImageView iv_contentColor;

    public ViewHolderThree(View itemView) {
        super(itemView);
        iv_avatar = (ImageView) itemView.findViewById(R.id.iv_avatar);
        tv_name = (TextView) itemView.findViewById(R.id.tv_name);
        tv_content = (TextView) itemView.findViewById(R.id.tv_content);
        iv_contentColor = (ImageView) itemView.findViewById(R.id.iv_contentColor);
    }

    @Override
    public void setViewData(DemoModelThree demoModel) {
        super.setViewData(demoModel);
        iv_avatar.setImageResource(demoModel.avatarColor);
        tv_name.setText(demoModel.name);
        tv_content.setText(demoModel.content);
        iv_contentColor.setImageResource(demoModel.contentColor);
    }
}
