package com.ERUS.DBFiller.creators;

import com.ERUS.DBFiller.dataBase.DataBaseAccess;
import com.ERUS.DBFiller.dataTypes.Address;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class StationCreator implements Creator{
    @Override
    public List<String> generate(int count) {
        DataBaseAccess db = new DataBaseAccess();
        Random random=new Random();
        List<Address> addresses=db.getAddress();
        List<String> values = new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            values.add(addresses.get(random.nextInt(addresses.size())).getCity());
        }
        return values;
    }
}
