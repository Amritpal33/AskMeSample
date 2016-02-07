package com.me.ask.askmesample.factory.models;

import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.adapters.CellAdapter;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */

public abstract class RowVO
{
    private String _displayLabel;
    protected DataList<ItemVO> _items;
    private CellAdapter _customRowAdapter;
    private int _rowType;

    public RowVO(String displayLabel,DataList<ItemVO> items, int rowType)
    {
        _displayLabel = displayLabel;
        _items = items;
        _rowType = rowType;
    }

    public String getDisplayLabel()
    {
        return _displayLabel;
    }

    public CellAdapter getCellAdapter(MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener)
    {
        if (_customRowAdapter == null)
        {
            _customRowAdapter = new CellAdapter(_items, factory, _rowType, listener);
        }
        return _customRowAdapter;
    }

    public int getRowType()
    {
        return _rowType;
    }

    public DataList<ItemVO> getItemsList()
    {
        return _items;

    }
}
