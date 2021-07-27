package com.digiwin.search.service;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.search.service
 * @ClassName: EsManagerService
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/29 10:45
 * @Version: 1.0
 */
public interface EsManagerService {
    public void createIndexAndMaping();
    public void importDataToEs(Integer id);
}
