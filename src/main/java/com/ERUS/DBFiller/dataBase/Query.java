package com.ERUS.DBFiller.dataBase;

import com.ERUS.DBFiller.dataTypes.DataFactory;
import com.ERUS.DBFiller.dataTypes.DataType;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Query {
    String Table;
    List<String> Values=new ArrayList<>();

    public String createValues(int count,String attributes,String dbtype,String table) {
        List<String> attrs = new ArrayList<>(Arrays.stream(attributes.split(" ")).toList());
        Table = table;
        for (int i=0;i<count;i++)
            Values.add(generateValues(attrs));
        DBTYPE type = switch (dbtype) {
            case "1С" -> DBTYPE._1C;
            case "SQL" -> DBTYPE.SQL;
            default -> DBTYPE.SQL;
        };
        return getQuery(type);
    }
    private String generateValues(List<String> attributes)
    {
        StringBuilder value= new StringBuilder();
        DataFactory factory=new DataFactory();
        for (String attr: attributes) {
            switch (attr) {
                case "name" -> value.append("'").append(factory.getCreator(DataType.NAME).generate(1).get(0)).append("'");
                case "family" -> value.append("'").append(factory.getCreator(DataType.FAMILY).generate(1).get(0)).append("'");
                case "patronymic" -> value.append("'").append(factory.getCreator(DataType.PATRONYMIC).generate(1).get(0)).append("'");
                case "phone" -> value.append("'").append(factory.getCreator(DataType.PHONE).generate(1).get(0)).append("'");
                case "address" -> value.append("'").append(factory.getCreator(DataType.ADDRESS).generate(1).get(0)).append("'");
                case "date" -> value.append("'").append(factory.getCreator(DataType.DATE).generate(1).get(0)).append("'");
            }
            if (attributes.indexOf(attr)!=attributes.size()-1)
                value.append(",");
        }
        return value.toString();
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
