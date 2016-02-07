package com.me.ask.askmesample.services;

import com.me.ask.askmesample.services.processors.iSectionDataProcessor;

/**
 * Created by Amritpal.Makkar on 04-feb-16.
 */
public interface iDataProcessingListener
{
    public void onDataProcessingSuccess(iSectionDataProcessor sectionDataProcessor);

    public void onDataProcessingError();
}
