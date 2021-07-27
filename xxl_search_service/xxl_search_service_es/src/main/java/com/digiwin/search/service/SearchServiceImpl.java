package com.digiwin.search.service;

import com.alibaba.fastjson.JSON;
import com.digiwin.search.pojo.SkuInfo;
import org.apache.commons.lang.StringUtils;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.common.text.Text;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.Operator;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.elasticsearch.search.SearchHit;
import org.elasticsearch.search.SearchHits;
import org.elasticsearch.search.fetch.subphase.highlight.HighlightBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.data.elasticsearch.core.SearchResultMapper;
import org.springframework.data.elasticsearch.core.aggregation.AggregatedPage;
import org.springframework.data.elasticsearch.core.aggregation.impl.AggregatedPageImpl;
import org.springframework.data.elasticsearch.core.query.NativeSearchQueryBuilder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.search.service
 * @ClassName: SearchServiceImpl
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/30 14:13
 * @Version: 1.0
 */
@Service
public class SearchServiceImpl implements SearchService {
    @Autowired
    private ElasticsearchTemplate esTemplate;

    @Override
    public Map search(Map<String, String> searchMap) {
        if(searchMap == null || searchMap.size() == 0){
            return null;
        }

        Map<String, Object> resultMap = new HashMap<>();
        String keywords = searchMap.get("keywords");
//        String pageNum = searchMap.get("pageNum");
//        if (StringUtils.isEmpty(pageNum)) {
//            searchMap.put("pageNum", "1");
//            pageNum = "1";
//        }
        //封装查询对象
        NativeSearchQueryBuilder nativeSearchQueryBuilder = new NativeSearchQueryBuilder();
        BoolQueryBuilder boolQueryBuilder = QueryBuilders.boolQuery();
        if (!StringUtils.isEmpty(keywords)) {
            //应该, 是or或者的意思
            //boolQueryBuilder.should();
            //非, not的意思
            //boolQueryBuilder.mustNot();
            //必须, 相当于and的意思
            //QueryBuilders.matchQuery是将查询的关键字根据指定的分词器切分词后, 将切分出来的词一个一个查询,
            //将查询到的结果组合到一起返回
            //operator(Operator.AND)是控制切分词后, 根据每个词查询出来结果, 这些结果组合在一块返回的关系
//            boolQueryBuilder.must(QueryBuilders.matchQuery("name", keywords).operator(Operator.AND));
//            boolQueryBuilder.must(QueryBuilders.multiMatchQuery
//                    (keywords,"name","api_adress",
//                            "kefu_adress",
//                            "aieoms_adress",
//                            "aiossmweb_adress",
//                            "esitms_adress",
//                            "esom_adress",
//                            "esomitms_adress",
//                            "tcloud_adress",
//                            "scpweb_adress",
//                            "fanruan_adress",
//                            "a1webgz_adress",
//                            "desktop_adress",
//                            "openfire_adress",
//                            "a1openfire_adress",
//                            "mgo_adress",
//                            "rmq_adress",
//                            "reds_adress",
//                            "pinpoin_adress",
//                            "apm_adress",
//                            "log_adress",
//                            "data_adress",
//                            "youhuo_adress"
//                    )
//                    .operator(Operator.AND));
            boolQueryBuilder.must(QueryBuilders.matchQuery("name", keywords).operator(Operator.AND));
            nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        }

        /**
         *
         * 高亮查询
         */

        HighlightBuilder.Field higntLightField = new HighlightBuilder.Field("name").preTags("<em style=\"color:red;font-style: normal;font-size: large;\">").postTags("</em>").numOfFragments(0);
        nativeSearchQueryBuilder.withHighlightFields(higntLightField);


        /**
         * 查询并返回结果集(包含高亮)
         */
        //将组合查询对象放入顶级查询对象中
        nativeSearchQueryBuilder.withQuery(boolQueryBuilder);
        AggregatedPage<SkuInfo> skuInfos = esTemplate.queryForPage(nativeSearchQueryBuilder.build(), SkuInfo.class, new SearchResultMapper() {

            //在这里重新组合查询结果, 将高亮名称获取到放入结果集中
            @Override
            public <T> AggregatedPage<T> mapResults(SearchResponse searchResponse, Class<T> aClass, Pageable pageable) {

                List<T> resultList = new ArrayList<>();
                //从查询的响应中获取查询结果对象
                SearchHits hits = searchResponse.getHits();
                if (hits != null) {
                    //查询到的结果集
                    SearchHit[] hitArray = hits.getHits();
                    if (hitArray.length > 0) {
                        for (SearchHit searchHit : hitArray) {
                            //获取数据json格式字符串(这个结果中名字是不带高亮的)
                            String skuInfoJsonStr = searchHit.getSourceAsString();
                            //将skuInfo的json字符串转换成skuInfo对象
                            SkuInfo skuInfo = JSON.parseObject(skuInfoJsonStr, SkuInfo.class);
                            /**
                             * 获取高亮名称
                             * 高亮名称如果能够获取到, 则获取出来放入SkuInfo对象中的name属性中
                             * 如果获取不到高亮名称则使用SkuInfo对象中原有的不带高亮的名称
                             */
                            if (searchHit.getHighlightFields() != null && searchHit.getHighlightFields().size() > 0) {
                                Text[] names = searchHit.getHighlightFields().get("name").fragments();
                                skuInfo.setName(names[0].toString());
                            }
                            //将这个对象放入返回的结果集中
                            resultList.add((T) skuInfo);
                        }
                    }
                }

                return new AggregatedPageImpl<T>(resultList, pageable, hits.getTotalHits(), searchResponse.getAggregations());
            }
        });

        //封装查询结果后返回
        //当前页
//        resultMap.put("pageNum", pageNum);
        //查询返回的结果集
        resultMap.put("rows", skuInfos.getContent());
        //总页数
        resultMap.put("totalPages", skuInfos.getTotalPages());
        //查询到的中条数
        resultMap.put("total", skuInfos.getTotalElements());

        return resultMap;
    }
}
