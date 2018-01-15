package com.hackhome.legendassistant.ui.adapter;


import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Build;
import android.support.annotation.Nullable;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.DataBean;

import java.util.List;


/**
 * 首页横向游戏列表
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
        if (item.getStar().equals("")) {
            helper.setText(R.id.horizontal_game_score, mContext.getString(R.string.not_get_enough_score));
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                helper.setTextColor(R.id.horizontal_game_score, mContext.getColor(R.color.md_blue_grey_100));
                Drawable starDrawable = mContext.getDrawable(R.mipmap.icon_homeindex_star_grey);
                if (starDrawable != null) {
                    starDrawable.setBounds(0, 0, starDrawable.getMinimumWidth(), starDrawable.getMinimumHeight());
                }
                TextView scoreTxt = helper.getView(R.id.horizontal_game_score);
                scoreTxt.setCompoundDrawables(starDrawable, null, null, null);
            }
        } else {
            helper.setText(R.id.horizontal_game_score, item.getStar());
        }
    }

}
