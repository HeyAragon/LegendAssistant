package com.hackhome.legendassistant.ui.adapter;


import android.net.Uri;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.DataBean;

import java.util.List;


/**
 * Created by Administrator on 2017/10/8 0008.
 */
public class RecommendHorizontalAdapter extends BaseQuickAdapter<DataBean.RecommendListBean,BaseViewHolder> {


    public RecommendHorizontalAdapter(@Nullable List<DataBean.RecommendListBean> data) {
        super(R.layout.home_horizontal_item_view,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataBean.RecommendListBean item) {
        SimpleDraweeView icon = helper.getView(R.id.horizontal_game_icon);
        icon.setImageURI(Uri.parse(item.getIcon()));
        helper.setText(R.id.horizontal_game_title, item.getTitle());
    }

}
