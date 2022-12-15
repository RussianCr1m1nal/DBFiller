package com.ERUS.DBFiller.dataBase;

import com.ERUS.DBFiller.dataTypes.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import java.util.List;

public class DataBaseAccess{
    @Autowired
    private final JdbcTemplate jdbcTemplate;
    @Autowired
    private Environment env;
    public DataBaseAccess(){
        DriverManagerDataSource ds = new DriverManagerDataSource();
        ds.setDriverClassName("com.mysql.cj.jdbc.Driver");
        ds.setUrl("jdbc:mysql://127.0.0.1:3306/fillers");
        ds.setUsername("root");
        jdbcTemplate = new JdbcTemplate(ds);
    }

    public List<String> getNames() {
        return jdbcTemplate.queryForList("select name from fillers",  String.class);
    }
    public List<String> getFamilies() {
        return jdbcTemplate.queryForList("select family from fillers",  String.class);
    }
    public List<String> getPatronymics() {
        return jdbcTemplate.queryForList("select patronymic from fillers",  String.class);
    }
    public List<Address> getAddress() {
        return jdbcTemplate.query("select city,street from fillers", (rs, rowNum) ->
                new Address(
                        rs.getString("city"),
                        rs.getString("street")
                ));
    }

    public List<String> getPosts() {
        return jdbcTemplate.queryForList("select post from fillers",  String.class);
    }
}
