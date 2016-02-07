package com.me.ask.askmesample.landing.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.me.ask.askmesample.R;
import com.me.ask.askmesample.factory.MultiRecycler;
import com.me.ask.askmesample.factory.OnMultiCyclerItemClickListener;
import com.me.ask.askmesample.factory.models.ItemVO;
import com.me.ask.askmesample.landing.sections.AskMeLayoutFactory;
import com.me.ask.askmesample.services.DataFetcher;
import com.me.ask.askmesample.services.iDataProcessingListener;
import com.me.ask.askmesample.services.models.SectionItemVO;
import com.me.ask.askmesample.services.processors.SectionDataProcessor;
import com.me.ask.askmesample.services.processors.iSectionDataProcessor;

/**
 * A placeholder fragment containing a simple view.
 */
public class MainActivityFragment extends Fragment implements iDataProcessingListener, OnMultiCyclerItemClickListener
{
    private MultiRecycler _recycler;

    public MainActivityFragment()
    {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState)
    {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState)
    {
        super.onViewCreated(view, savedInstanceState);
        _recycler = (MultiRecycler) getView().findViewById(R.id.containerRecylerView);
        _recycler.setMultiCyclerData(new AskMeLayoutFactory(), this);
        fetchData("f_one.json");
        //fetchData("f_two.json");
    }

    private void fetchData(String fileName)
    {
        DataFetcher.getInstance().fetchData(getActivity(), fileName, new SectionDataProcessor(), this);
    }

    @Override
    public void onDataProcessingSuccess(iSectionDataProcessor sectionDataProcessor)
    {
        if(sectionDataProcessor instanceof SectionDataProcessor)
        {
            if(_recycler!=null)
            {
                _recycler.getRows().clear();
                _recycler.getRows().addAll(((SectionDataProcessor) sectionDataProcessor).getDataList());
            }
        }
    }

    @Override
    public void onDataProcessingError()
    {
        //We can show suitable Error screens or show Toast Messages here.
    }

    @Override
    public void onMultiCyclerItemClick(View view, ItemVO itemVO)
    {
        Toast.makeText(getActivity(),((SectionItemVO)itemVO).getItemLabel()+" clicked",Toast.LENGTH_SHORT).show();
    }
}
