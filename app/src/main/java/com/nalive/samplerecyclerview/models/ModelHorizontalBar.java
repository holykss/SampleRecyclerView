package com.nalive.samplerecyclerview.models;

public class ModelHorizontalBar extends BaseModel {

    String title;

    public String getTitle() {
        return title;
    }

    public ModelHorizontalBar(String imagetitle) {
        this.title = imagetitle;

    }

    @Override
    public int getViewType() {
        return 0;
    }
}
