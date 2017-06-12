package com.gpillaca.testmvp.vista.fragment;

import android.content.Context;
import android.graphics.Rect;
import android.support.annotation.IntegerRes;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.View;

/**
 * Created by gefer on 26/05/2017.
 */

public class ItemOffsetDecoration extends RecyclerView.ItemDecoration {
    private int mItemOffset;

    public ItemOffsetDecoration(Context context, @IntegerRes int integerResId){
        int intemOffsetDp = context.getResources().getInteger(integerResId);
        mItemOffset = convertToPx(intemOffsetDp, context.getResources().getDisplayMetrics());
    }

    public int convertToPx(int offsetDp, DisplayMetrics metrics){
        return  offsetDp * (metrics.densityDpi / 160);
    }

    @Override
    public void getItemOffsets(Rect outRect, View view, RecyclerView parent, RecyclerView.State state) {
        super.getItemOffsets(outRect, view, parent, state);
        outRect.set(mItemOffset, mItemOffset, mItemOffset, mItemOffset);
    }
}
