package com.me.ask.askmesample.factory.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.holders.RowViewHolder;
import com.me.ask.askmesample.factory.models.DataList;
import com.me.ask.askmesample.factory.models.OnDataListUpdateListener;
import com.me.ask.askmesample.factory.models.RowVO;

import java.lang.ref.WeakReference;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */

public class RowAdapter extends RecyclerView.Adapter<RowViewHolder> implements OnDataListUpdateListener
{
    private DataList<RowVO> _rowDataList;
    private MultiRecyclerViewFactory _recyclerViewFactory;
    private WeakReference<OnMultiCyclerItemClickListener> _multiCyclerClickListener;

    private static final String TAG = RowAdapter.class.getSimpleName();

    public RowAdapter(DataList<RowVO> rowDataList, MultiRecyclerViewFactory recyclerViewFactory, OnMultiCyclerItemClickListener listener)
    {
        _rowDataList = rowDataList;
        _rowDataList.setOnDataListUpdateListener(this);
        _recyclerViewFactory = recyclerViewFactory;
        _multiCyclerClickListener = new WeakReference<OnMultiCyclerItemClickListener>(listener);
    }

    @Override
    public RowViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType)
    {
        View view = _recyclerViewFactory.getRowView(viewGroup, viewType);
        return _recyclerViewFactory.getRowViewHolder(view, viewType);
    }

    @Override
    public void onBindViewHolder(RowViewHolder listViewHolder, int position)
    {
        listViewHolder.bind(_rowDataList.get(position), _recyclerViewFactory, _multiCyclerClickListener.get());
    }

    @Override
    public int getItemCount()
    {
        return _rowDataList.size();
    }

    @Override
    public void onDataListUpdated()
    {
        notifyDataSetChanged();
    }

    @Override
    public int getItemViewType(int position)
    {
        if (_rowDataList == null || _rowDataList.get(position) == null)
        {
            return 0;
        }
        return _rowDataList.get(position).getRowType();
    }

    public void destroy()
    {
        _rowDataList = null;
        _recyclerViewFactory = null;
    }

}
