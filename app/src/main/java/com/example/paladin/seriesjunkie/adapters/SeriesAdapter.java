package com.example.paladin.seriesjunkie.adapters;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.model.Series;

import java.util.HashMap;
import java.util.List;

/**
 * Created by PaLaDiN on 2016. 05. 22..
 */
public class SeriesAdapter  extends ArrayAdapter<Series> {

    HashMap<Series, Long> mIdMap = new HashMap<Series, Long>();

    public SeriesAdapter(Context context,int textViewResourceId,List<Series> series) {
        super(context, textViewResourceId, series);
        for (int i = 0; i < series.size(); ++i) {
            mIdMap.put(series.get(i), series.get(i).getId());
        }
    }

    @Override
    public long getItemId(int position) {
        Series item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Series serie = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

        convertView = LayoutInflater.from(getContext()).inflate(R.layout.serie_row, parent, false);

        TextView SeriesNameView = (TextView)convertView.findViewById(R.id.name_textView);
        TextView rating = (TextView)convertView.findViewById(R.id.rating_textView);
        TextView SeriesType= (TextView)convertView.findViewById(R.id.type_textView);

        SeriesNameView.setText(serie.getName());
        rating.setText(Math.round(serie.rating*10)/10d+"");
        SeriesType.setText(serie.getType());

        return convertView;
    }
}
