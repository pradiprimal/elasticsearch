package com.elasticsearch.repository;

import com.elasticsearch.document.BVSearchDocument;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Repository;

import java.util.List;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Repository
public class BVSearchDataRepositoryImpl implements BVSearchDataRepositoryCustom {

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Override
    public List<BVSearchDocument> getByFieldName(String filedName) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery(filedName, "300"))
                .build();
        return elasticsearchTemplate.queryForList(searchQuery, BVSearchDocument.class);
    }
}
