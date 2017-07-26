package com.rushro2m.timeview;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.support.v7.widget.RecyclerView;
import android.view.View;

/**
 * Created by Administrator on 2017/7/26.
 */

public class DividerItemDecoration extends RecyclerView.ItemDecoration {

    //右边的画笔，具体内容
    private Paint msgPaint;
    //左边的画笔，时间+日期
    private Paint timePaint, datePaint;

    //左上偏移的长度
    private int item_left;
    private int item_top;

    //轴点半径
    private int circle_radius;

    //图标
    private Bitmap mIcon;

    public DividerItemDecoration(Context mContext) {

        //右边的画笔初始化
        msgPaint = new Paint();
        msgPaint.setColor(Color.RED);

        //左边的画笔初始化
        timePaint = new Paint();
        datePaint = new Paint();
        timePaint.setColor(Color.BLUE);
        datePaint.setColor(Color.BLUE);
        timePaint.setTextSize(30);


        item_left = 200;
        item_top = 50;

        circle_radius = 10;

        mIcon = BitmapFactory.decodeResource(mContext.getResources(), R.mipmap.ic_launcher);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(item_left, item_top, 0, 0);
    }

    @Override
    public void onDraw(Canvas c, RecyclerView parent, RecyclerView.State state) {
        super.onDraw(c, parent, state);
        int childCount = parent.getChildCount();
        for (int i = 0; i < childCount; i++) {

            //获取每个Item对象
            View child = parent.getChildAt(i);

            float centerX = child.getLeft() - item_left / 3;
            float centerY = child.getTop() - item_top + (item_top   + child.getHeight()) / 2;

            //绘制轴点
            c.drawCircle(centerX, centerY, circle_radius, msgPaint);
//            c.drawBitmap(mIcon, centerX, centerY, msgPaint);

            /*
             * 绘制上半轴线
             */

            //上端点坐标(x,y)
            float upLine_up_y = child.getTop() - item_top;

            //下端点坐标
            float upLine_bottom_y = child.getTop() - circle_radius;
            c.drawLine(centerX, upLine_up_y, centerX, upLine_bottom_y, msgPaint);

            /*
             *绘制下半轴线
             */

            float downLine_up_y = centerY + circle_radius;

            float downLine_bottom_y = child.getBottom();

            c.drawLine(centerX, downLine_up_y, centerX, downLine_bottom_y, msgPaint);

            /*
             * 绘制左边的时间轴
             */

            //获取每个Item的位置
            int index = parent.getChildAdapterPosition(child);

            //设置文本起始坐标
            float text_x = child.getLeft() - item_left * 5 / 6;

            //根据Item的位置设置时间文本
            switch (index) {
                case 0:
                    c.drawText("13:40", text_x, upLine_bottom_y, timePaint);
                    c.drawText("2017.07.26", text_x + 5, upLine_bottom_y + 20, datePaint);
                    break;
                case 1:
                    c.drawText("13:42", text_x, upLine_bottom_y, timePaint);
                    c.drawText("2017.07.26", text_x + 5, upLine_bottom_y + 20, datePaint);
                    break;
                case 2:
                    c.drawText("13:44", text_x, upLine_bottom_y, timePaint);
                    c.drawText("2017.07.26", text_x + 5, upLine_bottom_y + 20, datePaint);
                    break;
                case 3:
                    c.drawText("13:45", text_x, upLine_bottom_y, timePaint);
                    c.drawText("2017.07.26", text_x + 5, upLine_bottom_y + 20, datePaint);
                    break;
                case 4:
                    c.drawText("13:46", text_x, upLine_bottom_y, timePaint);
                    c.drawText("2017.07.26", text_x + 5, upLine_bottom_y + 20, datePaint);
                    break;
                case 5:
                    c.drawText("13:48", text_x, upLine_bottom_y, timePaint);
                    c.drawText("2017.07.26", text_x + 5, upLine_bottom_y + 20, datePaint);
                    break;
            }

        }
    }
}
