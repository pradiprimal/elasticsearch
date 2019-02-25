package com.elasticsearch.repository;

import com.elasticsearch.document.BVSearchDocument;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BVSearchDataRepository extends ElasticsearchRepository<BVSearchDocument, String>,BVSearchDataRepositoryCustom {
}
