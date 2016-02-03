package com.me.ask.askmesample.factory.adapters;


import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.holders.CellViewHolder;
import com.me.ask.askmesample.factory.models.DataList;
import com.me.ask.askmesample.factory.models.ItemVO;
import com.me.ask.askmesample.factory.models.OnDataListUpdateListener;

import java.lang.ref.WeakReference;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */

public class CellAdapter extends RecyclerView.Adapter<CellViewHolder> implements OnDataListUpdateListener
{
    protected DataList<ItemVO> _items;
    protected MultiRecyclerViewFactory _recyclerViewFactory;
    private int _rowType;
    private WeakReference<OnMultiCyclerItemClickListener> _multiCyclerClickListener;


    public CellAdapter(DataList<ItemVO> items, MultiRecyclerViewFactory recyclerViewFactory, int rowType, OnMultiCyclerItemClickListener listener)
    {
        _items = items;
        _items.setOnDataListUpdateListener(this);
        _rowType = rowType;
        _recyclerViewFactory = recyclerViewFactory;
        _multiCyclerClickListener = new WeakReference<OnMultiCyclerItemClickListener>(listener);

    }

    @Override
    public CellViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = _recyclerViewFactory.getCellView(viewGroup, _rowType);
        return _recyclerViewFactory.getCellViewHolder(view, _rowType);
    }

    @Override
    public void onBindViewHolder(CellViewHolder holder, int position)
    {
        holder.bind(_items.get(position), position, _multiCyclerClickListener.get());
    }

    @Override
    public int getItemCount()
    {
        return _items.size();
    }

    @Override
    public void onDataListUpdated()
    {
        notifyDataSetChanged();
    }
}
