package com.digiwin.search.dao;

import com.digiwin.search.pojo.SkuInfo;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.search.dao
 * @ClassName: ESDao
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/29 10:42
 * @Version: 1.0
 */
public interface ESDao extends ElasticsearchRepository<SkuInfo,Long> {
}
