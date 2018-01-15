package com.hackhome.legendassistant.ui.adapter;


import android.net.Uri;
import android.support.annotation.Nullable;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.facebook.drawee.view.SimpleDraweeView;
import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.bean.DataBean;
import com.hackhome.legendassistant.common.utils.SpanUtils;

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

        TextView textView = helper.getView(R.id.news_title);
//        Rect bounds = new Rect();
//        Paint paint = new Paint();
//        paint.getTextBounds(tag, 0, tag.length(), bounds);
//        int tagWidth = bounds.width();
//        int tagHeight = bounds.height();

//        TextShapeDrawable drawable = TextShapeDrawable.builder()
//                .beginConfig()
//                .fontSize(DensityUtil.sp2px(mContext, 9))
//                .textColor(Color.parseColor("#FF3D00"))
//                .width(80).height(80)
//                .withBorder(DensityUtil.sp2px(mContext, 1))
//                .endConfig()
//                .buildRoundRect(item.getTag(), Color.parseColor("#00FF3D00"), DensityUtil.dip2px(mContext, 4));
//        drawable.setBounds(0, 0, 80, 80);
//        textView.setCompoundDrawables(drawable, null, null, null);
//        textView.setText(item.getTitle());
        SpanUtils.getSpanUtils().setText(mContext,item.getTag(),item.getTitle(),textView,R.drawable.news_tag_shape);
        textView.invalidate();
//        SpannableString spannableString = new SpannableString(item.getTag()+" "+item.getTitle());
//        Drawable drawable = mContext.getResources().getDrawable(R.drawable.news_tag_shape);
//        spannableString.setSpan(new VerticalImageSpan(drawable,mContext),0,item.getTag().length(), Spanned.SPAN_INCLUSIVE_EXCLUSIVE );
//        textView.setText(spannableString);

        helper.setText(R.id.news_author, item.getWriter());
        helper.setText(R.id.news_view_count, item.getClick());
    }
}
