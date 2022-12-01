package com.ERUS.DBFiller.creators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PhoneCreator implements Creator{
    @Override
    public List<String> generate(int count) {
        Random random=new Random();
        List<String> values=new ArrayList<>();
        String number="+79";
        for(int i=0;i<count;i++) {
            for (int j = 0; j < 9; j++)
            {
                int num = random.nextInt(0, 9);
                number += num;
            }
            values.add(number);
        }
        return values;
    }
}
