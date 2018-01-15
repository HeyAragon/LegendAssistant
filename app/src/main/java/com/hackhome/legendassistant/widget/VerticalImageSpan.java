package com.hackhome.legendassistant.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.text.style.ImageSpan;
import android.util.Log;

import com.hackhome.legendassistant.R;
import com.hackhome.legendassistant.common.utils.DensityUtil;

/**
 * Created by aragon on 2017/11/2 0002.
 */
public class VerticalImageSpan extends ImageSpan {

    private Context mContext;

    private static final String TAG = "VerticalImageSpan";

    public VerticalImageSpan(Drawable drawable,Context context) {
        super(drawable);
        this.mContext = context;

    }

    public int getSize(Paint paint, CharSequence text, int start, int end,
                       Paint.FontMetricsInt fontMetricsInt) {
        Drawable drawable = getDrawable();
        Rect rect = drawable.getBounds();
        if (fontMetricsInt != null) {
            Paint.FontMetricsInt fmPaint = paint.getFontMetricsInt();
            int fontHeight = fmPaint.bottom - fmPaint.top;
            int drHeight = rect.bottom - rect.top;
            int top = drHeight / 2 - fontHeight / 4;
            int bottom = drHeight / 2 + fontHeight / 4;
            fontMetricsInt.ascent = -bottom;
            fontMetricsInt.top = -bottom;
            fontMetricsInt.bottom = top;
            fontMetricsInt.descent = top;
        }
        return rect.right;
    }

    @Override
    public void draw(Canvas canvas, CharSequence text, int start, int end,
                     float x, int top, int y, int bottom, Paint paint) {
        String tag = text.toString().substring(0, 2);

        paint.setTypeface(Typeface.create("normal", Typeface.NORMAL));
        paint.setTextSize(DensityUtil.sp2px(mContext,9));

        Drawable drawable = getDrawable();
        Rect bounds = new Rect();
        paint.getTextBounds(tag, 0, tag.length(), bounds);
        int tagWidth = bounds.width();
        int tagHeight = bounds.height();
//        drawable.setBounds(0, 0, tagWidth + DensityUtil.dip2px(mContext, 15), DensityUtil.dip2px(mContext, 16));
        drawable.setBounds(0, 0, tagWidth ,tagHeight);
        canvas.save();
        int transY = 0;
        transY = ((bottom - top) - drawable.getBounds().bottom) / 2 + top;
        Log.i(TAG, "draw: " + "tagWidth=" + tagWidth
                + "\ntagHeight=" + tagHeight
                + "\ndrawableBottom" + drawable.getBounds().bottom
                + "\nstart=" + start
                + "\ntop=" + top
                + "\nx=" + x
                + "\ny=" + y
                + "\ntext=" + text
                + "\ntransY"+transY
                + "\ntag"+tag
        );
//        super.draw();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            paint.setColor(mContext.getColor(R.color.md_deep_orange_A700));
        }
        canvas.translate(0, 0);
        drawable.draw(canvas);
//        canvas.drawText(tag, start+DensityUtil.dip2px(mContext,8), y-DensityUtil.dip2px(mContext,2),paint);
        canvas.drawText(tag, 0,0 ,paint);
        canvas.restore();
    }


    //            paint.setTypeface(Typeface.create("normal", Typeface.NORMAL));
//            paint.setTextSize(DensityUtil.sp2px(context,9));
//            int tagLength = Math.round(paint.measureText(tag, 0, tag.length()));
//            Rect bounds = new Rect();
//            paint.getTextBounds(tag,0,tag.length(),bounds);
//            int tagWidth = bounds.width();
//            int tagHeight = bounds.height();
//            Drawable drawable1 = getDrawable();
//            drawable1.setBounds(0, 0, tagWidth+DensityUtil.dip2px(context,15), DensityUtil.dip2px(context,16));
//            Log.i("aragon", "draw: "
//                    + "tagWidth=" + tagWidth
//                    + "\ntagHeight=" + tagHeight
//                    + "\ntagLength" + tagLength
//                    + "\nstart=" + start
//                    + "\ntop=" + top
//                    + "\ny=" + y
//                    + "\ntext=" + text
//            );
//            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
//                paint.setColor(context.getColor(R.color.md_deep_orange_A700));
//            }
//            drawable1.draw(canvas);
//            canvas.drawText(tag, start+DensityUtil.dip2px(context,8), y-DensityUtil.dip2px(context,2),paint);
}
