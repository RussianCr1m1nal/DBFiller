package com.ERUS.DBFiller.creators;

import com.ERUS.DBFiller.dataBase.DataBaseAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NameCreator implements Creator {

    @Override
    public List<String> generate(int count) {
        DataBaseAccess db = new DataBaseAccess();
        Random random=new Random();
        List<String> names=db.getNames();
        List<String> values = new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            values.add(names.get(random.nextInt(names.size())));
        }
        return values;
    }
}
