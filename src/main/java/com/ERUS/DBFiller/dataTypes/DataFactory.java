package com.ERUS.DBFiller.dataTypes;

import com.ERUS.DBFiller.creators.*;

public class DataFactory {
    public Creator getCreator(DataType type) {

        return switch (type) {
            case DATE -> new DateCreator();
            case ADDRESS -> new AddressCreator();
            case FAMILY -> new FamilyCreator();
            case NAME -> new NameCreator();
            case PATRONYMIC -> new PatronymicCreator();
            case PHONE -> new PhoneCreator();
            default -> null;
        };
    }
}
