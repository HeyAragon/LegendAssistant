package com.hackhome.legendassistant.ui.adapter;


import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.DataBean;
import com.hackhome.legendassistant.commen.utils.SpanUtils;

import java.util.List;


/**
 * Created by Administrator on 2017/10/8 0008.
 */
public class RecommendNewsAdapter extends BaseQuickAdapter<DataBean.ListBean,BaseViewHolder> {


    public RecommendNewsAdapter(@Nullable List<DataBean.ListBean> data) {
        super(R.layout.home_news_item_view,data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DataBean.ListBean item) {
        SimpleDraweeView icon = helper.getView(R.id.news_icon);
        icon.setImageURI(Uri.parse(item.getIcon()));
//        helper.setText(R.id.news_tag, item.getTag());
        TextView textView = helper.getView(R.id.news_tag);
        SpanUtils.getSpanUtils().setText(mContext,item.getTag(),"        "+item.getTitle(),textView,R.drawable.news_tag_shape);
        //        helper.setText(R.id.news_title, item.getTitle());
        helper.setText(R.id.news_author, item.getWriter());
        helper.setText(R.id.news_view_count, item.getClick());
    }
}
