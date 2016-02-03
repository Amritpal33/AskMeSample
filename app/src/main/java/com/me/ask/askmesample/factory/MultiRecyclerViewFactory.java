package com.me.ask.askmesample.factory;

import android.view.View;
import android.view.ViewGroup;

import com.me.ask.askmesample.factory.holders.CellViewHolder;
import com.me.ask.askmesample.factory.holders.RowViewHolder;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */
public abstract class MultiRecyclerViewFactory
{
    public abstract View getRowView(ViewGroup parent, int rowID);

    public abstract RowViewHolder getRowViewHolder(View itemView, int rowID);

    public abstract View getCellView(ViewGroup parent, int rowID);

    public abstract CellViewHolder getCellViewHolder(View itemView, int rowID);

}
