package com.me.ask.askmesample.landing.sections;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.me.ask.askmesample.R;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.models.DataList;
import com.me.ask.askmesample.factory.models.ItemVO;
import com.me.ask.askmesample.factory.models.OnDataListUpdateListener;
import com.squareup.picasso.Picasso;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */

public class SliderViewPagerAdapter extends PagerAdapter implements View.OnClickListener, OnDataListUpdateListener
{

    private static final String TAG = SliderViewPagerAdapter.class.getSimpleName();
    private DataList<ItemVO> _itemVOs;
    private Context _context;
    private OnMultiCyclerItemClickListener _onMultiCyclerItemClickListener;
    private ViewPager _container;


    public SliderViewPagerAdapter(Context context, DataList<ItemVO> itemVOList, OnMultiCyclerItemClickListener listener)
    {
        _itemVOs = itemVOList;
        _itemVOs.setOnDataListUpdateListener(this);
        _context = context;
        _onMultiCyclerItemClickListener = listener;

    }

    @Override
    public Object instantiateItem(ViewGroup container, int position)
    {
        _container = (ViewPager) container;
        View view = LayoutInflater.from(_context).inflate(R.layout.slider_cell_layout, container, false);
        initView(view, _itemVOs.get(position), position);
        view.setTag(R.id.idViewPagerItem, _itemVOs.get(position));
        view.setOnClickListener(this);
        container.addView(view);

        return view;
    }

    private void initView(View v, ItemVO itemVO, int position)
    {
        ImageView imageView = (ImageView) v.findViewById(R.id.imgSliderPoster);
        Picasso.with(_context)
                .load("url")
                .into(imageView);
    }

    @Override
    public int getCount()
    {
        return _itemVOs.size();
    }

    @Override
    public boolean isViewFromObject(View view, Object object)
    {
        return view == object;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object)
    {
        container.removeView((ViewGroup) object);
    }

    @Override
    public void onClick(View v)
    {
        _onMultiCyclerItemClickListener.onMultiCyclerItemClick(v, (ItemVO) v.getTag(R.id.idViewPagerItem));
    }


    @Override
    public void onDataListUpdated()
    {
        notifyDataSetChanged();
    }

    public int getItemPosition(Object object)
    {
        return POSITION_NONE;
    }


}
