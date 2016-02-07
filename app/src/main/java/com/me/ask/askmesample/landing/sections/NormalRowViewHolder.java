package com.me.ask.askmesample.landing.sections;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.me.ask.askmesample.R;
import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.holders.RowViewHolder;
import com.me.ask.askmesample.factory.models.RowVO;

import java.lang.ref.WeakReference;
/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */
public class NormalRowViewHolder extends RowViewHolder
{
    private WeakReference<RowVO> _rowVo;

    public NormalRowViewHolder(View itemView)
    {
        super(itemView);
        RecyclerView customListRecyclerView = getRecyclerView();
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(super.itemView.getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
        customListRecyclerView.setLayoutManager(linearLayoutManager);

    }

    public void bind(RowVO vo, MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener)
    {
        _rowVo = new WeakReference<>(vo);
        RecyclerView customListRecyclerView = getRecyclerView();
        customListRecyclerView.setAdapter(vo.getCellAdapter(factory, listener));
        getTitleView().setText(vo.getDisplayLabel());
    }

    private RecyclerView getRecyclerView()
    {
        return (RecyclerView) super.itemView.findViewById(R.id.rvVideoRecycler);
    }

    private TextView getTitleView()
    {
        return (TextView) super.itemView.findViewById(R.id.tvRowTitle);
    }

}
