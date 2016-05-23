package com.example.paladin.seriesjunkie.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PaLaDiN on 2016. 05. 23..
 */
public class EpisodeDB {


    private static List<Episodes> episodes=new ArrayList<Episodes>();


    public EpisodeDB() {

        if(episodes.size()==0) {
            episodes.add(new Episodes(1l, 1l, 1, "1.episode title", "first desc"));
            episodes.add(new Episodes(2l, 1l, 2, "2.episode title", "second desc"));
            episodes.add(new Episodes(3l, 1l, 3, "3.episode title", "second desc"));
            episodes.add(new Episodes(4l, 2l, 1, "1.episode title", "first desc"));
            episodes.add(new Episodes(5l, 3l, 1, "1.episode title", "first desc"));
            episodes.add(new Episodes(6l, 4l, 1, "1.episode title", "first desc"));
            episodes.add(new Episodes(7l, 5l, 1, "1.episode title", "first desc"));
            episodes.add(new Episodes(8l, 6l, 1, "1.episode title", "first desc"));

        }
    }

    public List<Episodes> getEpisodes(int serieID) {

        List<Episodes>result= new ArrayList<Episodes>();

        for (Episodes ep:episodes) {
            if(ep.getSerieId()== serieID)
            {
                result.add(ep);
            }
        }

        return result;


    }

    public Episodes getEpisode(long id) {

        for (Episodes ep:episodes) {
            if((int)(ep.getId()-id)==0)
                return ep;
        }
        return null;
    }
}
