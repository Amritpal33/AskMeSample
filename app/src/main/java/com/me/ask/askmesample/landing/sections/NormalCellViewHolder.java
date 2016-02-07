package com.me.ask.askmesample.landing.sections;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.me.ask.askmesample.R;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.holders.CellViewHolder;
import com.me.ask.askmesample.factory.models.ItemVO;
import com.me.ask.askmesample.services.models.SectionItemVO;
import com.squareup.picasso.Picasso;

import java.lang.ref.WeakReference;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */
public class NormalCellViewHolder extends CellViewHolder implements View.OnClickListener
{
    private WeakReference<OnMultiCyclerItemClickListener> _onMultiCyclerItemClickListener;
    private WeakReference<ItemVO> _itemVO;

    public NormalCellViewHolder(View itemView)
    {
        super(itemView);
    }

    @Override
    public void bind(ItemVO itemVO, int position, OnMultiCyclerItemClickListener listener)
    {
        _onMultiCyclerItemClickListener = new WeakReference<>(listener);
        _itemVO = new WeakReference<>(itemVO);

        ImageView imageView = getCellImageView();
        Picasso.with(super.itemView.getContext()).load(((SectionItemVO) itemVO).getImageUrl()).into(imageView);

        getItemNameTextview().setText(((SectionItemVO) itemVO).getItemLabel());
        getOlderPriceTextView().setText("1100");
        getNewerPriceTextView().setText("899");
        super.itemView.setOnClickListener(this);
    }


    private TextView getItemNameTextview()
    {
        return (TextView) super.itemView.findViewById(R.id.tvItemName);
    }

    private TextView getOlderPriceTextView()
    {
        return (TextView) super.itemView.findViewById(R.id.tvItemOlderPrice);
    }

    protected TextView getNewerPriceTextView()
    {
        return (TextView) super.itemView.findViewById(R.id.tvItemNewerPrice);
    }

    private ImageView getCellImageView()
    {
        return (ImageView) super.itemView.findViewById(R.id.imgCellPoster);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v)
    {
        ItemVO itemVO = _itemVO.get();
        _onMultiCyclerItemClickListener.get().onMultiCyclerItemClick(v, itemVO);
    }
}
