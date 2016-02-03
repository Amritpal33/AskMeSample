package com.me.ask.askmesample.factory.models;

import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.adapters.CellAdapter;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */

public abstract class RowVO
{
    private String _displayTitle;
    private boolean _showMoreButton;
    private int _rowID;
    protected DataList<ItemVO> _items;
    private CellAdapter _customRowAdapter;
    private int _rowType;

    public RowVO(String displayTitle, int rowID, DataList<ItemVO> cellDataList, int rowType)
    {
        this(displayTitle, rowID, cellDataList, rowType, true);
    }

    public RowVO(String displayTitle, int rowID, DataList<ItemVO> items, int rowType, boolean showMoreButton)
    {
        _displayTitle = displayTitle;
        _showMoreButton = showMoreButton;
        _rowID = rowID;
        _items = items;
        _rowType = rowType;
    }

    public String getDisplayTitle()
    {
        return _displayTitle;
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

    public int getRowID()
    {
        return _rowID;
    }

    public boolean isShowMoreButton()
    {
        return _showMoreButton;
    }


    @Override
    public boolean equals(Object o)
    {
        return (o instanceof RowVO && this._rowID == ((RowVO) o)._rowID);
    }

    @Override
    public int hashCode()
    {
        final int prime = 31;
        int result = 17;
        return prime * result + _rowID;
    }
}
