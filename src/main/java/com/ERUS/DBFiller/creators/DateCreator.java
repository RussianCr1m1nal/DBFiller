package com.ERUS.DBFiller.creators;

import com.ERUS.DBFiller.creators.Creator;

import java.sql.Date;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class DateCreator implements Creator {
    @Override
    public List<String> generate(int count) {
        Random random=new Random();
        List<String> values=new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            int day=random.nextInt(1,31);
            int month=random.nextInt(1,12);
            int year=random.nextInt(1000,3000);
            values.add(Date.valueOf(LocalDate.of(year,month,day)).toString());
        }
        return values;
    }
}
