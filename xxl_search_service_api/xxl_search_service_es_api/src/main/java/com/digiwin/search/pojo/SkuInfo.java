package com.digiwin.search.pojo;

import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import javax.persistence.Id;
import java.io.Serializable;
import java.util.Date;
import java.util.Map;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.search.pojo
 * @ClassName: SkuInfo
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/28 17:41
 * @Version: 1.0
 */
//Document文档对象，skuinfo索引库的名字
@Document(indexName = "skuinfo", type = "docs")
public class SkuInfo implements Serializable {
    //空间id，同时也是空间编号
    @Id
    @Field(index = true, store = true, type = FieldType.Keyword)
    private Long id;

    //SKU名称
    @Field(index = true, store = true, type = FieldType.Text, analyzer = "ik_smart")
    private String name;

    //创建时间
    private Date createTime;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }
}
