package com.digiwin.os.servcie;

import com.digiwin.pojo.Environment;

import java.util.List;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.servcie
 * @ClassName: EnvironmentService
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/25 17:08
 * @Version: 1.0
 */
public interface EnvironmentService {
    public List<Environment> findAll();
    public Environment findById(Integer id);
    public void add(Environment environment);
    public void update(Environment environment);
}
