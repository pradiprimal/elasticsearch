package com.elasticsearch.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BVSearchDTO {
    private String fieldPath;
    private String fieldValue;
}
