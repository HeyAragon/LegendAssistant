package com.hackhome.legendassistant.ui.adapter;

import android.os.Environment;
import android.support.annotation.LayoutRes;
import android.view.View;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.DataBean;
import com.liulishuo.filedownloader.FileDownloader;
import com.socks.library.KLog;

import java.io.File;

/**
 * Created by Administrator on 2017/10/18 0018.
 */
public class BaseGameInfoAdapter extends BaseQuickAdapter<DataBean,BaseViewHolder>{

    public static final String TYPE_NEW = "sugar";
    public static final String TYPE_HOT = "hot";
    public static final String TYPE_EXPECT = "expect";

    public Builder mBuilder;

    public static Builder builder() {

        return new Builder();
    }

    private BaseGameInfoAdapter(Builder builder) {
        super(builder.mItemResId);
        this.mBuilder = builder;
    }

    @Override
    protected void convert(BaseViewHolder helper, DataBean item) {
        SimpleDraweeView gameIcon = helper.getView(R.id.base_game_icon);
        gameIcon.setImageURI(item.getIcon());
        helper.setText(R.id.base_game_name, item.getTitle());
        helper.setText(R.id.base_tag_one, item.getTags().get(0).getTitle());
        helper.setText(R.id.base_tag_two, item.getTags().get(1).getTitle());
        helper.setText(R.id.base_tag_three, item.getTags().get(2).getTitle());
        if (mBuilder.mApiType.equals(TYPE_NEW)) {
            helper.setGone(R.id.base_game_score_txt, false);
            helper.setGone(R.id.base_hot_count_txt, false);
            helper.setText(R.id.base_game_sub_title, item.getDevname());
        } else if (mBuilder.mApiType.equals(TYPE_HOT)) {
            helper.setGone(R.id.base_game_score_txt, false);
            helper.setGone(R.id.base_hot_count_txt, true);
            helper.setText(R.id.base_game_sub_title, item.getDowninfo().getSize_m());
        } else if (mBuilder.mApiType.equals(TYPE_EXPECT)) {
            helper.setGone(R.id.base_game_score_txt, false);
            helper.setGone(R.id.base_hot_count_txt, true);
            helper.setText(R.id.base_game_sub_title, item.getTime());
        }

        helper.setOnClickListener(R.id.base_download_btn, new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "fuck", Toast.LENGTH_SHORT).show();
                File file = Environment.getExternalStorageDirectory().getAbsoluteFile();
                KLog.i("aragon",file);
//                FileDownloader.setup(mContext);
//                FileDownloader.getImpl().create(item.getDowninfo().getApkurl()).start();
            }
        });
        //main master
    }

    public static class Builder{

        private int mItemResId = R.layout.base_game_info_item;

        private String mApiType;


        public Builder itemResId(@LayoutRes int itemResId) {
            this.mItemResId = itemResId;
            return this;
        }

        public Builder apiType(String apiType) {
            this.mApiType = apiType;
            return this;
        }

        public BaseGameInfoAdapter build() {
            return new BaseGameInfoAdapter(this);
        }

    }
}
