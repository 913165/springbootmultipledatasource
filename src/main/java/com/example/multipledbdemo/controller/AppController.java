package com.example.multipledbdemo.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.mysql.cj.xdevapi.JsonArray;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.DataSource;

@RestController
public class AppController {

    @Autowired
    @Qualifier("dataSource1")
    DataSource dataSource1;

    @Autowired
    @Qualifier("dataSource2")
    DataSource dataSource2;

    @GetMapping("/users")
    public String users()  {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource1);
        String sql = "SELECT * FROM users";
        return jdbcTemplate.queryForList(sql).toString();
    }

    @GetMapping("/products")
    public String products() {
        JdbcTemplate jdbcTemplate = new JdbcTemplate(dataSource2);
        String sql = "SELECT * FROM products";
        return jdbcTemplate.queryForList(sql).toString();
    }
}
