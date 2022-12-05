package com.example.atlas;

import android.widget.ImageView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerViewData {
    String title;
    String description;
    int category_id;
    int item_id;
    RecyclerView data;
    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public int getCategory_id() {
        return category_id;
    }

    public void setCategory_id(int category_id) {
        this.category_id = category_id;
    }

    public int getItem_id() {
        return item_id;
    }

    public void setItem_id(int item_id) {
        this.item_id = item_id;
    }

    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public void setCrossImage(ImageView crossImage){
        setCrossImage(crossImage);
    }
}