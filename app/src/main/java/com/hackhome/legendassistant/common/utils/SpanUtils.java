package com.hackhome.legendassistant.common.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.DrawableRes;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.widget.TextView;

import com.hackhome.legendassistant.R;

/**
 * Created by Administrator on 2017/10/12 0012.
 */
public class SpanUtils {

    private static SpanUtils mSpanUtils;

    public static SpanUtils getSpanUtils() {
        if (null == mSpanUtils) {
            mSpanUtils = new SpanUtils();
        }
        return mSpanUtils;
    }

    /**
     * 左部tag加方框，右部分标题加粗显示
     * @param tag
     * @param title
     * @param tv
     * @param id
     */
    public void setText(Context context,String tag, String title, TextView tv, @DrawableRes int id) {
        SpannableString spannableString = new SpannableString(tag+" "+title);
        Drawable drawable = context.getResources().getDrawable(id);
        spannableString.setSpan(new ImageSpan(drawable){
            @Override
            public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {

//                canvas.save();
                paint.setTypeface(Typeface.create("normal", Typeface.NORMAL));
                paint.setTextSize(DensityUtil.sp2px(context,9));
                int tagLength = Math.round(paint.measureText(tag, 0, tag.length()));
                Rect bounds = new Rect();
                paint.getTextBounds(tag,0,tag.length(),bounds);
                int tagWidth = bounds.width();
                int tagHeight = bounds.height();
                Drawable drawable1 = getDrawable();
                drawable1.setBounds(0, 0, tagWidth+DensityUtil.dip2px(context,15), DensityUtil.dip2px(context,16));
                Log.i("aragon", "draw: "
                        + "tagWidth=" + tagWidth
                        + "\ntagHeight=" + tagHeight
                        + "\ntagLength" + tagLength
                        + "\nstart=" + start
                        + "\nend=" + end
                        + "\ntop=" + top
                        + "\ny=" + y
                        + "\nx=" + x
                        + "\ntext=" + text
                );
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
                    paint.setColor(context.getColor(R.color.md_deep_orange_A700));
                }
                canvas.drawText(tag, start+DensityUtil.dip2px(context,8), y-DensityUtil.dip2px(context,2),paint);
//                canvas.save();
//                canvas.translate(50, 0);
                drawable1.draw(canvas);
//                super.draw(canvas, te
// xt, start, end, x, top, y, bottom, paint);
//                canvas.restore();
            }
        },0,2,Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
//        SpannableStringBuilder builder = new SpannableStringBuilder();

        tv.postInvalidate();
        tv.setText(spannableString);
        tv.postInvalidate();
    }


}
