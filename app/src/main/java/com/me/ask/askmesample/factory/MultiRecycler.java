package com.me.ask.askmesample.factory;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.me.ask.askmesample.factory.adapters.RowAdapter;
import com.me.ask.askmesample.factory.models.DataList;
import com.me.ask.askmesample.factory.models.RowVO;

import java.util.List;
/**
 * Created by Amritpal.Makkar on 07-feb-16.
 */
public class MultiRecycler extends RecyclerView
{
    private DataList<RowVO> _rows;
    private RowAdapter _rowAdapter;
    private LinearLayoutManager linearLayoutManager;
    private boolean _isInited = false;

    public MultiRecycler(Context context)
    {
        super(context);
    }

    public MultiRecycler(Context context, AttributeSet attrs)
    {
        super(context, attrs);
    }

    public MultiRecycler(Context context, AttributeSet attrs, int defStyle)
    {
        super(context, attrs, defStyle);
    }

    @Override
    protected void onFinishInflate()
    {
        super.onFinishInflate();
        initialize();
    }

    private void initialize()
    {
        if (!_isInited)
        {
            _isInited = true;
            _rows = new DataList<>();
            linearLayoutManager = new LinearLayoutManager(getContext());
            linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
            this.setLayoutManager(linearLayoutManager);
        }
    }

    public LinearLayoutManager getLayoutManager()
    {
        return linearLayoutManager;
    }

    public void setMultiCyclerData(MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener)
    {
        if (_rowAdapter == null)
        {
            _rowAdapter = new RowAdapter(_rows, factory, listener);
            super.setAdapter(_rowAdapter);
        }
    }

    public void addData(List<RowVO> list)
    {
        _rows.addAll(list);
    }

    public void resetAdapterWith(List<RowVO> list)
    {
        _rows.resetWith(list);
    }

    public DataList<RowVO> getRows()
    {
        return _rows;
    }

    public void destroy()
    {
        if (super.getAdapter() != null)
        {
            ((RowAdapter) super.getAdapter()).destroy();
        }
    }

}
