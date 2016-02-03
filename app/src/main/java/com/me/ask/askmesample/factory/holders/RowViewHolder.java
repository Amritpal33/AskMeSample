package com.me.ask.askmesample.factory.holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.models.RowVO;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */

public abstract class RowViewHolder extends RecyclerView.ViewHolder
{
    public RowViewHolder(View itemView)
    {
        super(itemView);
    }

    public abstract void bind(RowVO vo, MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener);
}
