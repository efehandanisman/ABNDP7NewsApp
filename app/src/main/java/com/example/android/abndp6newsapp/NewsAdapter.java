package com.example.android.abndp6newsapp;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Efehan on 17.4.2018.
 */

public class NewsAdapter extends ArrayAdapter<NewsClass> {

    public NewsAdapter(Activity context, ArrayList<NewsClass> News) {
    super(context, 0, News);
}

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        NewsClass news = getItem(position);


        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);


        }
TextView title = listItemView.findViewById(R.id.title);
        title.setText(news.getTitle());

        TextView section = listItemView.findViewById(R.id.pillarName);
section.setText(news.getSection());

        TextView url = listItemView.findViewById(R.id.url);
        url.setText(news.getUrl());

 return listItemView;

}}