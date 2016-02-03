package com.me.ask.askmesample.landing.sections;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.me.ask.askmesample.R;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.holders.CellViewHolder;
import com.me.ask.askmesample.factory.models.ItemVO;
import com.squareup.picasso.Picasso;

/**
 * Created by Amritpal.Makkar on 03-feb-16.
 */
public class NormalCellViewHolder extends CellViewHolder implements View.OnClickListener
{
    public NormalCellViewHolder(View itemView)
    {
        super(itemView);
    }

    @Override
    public void bind(ItemVO itemVO, int position, OnMultiCyclerItemClickListener listener)
    {
        ImageView imageView = getCellImageView();
        Picasso.with(super.itemView.getContext()).load("url").into(imageView);

        getItemNameTextview().setText("");
        getOlderPriceTextView().setText("");
        getNewerPriceTextView().setText("");
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

    }
}
