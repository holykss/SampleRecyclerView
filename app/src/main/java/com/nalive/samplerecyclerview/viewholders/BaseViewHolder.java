package com.nalive.samplerecyclerview.viewholders;

import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.nalive.samplerecyclerview.models.BaseModel;

/**
 * Created by ${ USER} on 2017. 6. 28..
 */

public abstract class BaseViewHolder extends RecyclerView.ViewHolder {

    public BaseViewHolder(@NonNull ViewGroup parent, @LayoutRes int layoutRes) {
        super(LayoutInflater.from(parent.getContext()).
                inflate(layoutRes, parent, false));
    }

    public abstract void onBind(BaseModel model);

    public static BaseViewHolder create(ViewGroup parent, int viewType) {
        switch (viewType) {
            case 0:
                return new ViewHolderHorizontalBar(parent);
            case 1:
                return new ViewHolderMovie(parent);
            default:
                return null;
        }
    }
}
