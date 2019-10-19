package com.elastic.entity;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

/**
 * 测试物品
 * @author 杨鹏
 */
@Data
@Document(indexName = "item",type = "docs", shards = 5, replicas = 1)
public class Item {

    /**
     *@Id注解必须是springframework包下的org.springframework.data.annotation.Id
     */
    @Id
    private Long id;
    /**
     * 标题
     */
    @Field(type = FieldType.Text, analyzer = "ik_max_word")
    private String title;
    /**
     * 分类
     */
    @Field(type = FieldType.Keyword)
    private String category;
    /**
     * 品牌
     */
    @Field(type = FieldType.Keyword)
    private String brand;
    /**
     * 价格
     */
    @Field(type = FieldType.Double)
    private Double price;
    /**
     * 图片地址
     */
    @Field(index = false, type = FieldType.Keyword)
    private String images;
}
