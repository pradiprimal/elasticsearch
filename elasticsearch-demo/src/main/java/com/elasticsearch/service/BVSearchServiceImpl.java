package com.elasticsearch.service;

import com.elasticsearch.document.BVSearchDocument;
import com.elasticsearch.dto.BVSearchDTO;
import com.elasticsearch.repository.BVSearchDataRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.stereotype.Service;

import static org.elasticsearch.index.query.QueryBuilders.matchQuery;

@Service
public class BVSearchServiceImpl implements BVSearchService {

    private final BVSearchDataRepository bvSearchDataRepository;

    @Autowired
    public BVSearchServiceImpl(BVSearchDataRepository bvSearchDataRepository) {
        this.bvSearchDataRepository = bvSearchDataRepository;
    }

    @Override
    public Page<BVSearchDocument> searchBvData(BVSearchDTO bvSearchDTO) {
        SearchQuery searchQuery = new NativeSearchQueryBuilder()
                .withQuery(matchQuery(bvSearchDTO.getFieldPath(), bvSearchDTO.getFieldValue()))
                .build();
        return bvSearchDataRepository.search(searchQuery);
    }
}
