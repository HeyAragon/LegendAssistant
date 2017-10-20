package com.hackhome.legendassistant.ui.adapter;


import android.net.Uri;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.DataBean;
import com.hackhome.legendassistant.bean.TagsBean;

import java.util.List;


/**
 * Created by Administrator on 2017/10/8 0008.
 */
public class RecommendGameListAdapter extends BaseQuickAdapter<TagsBean,BaseViewHolder> {


    public RecommendGameListAdapter(@Nullable List<TagsBean> data) {
        super(R.layout.home_week_game_item_view,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, TagsBean item) {
        SimpleDraweeView icon = helper.getView(R.id.week_game_icon);
        icon.setImageURI(Uri.parse(item.getIcon()));
        helper.setText(R.id.week_game_title, item.getTitle());
        helper.setText(R.id.week_game_count, item.getNum()+"");
        helper.setText(R.id.week_game_intro, item.getIntro());
    }
}
