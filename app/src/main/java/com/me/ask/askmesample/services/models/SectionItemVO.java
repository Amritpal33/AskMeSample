package com.me.ask.askmesample.services.models;

import com.me.ask.askmesample.factory.models.ItemVO;

import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Amritpal.Makkar on 07-feb-16.
 */
public class SectionItemVO extends ItemVO
{
    String _itemLabel;
    String _imageUrl;
    String _webUrl;


    public SectionItemVO(JSONObject itemObject) throws JSONException
    {
        _imageUrl = itemObject.getString("image");
        _itemLabel = itemObject.getString("label");
        _webUrl = itemObject.getString("web-url");
    }

    public String getImageUrl()
    {
        return _imageUrl;
    }

    public String getItemLabel()
    {
        return _itemLabel;
    }

    public String getWebUrl()
    {
        return _webUrl;
    }
}
