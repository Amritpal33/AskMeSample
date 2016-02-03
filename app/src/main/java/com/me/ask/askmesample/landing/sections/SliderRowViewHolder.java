package com.me.ask.askmesample.landing.sections;

import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;

import com.me.ask.askmesample.R;
import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.holders.RowViewHolder;
import com.me.ask.askmesample.factory.models.RowVO;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */

public class SliderRowViewHolder extends RowViewHolder
{
    private static final String TAG = SliderRowViewHolder.class.getSimpleName();

    public SliderRowViewHolder(View itemView)
    {
        super(itemView);
    }

    @Override
    public void bind(RowVO vo, MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener)
    {

        ViewPager pager = getViewPager();

        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) super.itemView.getContext().getSystemService(super.itemView.getContext().WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);

        ViewGroup.LayoutParams params = pager.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.widthPixels * 9 / 16;
        pager.setLayoutParams(params);


        if (pager.getAdapter() == null)
        {
            SliderViewPagerAdapter sliderViewPagerAdapter = new SliderViewPagerAdapter(super.itemView.getContext(), vo.getItemsList(), listener);

            pager.setAdapter(sliderViewPagerAdapter);

            //Necessary or the pager will only have one extra page to show
            // make this at least however many pages you can see
            pager.setOffscreenPageLimit(sliderViewPagerAdapter.getCount());
            //A little space between pages
            pager.setPageMargin(2);
            pager.setCurrentItem(0);
            //If hardware acceleration is enabled, you should also remove
            // clipping on the pager for its children.
            pager.setClipChildren(false);
        }

    }

    private ViewPager getViewPager()
    {
        return (ViewPager) super.itemView.findViewById(R.id.vpSliderPager);
    }
}

