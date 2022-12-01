package com.ERUS.DBFiller.creators;

import com.ERUS.DBFiller.dataBase.DataBaseAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class FamilyCreator implements Creator {

    @Override
    public List<String> generate(int count) {
        DataBaseAccess db = new DataBaseAccess();
        Random random=new Random();
        List<String> families=db.getFamilies();
        List<String> values = new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            values.add(families.get(random.nextInt(families.size())));
        }
        return values;
    }
}
