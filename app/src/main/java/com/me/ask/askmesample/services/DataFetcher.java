package com.me.ask.askmesample.services;

import android.content.Context;
import android.os.AsyncTask;

import com.me.ask.askmesample.services.processors.iSectionDataProcessor;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.ref.WeakReference;
import java.util.Objects;

/**
 * Created by Amritpal.Makkar on 04-feb-16.
 */
public class DataFetcher
{

    private static DataFetcher _dataFetcher;
    private iSectionDataProcessor _processor;
    private WeakReference<iDataProcessingListener> _listener;
    private Context _context;

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

    public void fetchData(Context context, String fileName, iSectionDataProcessor processor, iDataProcessingListener listener)
    {
        _processor = processor;
        _listener = new WeakReference<iDataProcessingListener>(listener);
        _context = context;
        new DataFetcherTask().execute(fileName);
    }

    private class DataFetcherTask extends AsyncTask<String, Object, Boolean>
    {
        @Override
        protected Boolean doInBackground(String... params)
        {

            String response = readDataFromSource(params[0]);
            return _processor.parseData(response);
        }

        private String readDataFromSource(String fileName)
        {

            BufferedReader reader = null;
            StringBuilder builder = new StringBuilder();
            try
            {
                reader = new BufferedReader(
                        new InputStreamReader(_context.getAssets().open(fileName)));

                // do reading, usually loop until end of file reading
                String mLine;
                while ((mLine = reader.readLine()) != null)
                {
                    builder.append(mLine);
                }
            }
            catch (IOException e)
            {
                return null;
            }
            finally
            {
                if (reader != null)
                {
                    try
                    {
                        reader.close();
                    }
                    catch (IOException e)
                    {
                        return null;
                    }
                }
            }

            return builder.toString();
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
