package com.me.ask.askmesample.services;

/**
 * Created by amritpalsingh on 04/02/16.
 */
public interface iDataProcessingListener
{
    public void onDataProcessingSuccess(iSectionDataProcessor sectionDataProcessor);

    public void onDataProcessingError();
}
