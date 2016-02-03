package com.me.ask.askmesample.landing.sections;

import android.view.View;

import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.holders.RowViewHolder;
import com.me.ask.askmesample.factory.models.RowVO;

/**
 * Created by amritpalsingh on 04/02/16.
 */
public class SingleImageRowHolder extends RowViewHolder
{
    public SingleImageRowHolder(View itemView)
    {
        super(itemView);
    }

    @Override
    public void bind(RowVO vo, MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener)
    {

    }
}
