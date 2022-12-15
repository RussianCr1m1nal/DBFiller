package com.ERUS.DBFiller.creators;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class SalaryCreator implements Creator{
    Random random=new Random();
    List<String> values=new ArrayList<>();

    @Override
    public List<String> generate(int count) {
        for(int i=0;i<count;i++) {
            double salary = random.nextDouble(10000, 900000);
            values.add(String.valueOf(salary));
        }
        return values;
    }
}
