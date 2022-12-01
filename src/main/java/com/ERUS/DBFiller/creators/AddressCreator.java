package com.ERUS.DBFiller.creators;

import com.ERUS.DBFiller.dataTypes.Address;
import com.ERUS.DBFiller.dataBase.DataBaseAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class AddressCreator implements Creator {

    @Override
    public List<String> generate(int count) {
        DataBaseAccess db = new DataBaseAccess();
        Random random=new Random();
        List<Address> addresses=db.getAddress();
        List<String> values = new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            values.add(addresses.get(random.nextInt(addresses.size())).getCity()+","+
                    addresses.get(random.nextInt(addresses.size())).getStreet()+","+
                    random.nextInt(100)+","+
                    random.nextInt(100));
        }
        return values;
    }
}
