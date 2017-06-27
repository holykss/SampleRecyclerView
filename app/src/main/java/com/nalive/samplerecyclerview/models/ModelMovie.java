package com.nalive.samplerecyclerview.models;

import android.support.annotation.DrawableRes;

public class ModelMovie extends BaseModel {

    @DrawableRes int image;
    String imageTitle;

    public int getImage() {
        return image;
    }

    public String getImageTitle() {
        return imageTitle;
    }

    public ModelMovie(@DrawableRes int image, String imagetitle) {
        this.image = image;
        this.imageTitle = imagetitle;
    }

    @Override
    public int getViewType() {
        return 1;
    }
}
