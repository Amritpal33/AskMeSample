package com.me.ask.askmesample.landing.sections;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.me.ask.askmesample.R;
import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.holders.CellViewHolder;
import com.me.ask.askmesample.factory.holders.RowViewHolder;


/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */
public class AskMeLayoutFactory extends MultiRecyclerViewFactory
{
    @Override
    public View getRowView(ViewGroup parent, int rowID)
    {
        final LayoutType type = LayoutType.getType(rowID);

        switch (type)
        {
            case LAYOUT_VIEW_PAGER:
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_view_pager, parent, false);

            case LAYOUT_TYPE_NORMAL:
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.normal_recycler_row_layout, parent, false);

        }
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.normal_recycler_row_layout, parent, false);
    }

    @Override
    public RowViewHolder getRowViewHolder(View itemView, int rowID)
    {
        final LayoutType type = LayoutType.getType(rowID);
        switch (type)
        {
            case LAYOUT_VIEW_PAGER:
                return new SliderRowViewHolder(itemView);

            case LAYOUT_TYPE_NORMAL:
                return new NormalRowViewHolder(itemView);

        }
        return new NormalRowViewHolder(itemView);
    }

    @Override
    public View getCellView(ViewGroup parent, int rowID)
    {

        final LayoutType type = LayoutType.getType(rowID);
        switch (type)
        {
            case LAYOUT_VIEW_PAGER:
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_cell_layout, parent, false);

            case LAYOUT_TYPE_NORMAL:
                return LayoutInflater.from(parent.getContext()).inflate(R.layout.normal_cell_layout, parent, false);

        }
        return LayoutInflater.from(parent.getContext()).inflate(R.layout.normal_cell_layout, parent, false);

    }

    @Override
    public CellViewHolder getCellViewHolder(View itemView, int rowID)
    {

        final LayoutType type = LayoutType.getType(rowID);

        switch (type)
        {
            case LAYOUT_TYPE_NORMAL:
                return new NormalCellViewHolder(itemView);

        }
        return new NormalCellViewHolder(itemView);

    }


    public enum LayoutType
    {
        LAYOUT_NONE(0), LAYOUT_VIEW_PAGER(1), LAYOUT_TYPE_NORMAL(2);

        private int _type;

        LayoutType(int type)
        {
            _type = type;
        }

        public static LayoutType getType(int type)
        {
            if (type == LAYOUT_VIEW_PAGER.getCode())
            {
                return LAYOUT_VIEW_PAGER;

            }
            else if (type == LAYOUT_TYPE_NORMAL.getCode())
            {
                return LAYOUT_TYPE_NORMAL;

            }
            return LAYOUT_NONE;

        }

        public int getCode()
        {
            return _type;
        }
    }


}

