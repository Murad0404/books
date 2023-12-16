package org.example.db;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
@Component
@Data
public class Database_Util {


    @Autowired
    private JdbcTemplate jdbcTemplate;
    public void createTable() {
        String sql = "   create table if not exists words(" +
                "        id serial  primary key," +
                "        wordUz  varchar(25) not null," +
                "        wordEng varchar(25) not null," +
                "        description text " +
                "      );";
        jdbcTemplate.execute(sql);
    }
}
