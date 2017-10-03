package com.product.gemesif.gemesifvelo;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

public class LockableViewPager extends ViewPager {

    private boolean swipeable;

    String DEBUG_TAG = "gemesifLog";

    public LockableViewPager(Context context) {
        super(context);
    }

    public LockableViewPager(Context context, AttributeSet attrs) {
        super(context, attrs);
        this.swipeable = true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {

        // Log.d("DEBUG_TAG", "LockableViewPager onTouchEvent");

        if (this.swipeable) {
            return super.onTouchEvent(event);
        }

        return true;
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent event) {

        // Log.d("gemesifLog", "LockableViewPager onInterceptTouchEvent");

        if (this.swipeable) {
            return super.onInterceptTouchEvent(event);
        }

        return false;
    }

    public void setSwipeable(boolean swipeable) {
        this.swipeable = swipeable;
    }
}