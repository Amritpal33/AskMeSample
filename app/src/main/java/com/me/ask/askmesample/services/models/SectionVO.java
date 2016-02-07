package com.me.ask.askmesample.services.models;

import com.me.ask.askmesample.factory.models.DataList;
import com.me.ask.askmesample.factory.models.ItemVO;
import com.me.ask.askmesample.factory.models.RowVO;

/**
 * Created by Amritpal.Makkar on 07-feb-16.
 */
public class SectionVO extends RowVO
{
    private String _imageUrl;

    public SectionVO(String displayTitle, DataList<ItemVO> cellDataList, int rowType, String imageUrl)
    {
        super(displayTitle, cellDataList, rowType);
        _imageUrl = imageUrl;
    }

    public String getImageUrl()
    {
        return _imageUrl;
    }
}
