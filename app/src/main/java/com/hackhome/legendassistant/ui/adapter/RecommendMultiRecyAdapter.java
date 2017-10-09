package com.hackhome.legendassistant.ui.adapter;

import android.content.Context;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseMultiItemQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.DataBean;
import com.hackhome.legendassistant.commen.utils.DateUtils;

import java.util.List;

/**
 * Created by Administrator on 2017/9/28 0028.
 */
public class RecommendMultiRecyAdapter extends BaseMultiItemQuickAdapter<DataBean,BaseViewHolder> {

    private Context mContext;

    private RecommendGameListAdapter mRecommendGameListAdapter;
    private RecyclerView mGameListRecyclerView;

    public RecommendMultiRecyAdapter(List<DataBean> data,Context context) {
        super(data);
        this.mContext = context;
        addItemType(DataBean.DEFAULT_NORMAL,R.layout.home_item_default);
        addItemType(DataBean.DEFAULT_CAN_CHANGE,R.layout.home_item_default);
        addItemType(DataBean.RECOMMEND_LIST,R.layout.home_item_horizontal_app);
        addItemType(DataBean.NEWS,R.layout.home_item_news);
        addItemType(DataBean.GAME_LIST,R.layout.home_item_app_list);

    }

    @Override
    protected void convert(BaseViewHolder helper, DataBean item) {
        int itemViewType = helper.getItemViewType();
        SimpleDraweeView bigImg;
        SimpleDraweeView gameIcon;
        TextView gameTitle, fromInfo,tagOne,tagTwo,tagThree;
        RecyclerView gameListRecyclerView;
        switch (itemViewType) {
            case DataBean.DEFAULT_NORMAL:
            case DataBean.DEFAULT_CAN_CHANGE:
                bigImg = helper.getView(R.id.home_item_big_img);
                gameIcon = helper.getView(R.id.home_item_game_icon);

                if (itemViewType == DataBean.DEFAULT_NORMAL) {
                    helper.setVisible(R.id.home_item_refresh_icon, false);
                    helper.setVisible(R.id.home_item_game_from, true);

                    bigImg.setImageURI(item.getIcon());
                    gameIcon.setImageURI(item.getLogo());
                    helper.setText(R.id.home_item_game_title,item.getTitle() );
                    helper.setText(R.id.home_item_game_from,"来自"+item.getUserinfo().getName()+"的推荐");
                    helper.setText(R.id.home_item_game_introduce,item.getIntro() );
                    helper.setText(R.id.home_item_update_time, DateUtils.getTimePoint(item.getTime()));
                    helper.setText(R.id.home_item_tag_one, item.getTags().get(0).getTitle());
                    helper.setText(R.id.home_item_tag_two, item.getTags().get(1).getTitle());
                    helper.setText(R.id.home_item_tag_three, item.getTags().get(2).getTitle());
                    helper.setText(R.id.home_item_game_download_count, item.getNum_download());
                    helper.setText(R.id.home_item_game_comments_count, item.getNum_comment()+"");
                } else {

                    helper.setVisible(R.id.home_item_refresh_icon, true);
                    helper.setVisible(R.id.home_item_game_from, false);
                    bigImg.setImageURI(item.getHost_list().get(0).getIcon());
                    gameIcon.setImageURI(item.getHost_list().get(0).getLogo());
                    helper.setText(R.id.home_item_game_title,item.getHost_list().get(0).getTitle() );
                    helper.setText(R.id.home_item_game_introduce,item.getHost_list().get(0).getIntro());
                    helper.setText(R.id.home_item_tag_one, item.getHost_list().get(0).getTags().get(0).getTitle());
                    helper.setText(R.id.home_item_tag_two, item.getHost_list().get(0).getTags().get(1).getTitle());
                    helper.setText(R.id.home_item_tag_three, item.getHost_list().get(0).getTags().get(2).getTitle());
                    helper.setText(R.id.home_item_game_download_count, item.getHost_list().get(0).getNum_download());
                    helper.setText(R.id.home_item_game_comments_count, item.getHost_list().get(0).getNum_comment());

                }

                break;

            case DataBean.RECOMMEND_LIST:
                break;
            case DataBean.NEWS:
                break;
            case DataBean.GAME_LIST:

                helper.setText(R.id.base_item_recommend_type_txt, item.getTitle());
                helper.setVisible(R.id.base_item_more_txt, false);
                mGameListRecyclerView = helper.getView(R.id.home_item_week_game_list);
                mRecommendGameListAdapter = new RecommendGameListAdapter(item.getTags());
                mGameListRecyclerView.setLayoutManager(new GridLayoutManager(mContext,2));
                mGameListRecyclerView.setAdapter(mRecommendGameListAdapter);
                break;

        }
    }



}
