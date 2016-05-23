package com.example.paladin.seriesjunkie.model;


import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by PaLaDiN on 16/04/24.
 */


public class Series{



    private Long id;

    public String Name;

    public String Story;

    private String Image;

    public double rating;

    public String Type;

    public Series(Long id, String type, double rating, String image, String story, String name) {
        this.id = id;
        Type = type;
        this.rating = rating;
        Image = image;
        Story = story;
        Name = name;
    }

    public Series()
    {
        this.Name= "noname";

    }


    public Series(Long id) {
        this.id = id;
    }

    public Series(String name)
    {

        this.Name= name;

    }

    public void save()
    {
        System.out.println("elment a lidinéni a vásárba  félpénzzel");
    }

    public String getName(){

        return this.Name;
    }

    public String getType()
    {
        return this.Type;
    }

    public long getId()
    {
        return this.id;

    }


    public String getStory() {
        return Story;
    }
}
