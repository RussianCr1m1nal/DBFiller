package com.ERUS.DBFiller.creators;

import com.ERUS.DBFiller.dataBase.DataBaseAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PatronymicCreator implements Creator {

    @Override
    public List<String> generate(int count) {
        DataBaseAccess db = new DataBaseAccess();
        Random random=new Random();
        List<String> patronymics=db.getPatronymics();
        List<String> values = new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            values.add(patronymics.get(random.nextInt(patronymics.size())));
        }
        return values;
    }
}
