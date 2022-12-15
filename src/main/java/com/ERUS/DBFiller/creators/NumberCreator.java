package com.ERUS.DBFiller.creators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class NumberCreator implements Creator{
    Random random=new Random();
    List<String> values=new ArrayList<>();

    @Override
    public List<String> generate(int count) {
        for(int i=0;i<count;i++) {
            double number = random.nextInt(1,1000);
            values.add(String.valueOf(number));
        }
        return values;
    }
}
