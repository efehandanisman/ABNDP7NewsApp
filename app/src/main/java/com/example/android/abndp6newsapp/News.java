package com.example.android.abndp6newsapp;

import android.app.LoaderManager;
import android.content.Context;
import android.content.Intent;
import android.content.Loader;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class News extends AppCompatActivity implements LoaderManager.LoaderCallbacks<List<NewsClass>> {

    private static final String GUARDIAN_REQUEST_URL = "https://content.guardianapis.com/search?q=facebook&api-key=test";
    private NewsAdapter mAdapter;
    private TextView mEmptyStateTextView;
    private static final int NEWS_LOADER_ID = 1;
    LoaderManager loaderManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news);
        ListView newsList = findViewById(R.id.list);
        mAdapter = new NewsAdapter(this, new ArrayList<NewsClass>());
        newsList.setAdapter(mAdapter);


        ConnectivityManager cm =
                (ConnectivityManager) this.getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetwork = cm.getActiveNetworkInfo();
        if (activeNetwork != null && activeNetwork.isConnected()) {
            loaderManager = getLoaderManager();
            loaderManager.initLoader(NEWS_LOADER_ID, null, News.this);
        } else {
            View loadingIndicator = findViewById(R.id.progress);
            loadingIndicator.setVisibility(View.GONE);
            // Update empty state with no connection error message
            mEmptyStateTextView.setText(R.string.no_internet_connection);
        }


        mEmptyStateTextView = (TextView) findViewById(R.id.empty_view);
        newsList.setEmptyView(mEmptyStateTextView);


        newsList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                NewsClass currentNews = mAdapter.getItem(position);
                String cmp = currentNews.getUrl();
                // Create a new intent to view the earthquake URI
                String url = "https://www.theguardian.com/" + cmp;
                Intent websiteIntent = new Intent(Intent.ACTION_VIEW);
                websiteIntent.setData(Uri.parse(url));
                startActivity(websiteIntent);
            }
        });


    }

    @Override
    public Loader<List<NewsClass>> onCreateLoader(int i, Bundle bundle) {
        return new NewsLoader(this, GUARDIAN_REQUEST_URL);
    }

    @Override
    public void onLoadFinished(Loader<List<NewsClass>> loader, List<NewsClass> newsList) {
        mAdapter.clear();
        mEmptyStateTextView.setText(R.string.no_news);
        View progress = findViewById(R.id.progress);
        progress.setVisibility(View.GONE);
        if (newsList != null && !newsList.isEmpty()) {
            mAdapter.addAll(newsList);

        }
    }

    @Override
    public void onLoaderReset(Loader<List<NewsClass>> loader) {
        mAdapter.clear();
    }

}


