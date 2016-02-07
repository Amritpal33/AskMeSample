package com.me.ask.askmesample.landing.sections;

import android.support.v4.view.ViewPager;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.LinearLayout;

import com.me.ask.askmesample.R;
import com.me.ask.askmesample.factory.MultiRecyclerViewFactory;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.holders.RowViewHolder;
import com.me.ask.askmesample.factory.models.RowVO;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */

public class SliderRowViewHolder extends RowViewHolder implements ViewPager.OnPageChangeListener
{
    private static final String TAG = SliderRowViewHolder.class.getSimpleName();
    private ViewPager _viewPager;
    private View[] _pagerIndicators;

    public SliderRowViewHolder(View itemView)
    {
        super(itemView);
    }

    @Override
    public void bind(RowVO vo, MultiRecyclerViewFactory factory, OnMultiCyclerItemClickListener listener)
    {

        _viewPager = getViewPager();
        _viewPager.addOnPageChangeListener(this);
        DisplayMetrics metrics = new DisplayMetrics();
        WindowManager manager = (WindowManager) super.itemView.getContext().getSystemService(super.itemView.getContext().WINDOW_SERVICE);
        manager.getDefaultDisplay().getMetrics(metrics);

        ViewGroup.LayoutParams params = _viewPager.getLayoutParams();
        params.width = metrics.widthPixels;
        params.height = metrics.widthPixels * 9 / 16;
        _viewPager.setLayoutParams(params);


        if (_viewPager.getAdapter() == null)
        {
            setupPageIndicators(vo.getItemsList().size());
            SliderViewPagerAdapter sliderViewPagerAdapter = new SliderViewPagerAdapter(super.itemView.getContext(), vo.getItemsList(), listener);

            _viewPager.setAdapter(sliderViewPagerAdapter);

            //Necessary or the pager will only have one extra page to show
            // make this at least however many pages you can see
            _viewPager.setOffscreenPageLimit(sliderViewPagerAdapter.getCount());
            //A little space between pages
            _viewPager.setPageMargin(2);
            _viewPager.setCurrentItem(0);
            //If hardware acceleration is enabled, you should also remove
            // clipping on the pager for its children.
            _viewPager.setClipChildren(false);
        }

    }

    private ViewPager getViewPager()
    {
        return (ViewPager) super.itemView.findViewById(R.id.vpSliderPager);
    }

    private LinearLayout getPagerIndicatorLayout()
    {
        return (LinearLayout) super.itemView.findViewById(R.id.containerSliderIndicator);
    }


    public void setupPageIndicators(int count)
    {
        if (count == 0)
        {
            return;
        }

        LinearLayout pageIndicatorContainer = getPagerIndicatorLayout();
        pageIndicatorContainer.removeAllViews();
        _pagerIndicators = new View[count];
        for (int i = 0; i < _pagerIndicators.length; i++)
        {
            _pagerIndicators[i] = LayoutInflater.from(super.itemView.getContext()).inflate(R.layout.slider_indicator, pageIndicatorContainer, false);
            pageIndicatorContainer.addView(_pagerIndicators[i]);

        }

        _pagerIndicators[_viewPager.getCurrentItem()].setBackgroundResource(R.drawable.slider_page_indicator_active);
        pageIndicatorContainer.invalidate();
    }

    /**
     * This method will be invoked when the current page is scrolled, either as part
     * of a programmatically initiated smooth scroll or a user initiated touch scroll.
     *
     * @param position             Position index of the first page currently being displayed.
     *                             Page position+1 will be visible if positionOffset is nonzero.
     * @param positionOffset       Value from [0, 1) indicating the offset from the page at position.
     * @param positionOffsetPixels Value in pixels indicating the offset from position.
     */
    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels)
    {

    }

    /**
     * This method will be invoked when a new page becomes selected. Animation is not
     * necessarily complete.
     *
     * @param position Position index of the new selected page.
     */
    @Override
    public void onPageSelected(int position)
    {

        if (_viewPager.getAdapter().getCount() == 0)
        {
            return;
        }
        for (int i = 0; i < _viewPager.getAdapter().getCount(); i++)
        {
            if (i == position)
            {
                _pagerIndicators[i].setBackgroundResource(R.drawable.slider_page_indicator_active);
            }
            else
            {
                _pagerIndicators[i].setBackgroundResource(R.drawable.slider_page_indicator_inactive);
            }
        }

    }

    /**
     * Called when the scroll state changes. Useful for discovering when the user
     * begins dragging, when the pager is automatically settling to the current page,
     * or when it is fully stopped/idle.
     *
     * @param state The new scroll state.
     * @see ViewPager#SCROLL_STATE_IDLE
     * @see ViewPager#SCROLL_STATE_DRAGGING
     * @see ViewPager#SCROLL_STATE_SETTLING
     */
    @Override
    public void onPageScrollStateChanged(int state)
    {

    }
}

