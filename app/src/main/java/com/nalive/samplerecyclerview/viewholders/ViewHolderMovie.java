package com.nalive.samplerecyclerview.viewholders;

import android.databinding.DataBindingUtil;
import android.view.ViewGroup;

import com.nalive.samplerecyclerview.R;
import com.nalive.samplerecyclerview.databinding.ViewMovieBinding;
import com.nalive.samplerecyclerview.models.BaseModel;
import com.nalive.samplerecyclerview.models.ModelMovie;

/**
 * Created by ${ USER} on 2017. 6. 28..
 */

public class ViewHolderMovie extends BaseViewHolder {
    ViewMovieBinding layout;

    public ViewHolderMovie(ViewGroup parent) {
        super(parent, R.layout.view_movie);

        layout = DataBindingUtil.bind(itemView);
    }

    @Override
    public void onBind(BaseModel model) {
        layout.setModel((ModelMovie) model);
    }

}

