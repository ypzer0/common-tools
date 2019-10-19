package com.elastic.repository;

import com.elastic.entity.Item;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * 测试物品 Repository
 * @author 杨鹏
 */
public interface ItemRepository extends ElasticsearchRepository<Item,Long> {
}
