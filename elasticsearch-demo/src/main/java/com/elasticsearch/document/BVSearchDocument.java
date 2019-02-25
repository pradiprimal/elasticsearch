package com.elasticsearch.document;

import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;

import java.util.HashMap;
import java.util.Map;

@Document(indexName = "test", type = "test")
public class BVSearchDocument {


    @Id
    private String userId;
    private Map<String, Object> additionalProperties;
    private Map<String, Object> ebv;

    public Map<String, Object> getEbv() {
        return ebv;
    }

    public void setEbv(Map<String, Object> ebv) {
        this.ebv = ebv;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperties(Map<String, Object> additionalProperties) {
        this.additionalProperties = additionalProperties;
    }
}
