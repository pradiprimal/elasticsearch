package com.elasticsearch.service;

import com.elasticsearch.document.BVSearchDocument;
import com.elasticsearch.dto.BVSearchDTO;
import org.springframework.data.domain.Page;

public interface BVSearchService {

    Page<BVSearchDocument> searchBvData(BVSearchDTO bvSearchDTO);
}
