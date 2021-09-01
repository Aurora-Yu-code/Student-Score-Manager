package com.scores.demo.domain;

import com.scores.demo.dto.CourseScore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.io.Serializable;
import java.util.List;

/**
 * 搜索中的成绩信息
 */
@Data
@EqualsAndHashCode(callSuper = false)
//Document标示映射到Elasticsearch文档上的领域对象
@Document(indexName="score",type="EsScore",shards=1,replicas=0)
public class EsScore implements Serializable {
    private static final long serialVersionUID = -1L;
    @Id
    private Long id;
    @Field(type = FieldType.Keyword)
    private String number;
    @Field
    private String name;
    @Field
    private Integer type;
    @Field
    private String chinese;
    @Field
    private String math;
    @Field
    private String english;
}
