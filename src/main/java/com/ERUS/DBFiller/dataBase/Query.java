package com.ERUS.DBFiller.dataBase;

import com.ERUS.DBFiller.dataTypes.DataFactory;
import com.ERUS.DBFiller.dataTypes.DataType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.*;

public class Query {
    String Table;
    ArrayList<String> Values=new ArrayList<>();
    ArrayList<HashMap<String,String>> rows =new ArrayList<>();

    public String createValues(int count,String attributes,String dbtype,String table) {
        List<String> attrs = new ArrayList<>(Arrays.stream(attributes.split(" ")).toList());
        Table = table;
        for (int i=0;i<count;i++) {
            int k=0;
            HashMap<String,String> columns = new HashMap<>();
            for (String attr : attrs) {
                k++;
                String attr1=attr;
                if(columns.containsKey(attr))
                    attr1=attr1+k;
                columns.put(attr1, generateValue(attr));
            }
            rows.add(columns);
        }
        valuesToQuery(rows);
        saveJSON();
        DBTYPE type = switch (dbtype) {
            case "1С" -> DBTYPE._1C;
            default -> DBTYPE.SQL;
        };
        return getQuery(type);
    }

    private void saveJSON() {
        QueryObject query = new QueryObject();
        query.table = Table;
        query.values =  rows;
        ObjectMapper mapper = new ObjectMapper();
        mapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        try {
            // Writing to a file
            mapper.writeValue(new File("c:\\query.json"), query);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void valuesToQuery(List<HashMap<String,String>> rows)
    {
        StringBuilder value;
        for (HashMap<String,String> row: rows) {
            value =new StringBuilder();
            for(Map.Entry<String, String> entry:row.entrySet()) {
                value.append("'").append(entry.getValue()).append("'");
                value.append(",");
            }
            value.deleteCharAt(value.length()-1);
            Values.add(value.toString());
        }
    }
    private String generateValue(String attribute)
    {
        String value= "";
        DataFactory factory=new DataFactory();
        switch (attribute) {
            case "name" -> value = factory.getCreator(DataType.NAME).generate(1).get(0);
            case "family" -> value = factory.getCreator(DataType.FAMILY).generate(1).get(0);
            case "patronymic" -> value=factory.getCreator(DataType.PATRONYMIC).generate(1).get(0);
            case "phone" -> value=factory.getCreator(DataType.PHONE).generate(1).get(0);
            case "address" -> value=factory.getCreator(DataType.ADDRESS).generate(1).get(0);
            case "date" -> value=factory.getCreator(DataType.DATE).generate(1).get(0);
            case "post" -> value=factory.getCreator(DataType.POST).generate(1).get(0);
            case "salary" -> value=factory.getCreator(DataType.SALARY).generate(1).get(0);
            case "station" -> value=factory.getCreator(DataType.STATION).generate(1).get(0);
            case "num" -> value=factory.getCreator(DataType.NUMBER).generate(1).get(0);
            case "time" -> value=factory.getCreator(DataType.TIME).generate(1).get(0);
        }

        return value;
    }
    private String getQuery(DBTYPE dbtype)
    {
        StringBuilder query= new StringBuilder();
        for (String stroke: Values) {
            switch (dbtype) {
                case SQL ->  query.append("insert into '").append(Table).append("' values(").append(stroke).append(");\n");
                case _1C ->  query.append("ВСТАВИТЬ В '").append(Table).append("' ЗНАЧЕНИЯ(").append(stroke).append(");\n");
            }
        }

        return query.toString();
    }
}
