package com.ERUS.DBFiller.dataBase;

public class Cell {
    public String value;
    public String key;

    public Cell(String attr, String generateValue) {
        this.key=attr;
        this.value=generateValue;
    }
}
