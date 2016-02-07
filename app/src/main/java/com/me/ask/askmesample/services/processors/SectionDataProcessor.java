package com.me.ask.askmesample.services.processors;

import com.me.ask.askmesample.factory.models.DataList;
import com.me.ask.askmesample.factory.models.ItemVO;
import com.me.ask.askmesample.factory.models.RowVO;
import com.me.ask.askmesample.landing.sections.AskMeLayoutFactory;
import com.me.ask.askmesample.services.models.SectionItemVO;
import com.me.ask.askmesample.services.models.SectionVO;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/**
 * Created by Amritpal.Makkar on 04-feb-16.
 */
public class SectionDataProcessor implements iSectionDataProcessor
{
    DataList<RowVO> _dataList;

    public SectionDataProcessor()
    {
        _dataList = new DataList<>();
    }

    @Override
    public boolean parseData(Object responseObject)
    {
        if (responseObject == null)
        {
            return false;
        }

        try
        {
            JSONArray jsonArray = new JSONArray((String) responseObject);
            for (int i = 0; i < jsonArray.length(); i++)
            {
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                JSONArray itemsArray = jsonObject.optJSONArray("items");
                DataList<ItemVO> itemVOs = new DataList<>();
                if (itemsArray != null)
                {
                    for (int j = 0; j < itemsArray.length(); j++)
                    {
                        ItemVO itemVO = new SectionItemVO(itemsArray.optJSONObject(j));
                        itemVOs.add(itemVO);
                    }
                }
                SectionVO sectionVO = new SectionVO(jsonObject.optString("label"), itemVOs, getTemplateType(jsonObject.optString("template")), jsonObject.optString("image"));
                _dataList.add(sectionVO);
            }

            return true;
        }
        catch (JSONException e)
        {
            return false;
        }
    }

    private int getTemplateType(String templateString)
    {
        if (templateString.equalsIgnoreCase("product-template-1"))
        {
            return AskMeLayoutFactory.LayoutType.LAYOUT_SINGLE_POSTER.getCode();
        }
        else if (templateString.equalsIgnoreCase("product-template-3"))
        {
            return AskMeLayoutFactory.LayoutType.LAYOUT_VIEW_PAGER.getCode();
        }

        return AskMeLayoutFactory.LayoutType.LAYOUT_TYPE_NORMAL.getCode();//product-template-2
    }

    public DataList<RowVO> getDataList()
    {
        return _dataList;
    }
}

