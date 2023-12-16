package org.example.repository;


import org.example.dto.Word;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.*;

@Repository
public class WordRepository {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    @Autowired
    private NamedParameterJdbcTemplate namedParameterJdbcTemplate;

    public void create(Word word) {
        String sql = "insert into words(worduz,wordeng,description) values(:worduz,:wordeng,:description)";
        Map<String, String> stringObjectsMap = new HashMap<>();
        stringObjectsMap.put("worduz", word.getWordUz());
        stringObjectsMap.put("wordeng", word.getWordEng());
        stringObjectsMap.put("description", word.getDescription());
        namedParameterJdbcTemplate.update(sql, stringObjectsMap);
    }

    public List<Word> getAll() {
        String sql = "select * from words";
        List<Word> dtoList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Word.class));
        return dtoList;
    }
   /** public List<String> getByIdWordeng() {
        String sql = "select wordeng from words WHERE id = "+ new Random().nextInt(getAll().size());
        List<String> dtoList = jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(String.class));
        return dtoList;
    }*/
    public Word getById(Integer id) {
        String sql = "select * from words WHERE id = "+id + " limit 1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Word.class)).get(0);
    }

    public Word getByWord(String worduz) {
        String sql = "select * from words where wordeng like "+"'"+worduz+"'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Word.class)).get(0);
    }

    public Word getByWorduzAndWordeng(String worduz) {
        String sql = "select * from words where wordeng = "+"'"+worduz+"'"+" or "+"worduz = "+"'"+worduz+"'";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Word.class)).get(0);
    }

    public Word getByIdtest(Integer id) {
        String sql = "select * from words WHERE id = "+id + " limit 1";
        return jdbcTemplate.query(sql, new BeanPropertyRowMapper<>(Word.class)).get(0);
    }


}
