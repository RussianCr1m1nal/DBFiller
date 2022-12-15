package com.ERUS.DBFiller.creators;

import com.ERUS.DBFiller.dataBase.DataBaseAccess;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class PostCreator implements Creator{
    @Override
    public List<String> generate(int count) {
        DataBaseAccess db = new DataBaseAccess();
        Random random=new Random();
        List<String> post=db.getPosts();
        List<String> values = new ArrayList<>();
        for(int i=0;i<count;i++)
        {
            values.add(post.get(random.nextInt(post.size())));
        }
        return values;
    }
}
