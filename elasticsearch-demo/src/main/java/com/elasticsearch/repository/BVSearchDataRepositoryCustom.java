package com.elasticsearch.repository;

import com.elasticsearch.document.BVSearchDocument;

import java.util.List;

public interface BVSearchDataRepositoryCustom {

    List<BVSearchDocument> getByFieldName(String filedName);
}
