package com.hackhome.legendassistant.ui.adapter;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.hackhome.legendassistant.R;

import java.util.List;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class RecommendMultiRecyAdapter extends BaseMultiItemQuickAdapter<RecommendMultipleItem,BaseViewHolder> {


    public RecommendMultiRecyAdapter(List<RecommendMultipleItem> data) {
        super(data);

        addItemType(RecommendMultipleItem.NORMAL_IMG,R.layout.home_item_default_img);
        addItemType(RecommendMultipleItem.RECOMMEND_LIST,R.layout.home_item_horizontal_app);
        addItemType(RecommendMultipleItem.NEWS,R.layout.home_item_news);
        addItemType(RecommendMultipleItem.GAME_LIST,R.layout.home_item_app_list);
    }


    @Override
    protected void convert(BaseViewHolder helper, RecommendMultipleItem item) {
        int itemViewType = helper.getItemViewType();
        switch (itemViewType) {
            case RecommendMultipleItem.NORMAL_IMG:
                break;

            case RecommendMultipleItem.RECOMMEND_LIST:
                break;
            case RecommendMultipleItem.NEWS:
                break;
            case RecommendMultipleItem.GAME_LIST:
                break;

        }
    }
}
