package com.hackhome.legendassistant.ui.adapter;

import com.chad.library.adapter.base.entity.MultiItemEntity;

/**
 * Created by Administrator on 2017/9/29 0029.
 */
public class RecommendMultipleItem implements MultiItemEntity {


    //正常列表
    public static final int NORMAL_IMG = 0;

    //本周精选游戏合集
    public static final int GAME_LIST = 3;

    //横向推荐游戏列表
    public static final int RECOMMEND_LIST = 5;

    //头条速递
    public static final int NEWS = 6;

    private int mItemType;


    public RecommendMultipleItem(int itemType) {
        mItemType = itemType;
    }

    @Override
    public int getItemType() {
        return mItemType;
    }
}
