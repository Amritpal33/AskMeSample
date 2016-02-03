package com.me.ask.askmesample.factory.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.models.ItemVO;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */
public abstract class CellViewHolder extends RecyclerView.ViewHolder
{
    public CellViewHolder(View itemView)
    {
        super(itemView);
    }

    public abstract void bind(ItemVO itemVO, int position, OnMultiCyclerItemClickListener listener);
}
