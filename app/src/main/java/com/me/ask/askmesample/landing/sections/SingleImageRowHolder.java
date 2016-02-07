package com.me.ask.askmesample.landing.sections;

import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;

import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.holders.RowViewHolder;
import com.me.ask.askmesample.factory.models.ItemVO;
import com.me.ask.askmesample.factory.models.RowVO;
import com.me.ask.askmesample.services.models.SectionVO;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

/**
 * Created by Amritpal.Makkar on 04-feb-16.
 */
public class SingleImageRowHolder extends RowViewHolder implements View.OnClickListener
{

    private WeakReference<OnMultiCyclerItemClickListener> _onMultiCyclerItemClickListener;
    private WeakReference<RowVO> _rowVO;

    public SingleImageRowHolder(View itemView)
    {
        super(itemView);
    }

    @Override
    public void bind(RowVO vo, MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener)
    {

        _onMultiCyclerItemClickListener = new WeakReference<>(listener);
        _rowVO = new WeakReference<>(vo);

        ImageView banner = (ImageView) super.itemView;

        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) banner.getContext().getSystemService(super.itemView.getContext().WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);

        ViewGroup.LayoutParams params = super.itemView.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.widthPixels * 9 / 16;
        banner.setLayoutParams(params);
        banner.setOnClickListener(this);

        Picasso.with(banner.getContext()).load(((SectionVO) vo).getImageUrl()).into(banner);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v)
    {
        ItemVO itemVO = _rowVO.get().getItemsList().get(0);
        _onMultiCyclerItemClickListener.get().onMultiCyclerItemClick(v, itemVO);
    }
}
