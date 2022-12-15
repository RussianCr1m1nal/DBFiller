package com.ERUS.DBFiller.creators;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class TimeCreator implements Creator{
    @Override
    public List<String> generate(int count) {
        Random random=new Random();
        List<String> values=new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            int hours=random.nextInt(0,24);
            int minutes=random.nextInt(0,59);
            int seconds=random.nextInt(0,59);
            values.add(Time.valueOf(LocalTime.of(hours,minutes,seconds)).toString());
        }
        return values;
    }
}
