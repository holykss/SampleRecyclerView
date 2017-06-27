package com.nalive.samplerecyclerview.viewholders;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.ViewGroup;

import com.nalive.samplerecyclerview.R;
import com.nalive.samplerecyclerview.databinding.ViewHorizontalBarBinding;
import com.nalive.samplerecyclerview.models.BaseModel;
import com.nalive.samplerecyclerview.models.ModelHorizontalBar;

/**
 * Created by ${ USER} on 2017. 6. 28..
 */

public class ViewHolderHorizontalBar extends BaseViewHolder {
    ViewHorizontalBarBinding layout;

    public ViewHolderHorizontalBar(ViewGroup parent) {
        super(parent, R.layout.view_horizontal_bar);

        layout = DataBindingUtil.bind(itemView);

        ViewGroup viewGroup = (ViewGroup) itemView.getRootView();
        StaggeredGridLayoutManager.LayoutParams params = (StaggeredGridLayoutManager.LayoutParams) viewGroup.getLayoutParams();
        params.setFullSpan(true);
        params.width = StaggeredGridLayoutManager.LayoutParams.MATCH_PARENT;

    }

    public void onBind(BaseModel model) {
        layout.setModel((ModelHorizontalBar)model);
    }
}
