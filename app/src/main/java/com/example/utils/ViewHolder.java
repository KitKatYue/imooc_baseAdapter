package com.example.utils;

import android.content.Context;
import android.util.SparseArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by SanYue
 * 2017/2/21
 * email sanyuedev@gmail.com
 */

public class ViewHolder {

    private SparseArray<View> mViews;
    private int mPostion;
    private View mConvertView;

    public ViewHolder(Context context, ViewGroup parent, int layoutId, int postion) {
        this.mPostion = postion;
        this.mViews = new SparseArray<View>();
        mConvertView = LayoutInflater.from(context).inflate(layoutId, parent, false);
        mConvertView.setTag(this);
    }

    public static ViewHolder get(Context context, View convertView, ViewGroup parent, int layoutId
            , int postion) {
        if (convertView == null) {
            ViewHolder holder = new ViewHolder(context, parent, layoutId, postion);
            holder.mPostion = postion;
            return holder;
        }
        return (ViewHolder) convertView.getTag();
    }

    /**
     * 通过viewId获取控件
     *
     * @param viewId 资源Id
     * @param <T>    View类型
     * @return T
     */
    public <T extends View> T getView(int viewId) {
        View view = mViews.get(viewId);
        if (view == null) {
            view = mConvertView.findViewById(viewId);
            mViews.put(viewId, view);
        }
        return (T) view;
    }

    public View getConvertView() {
        return mConvertView;
    }
}
