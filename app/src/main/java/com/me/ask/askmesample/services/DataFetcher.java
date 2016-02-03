package com.me.ask.askmesample.services;

import android.os.AsyncTask;

import java.lang.ref.WeakReference;

/**
 * Created by amritpalsingh on 04/02/16.
 */
public class DataFetcher
{

    private static DataFetcher _dataFetcher;
    private iSectionDataProcessor _processor;
    private WeakReference<iDataProcessingListener> _listener;

    private DataFetcher()
    {
        if (_dataFetcher != null)
        {
            throw new IllegalStateException("No two instances of this class can Co-Exist.");
        }
    }

    public static DataFetcher getInstance()
    {
        if (_dataFetcher == null)
        {
            synchronized (DataFetcher.class)
            {
                _dataFetcher = new DataFetcher();
            }
        }
        return _dataFetcher;
    }

    public void fetchDataFromInputFirst(iSectionDataProcessor processor, iDataProcessingListener listener)
    {
        _processor = processor;
        _listener = new WeakReference<iDataProcessingListener>(listener);
    }

    private class DataFetcherTask extends AsyncTask<String, Object, Boolean>
    {
        @Override
        protected Boolean doInBackground(String... params)
        {
            return null;
        }


        @Override
        protected void onPostExecute(Boolean result)
        {
            if (result)
            {
                if (_listener != null)
                {
                    _listener.get().onDataProcessingSuccess(_processor);
                }
            }
            else
            {
                if (_listener != null)
                {
                    _listener.get().onDataProcessingError();
                }
            }
        }
    }


}
