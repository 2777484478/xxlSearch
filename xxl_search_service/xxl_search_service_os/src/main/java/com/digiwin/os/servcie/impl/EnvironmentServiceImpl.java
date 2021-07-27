package com.digiwin.os.servcie.impl;


import com.digiwin.os.dao.EnvironmentMapper;
import com.digiwin.os.servcie.EnvironmentService;
import com.digiwin.pojo.Environment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.servcie
 * @ClassName: EnvironmentServiceImpl
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/25 17:11
 * @Version: 1.0
 */
@Service
public class EnvironmentServiceImpl implements EnvironmentService {

    @Autowired
    private EnvironmentMapper environmentMapper;
    @Override
    public List<Environment> findAll() {
        return environmentMapper.selectAll();
    }

    @Override
    public Environment findById(Integer id) {
        return environmentMapper.selectByPrimaryKey(id);
    }

    @Override
    public void add(Environment environment) {
//        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
//        String time = format.format(Calendar.getInstance().getTime());
        environment.setCreate_time(new Date());
       environmentMapper.insertSelective(environment);
    }

    @Override
    public void update(Environment environment) {
        environment.setCreate_time(new Date());
        environmentMapper.updateByPrimaryKey(environment);
    }
}
