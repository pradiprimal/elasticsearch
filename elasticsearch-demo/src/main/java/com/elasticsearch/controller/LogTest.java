package com.elasticsearch.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("test")
public class LogTest {
    Logger logger = LoggerFactory.getLogger("jsonLogger");

    @GetMapping
    public String test() {
        logger.info(readJsonFile());
        return readJsonFile();
    }


    private String readJsonFile() {
        StringBuilder stringBuilder = new StringBuilder();
        List<String> lists = new ArrayList<>();

        try (BufferedReader br = Files.newBufferedReader(Paths.get(getClass().getClassLoader().getResource("coverage_response_01.json").toURI()))) {
            lists = br.lines().collect(Collectors.toList());
        } catch (Exception e) {
        }
        lists.forEach(s -> stringBuilder.append(s));
        return stringBuilder.toString();
    }


}
