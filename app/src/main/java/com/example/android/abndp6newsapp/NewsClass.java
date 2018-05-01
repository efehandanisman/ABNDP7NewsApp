package com.example.android.abndp6newsapp;

import java.util.Date;

/**
 * Created by Efehan on 17.4.2018.
 */

public class NewsClass {

    private String mTitle;
    private String mSection;
    private String mUrl;
    private String mDate;

    public NewsClass(String title, String section, String url, String date) {
        mTitle = title;
        mSection = section;
        mUrl = url;
        mDate = date;
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


    public String getDate() {
        return mDate;
    }

}
