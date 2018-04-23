package com.example.android.abndp6newsapp;

/**
 * Created by Efehan on 17.4.2018.
 */

public class NewsClass {

    private String mTitle;
    private String mSection;
    private String mUrl;

    public NewsClass(String title,String section, String url) {
        mTitle = title;
        mSection = section;
        mUrl = url;
    }
    public String getTitle() {
        return mTitle;
    }

    public String getSection() {
        return mSection;
    }

    public String getUrl() {
        return mUrl;
    }

}
