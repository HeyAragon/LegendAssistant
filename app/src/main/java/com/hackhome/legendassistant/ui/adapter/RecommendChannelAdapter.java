package com.hackhome.legendassistant.ui.adapter;


import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.NavBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/8 0008.
 */
public class RecommendChannelAdapter extends BaseQuickAdapter<NavBean,BaseViewHolder>{


    public RecommendChannelAdapter(@Nullable List<NavBean> data) {
        super(R.layout.home_channel_item_view, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, NavBean item) {
        SimpleDraweeView simpleDraweeView = helper.getView(R.id.channel_icon);
        simpleDraweeView.setImageURI(item.getIcon());
        helper.setText(R.id.channel_title, item.getTitle());
    }
}
