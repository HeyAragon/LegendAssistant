package com.hackhome.legendassistant.commen.utils;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.DrawableRes;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ImageSpan;
import android.util.Log;
import android.widget.TextView;

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
        SpannableString spannableString = new SpannableString(tag+title);
        Drawable drawable = context.getResources().getDrawable(id);
        spannableString.setSpan(new ImageSpan(drawable){
            @Override
            public void draw(Canvas canvas, CharSequence text, int start, int end, float x, int top, int y, int bottom, Paint paint) {
//                super.draw(canvas, text, start, end, x, top, y, bottom, paint);
//                canvas.save();
                paint.setTypeface(Typeface.create("normal", Typeface.NORMAL));
                paint.setTextSize(DensityUtil.sp2px(context,10));
                int tagLength = Math.round(paint.measureText(tag, 0, tag.length()));
                Rect bounds = new Rect();
                paint.getTextBounds(tag,0,tag.length(),bounds);
                int tagWidth = bounds.width();
                int tagHeight = bounds.height();
                Drawable drawable1 = getDrawable();
                drawable1.setBounds(0, 0, tagWidth+DensityUtil.dip2px(context,9), DensityUtil.dip2px(context,18));
                Log.i("aragon", "draw: "
                        + "tagWidth="+tagWidth
                        + "\ntagHeight="+tagHeight
                        +"\ntagLength"+tagLength
                        +"\nstart="+start
                        +"\ntop="+top
                        +"\ny="+y
                );
                paint.setColor(Color.BLUE);
                drawable1.draw(canvas);
//                canvas.drawText(tag, start, tag.length(), x, y-8, paint);
//                canvas.drawText(tag,
//                        (bounds.centerX()-(tagWidth/2f)),
//                        (bounds.centerY()+(tagHeight/2)),paint);
                canvas.drawText(tag, start+DensityUtil.dip2px(context,4), y-DensityUtil.dip2px(context,2),paint);
            }
        },0,tag.length(), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);

        tv.setText(spannableString);
    }


}
