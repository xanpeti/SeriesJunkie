package com.example.paladin.seriesjunkie.model;


import com.orm.SugarRecord;
import com.orm.dsl.Table;

import java.util.List;

/**
 * Created by PaLaDiN on 16/04/24.
 */


public class Series{

    public String Name;

    public List<Episodes> episodes;

    public Series()
    {
        this.Name= "noname";

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


}
