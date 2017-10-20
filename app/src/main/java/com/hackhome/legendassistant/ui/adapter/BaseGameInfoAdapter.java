package com.hackhome.legendassistant.ui.adapter;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.DataBean;

import java.util.List;

/**
 * Created by Administrator on 2017/10/18 0018.
 */
public class BaseGameInfoAdapter extends BaseQuickAdapter<DataBean,BaseViewHolder>{

    public Builder mBuilder;

    public static Builder builder() {

        return new Builder();
    }

    private BaseGameInfoAdapter(Builder builder) {
        super(builder.itemResId);
        this.mBuilder = builder;
    }

    @Override
    protected void convert(BaseViewHolder helper, DataBean item) {
        SimpleDraweeView gameIcon = helper.getView(R.id.base_game_icon);
//        gameIcon.setImageURI(item.);
        //test real main master
    }

    public static class Builder{

        private int itemResId = R.layout.base_game_info_item;

        public Builder itemResId(@LayoutRes int itemResId) {
            this.itemResId = itemResId;
            return this;
        }

        public BaseGameInfoAdapter build() {
            return new BaseGameInfoAdapter(this);
        }

    }
}
