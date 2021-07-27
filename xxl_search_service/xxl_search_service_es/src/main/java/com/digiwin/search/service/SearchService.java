package com.digiwin.search.service;

import java.util.Map;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.search.service
 * @ClassName: SearchService
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/30 14:04
 * @Version: 1.0
 */
public interface SearchService {
    public Map search(Map<String, String> searchMap);
}
