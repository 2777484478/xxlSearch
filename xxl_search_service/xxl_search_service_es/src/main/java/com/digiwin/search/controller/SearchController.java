package com.digiwin.search.controller;

import com.alibaba.fastjson.JSON;
import com.digiwin.entity.Result;
import com.digiwin.entity.StatusCode;
import com.digiwin.pojo.Environment;
import com.digiwin.search.pojo.SkuInfo;
import com.digiwin.search.service.SearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.search.controller
 * @ClassName: SearchController
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/30 13:58
 * @Version: 1.0
 */
@RestController
@RequestMapping("/search")
public class SearchController {
    @Autowired
    private SearchService searchService;

    @GetMapping
    @CrossOrigin
    public Result search(@RequestParam Map<String,String> searchMap){
        String keywords = searchMap.get("keywords");

//        Map<String,String> LastMap = new HashMap();
//        List list = new ArrayList();
        Map resultMap = searchService.search(searchMap);
        List<SkuInfo> rows = (List<SkuInfo>) resultMap.get("rows");
//        for (SkuInfo skuInfo: rows
//             ) {
//            Map<Object,String> map = JSON.parseObject(JSON.toJSONString(skuInfo),Map.class);
//            map.remove("createTime");
//            map.remove("id");
//            for (String value: map.values()
//            ){
//                if (value.contains(keywords)){
////                    LastMap.put("result_data" ,value);
//                    list.add(value);
//                }
//            }
//            }
        return new Result(true,StatusCode.OK,"ok",rows);
    }
}
