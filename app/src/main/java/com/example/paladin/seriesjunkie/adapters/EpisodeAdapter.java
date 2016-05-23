package com.example.paladin.seriesjunkie.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.example.paladin.seriesjunkie.R;
import com.example.paladin.seriesjunkie.model.Episodes;
import com.example.paladin.seriesjunkie.model.Series;

import java.util.HashMap;
import java.util.List;

/**
 * Created by PaLaDiN on 2016. 05. 23..
 */
public class EpisodeAdapter  extends ArrayAdapter<Episodes> {


    HashMap<Episodes, Long> mIdMap = new HashMap<Episodes, Long>();

    public EpisodeAdapter(Context context, int resource, List<Episodes> objects) {
        super(context, resource, objects);
        for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), objects.get(i).getId());
        }
    }


    @Override
    public long getItemId(int position) {
        Episodes item = getItem(position);
        return mIdMap.get(item);
    }

    @Override
    public boolean hasStableIds() {
        return true;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        // Get the data item for this position
        Episodes ep = getItem(position);
        // Check if an existing view is being reused, otherwise inflate the view

            convertView = LayoutInflater.from(getContext()).inflate(R.layout.episode_row, parent, false);

        TextView episodetitletextview = (TextView)convertView.findViewById(R.id.EpisodeTitle_textView);
        TextView number = (TextView)convertView.findViewById(R.id.number_textview);


        episodetitletextview.setText(ep.getTitle());
        number.setText(ep.getNumber()+"");


        return convertView;
    }
}
