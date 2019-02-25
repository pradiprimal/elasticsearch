package com.elasticsearch.controller;

import com.elasticsearch.document.BVSearchDocument;
import com.elasticsearch.dto.BVSearchDTO;
import com.elasticsearch.service.BVSearchService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.BufferedReader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@RestController
@RequestMapping("api/search")
public class BVSearchController {
    private static final Logger LOGGER = LoggerFactory.getLogger("jsonLogger");


    private final BVSearchService bvSearchService;

    @Autowired
    public BVSearchController(BVSearchService bvSearchService) {
        this.bvSearchService = bvSearchService;
    }

    @PostMapping
    public Page<BVSearchDocument> searchBv(@RequestBody BVSearchDTO bvSearchDTO) {
        return bvSearchService.searchBvData(bvSearchDTO);
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
