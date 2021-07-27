package com.digiwin.search.service;

import com.alibaba.fastjson.JSON;
import com.digiwin.pojo.Environment;
import com.digiwin.search.dao.ESDao;
import com.digiwin.search.feign.SkuFeign;
import com.digiwin.search.pojo.SkuInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.search.service
 * @ClassName: EsManagerServiceImpl
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/29 10:46
 * @Version: 1.0
 */
@Service
public class EsManagerServiceImpl implements EsManagerService {
    @Autowired
    private ESDao esDao;

    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;

    @Autowired
    private SkuFeign skuFeign;

    @Override
    public void createIndexAndMaping() {
        //1创建索引
        elasticsearchTemplate.createIndex("skuinfo");
        //2创建Maping
        elasticsearchTemplate.putMapping(SkuInfo.class);

    }

    @Override
    public void importDataToEs(Integer id) {
        Environment osById = skuFeign.findOsById(id);
//        System.out.println(osById);
        String osJson = JSON.toJSONString(osById);
        SkuInfo skuInfo = JSON.parseObject(osJson, SkuInfo.class);;
        esDao.save(skuInfo);
    }

}
