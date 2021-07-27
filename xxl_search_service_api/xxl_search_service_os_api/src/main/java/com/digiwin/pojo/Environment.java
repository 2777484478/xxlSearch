package com.digiwin.pojo;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @ProjectName: xxl_search
 * @Package: com.digiwin.pojo
 * @ClassName: Environment
 * @Author: Administrator
 * @Description:
 * @Date: 2021/6/25 16:00
 * @Version: 1.0
 */
@Table(name = "tb_ldc")
public class Environment implements Serializable {
    @Id
    private Integer id;
    private String name;
    private String api_adress;
    private String kefu_adress;
    private String aieoms_adress;
    private String aiossmweb_adress;
    private String esitms_adress;
    private String esom_adress;
    private String esomitms_adress;
    private String tcloud_adress;
    private String scpweb_adress;
    private String fanruan_adress;
    private String a1webgz_adress;
    private String desktop_adress;
    private String openfire_adress;
    private String a1openfire_adress;
    private String mgo_adress;
    private String rmq_adress;
    private String reds_adress;
    private String pinpoin_adress;
    private String apm_adress;
    private String log_adress;
    private String data_adress;
    private String youhuo_adress;
    private java.util.Date create_time;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getApi_adress() {
        return api_adress;
    }

    public void setApi_adress(String api_adress) {
        this.api_adress = api_adress;
    }

    public String getKefu_adress() {
        return kefu_adress;
    }

    public void setKefu_adress(String kefu_adress) {
        this.kefu_adress = kefu_adress;
    }

    public String getAieoms_adress() {
        return aieoms_adress;
    }

    public void setAieoms_adress(String aieoms_adress) {
        this.aieoms_adress = aieoms_adress;
    }

    public String getAiossmweb_adress() {
        return aiossmweb_adress;
    }

    public void setAiossmweb_adress(String aiossmweb_adress) {
        this.aiossmweb_adress = aiossmweb_adress;
    }

    public String getEsitms_adress() {
        return esitms_adress;
    }

    public void setEsitms_adress(String esitms_adress) {
        this.esitms_adress = esitms_adress;
    }

    public String getEsom_adress() {
        return esom_adress;
    }

    public void setEsom_adress(String esom_adress) {
        this.esom_adress = esom_adress;
    }

    public String getEsomitms_adress() {
        return esomitms_adress;
    }

    public void setEsomitms_adress(String esomitms_adress) {
        this.esomitms_adress = esomitms_adress;
    }

    public String getTcloud_adress() {
        return tcloud_adress;
    }

    public void setTcloud_adress(String tcloud_adress) {
        this.tcloud_adress = tcloud_adress;
    }

    public String getScpweb_adress() {
        return scpweb_adress;
    }

    public void setScpweb_adress(String scpweb_adress) {
        this.scpweb_adress = scpweb_adress;
    }

    public String getFanruan_adress() {
        return fanruan_adress;
    }

    public void setFanruan_adress(String fanruan_adress) {
        this.fanruan_adress = fanruan_adress;
    }

    public String getA1webgz_adress() {
        return a1webgz_adress;
    }

    public void setA1webgz_adress(String a1webgz_adress) {
        this.a1webgz_adress = a1webgz_adress;
    }

    public String getDesktop_adress() {
        return desktop_adress;
    }

    public void setDesktop_adress(String desktop_adress) {
        this.desktop_adress = desktop_adress;
    }

    public String getOpenfire_adress() {
        return openfire_adress;
    }

    public void setOpenfire_adress(String openfire_adress) {
        this.openfire_adress = openfire_adress;
    }

    public String getA1openfire_adress() {
        return a1openfire_adress;
    }

    public void setA1openfire_adress(String a1openfire_adress) {
        this.a1openfire_adress = a1openfire_adress;
    }

    public String getMgo_adress() {
        return mgo_adress;
    }

    public void setMgo_adress(String mgo_adress) {
        this.mgo_adress = mgo_adress;
    }

    public String getRmq_adress() {
        return rmq_adress;
    }

    public void setRmq_adress(String rmq_adress) {
        this.rmq_adress = rmq_adress;
    }

    public String getReds_adress() {
        return reds_adress;
    }

    public void setReds_adress(String reds_adress) {
        this.reds_adress = reds_adress;
    }

    public String getPinpoin_adress() {
        return pinpoin_adress;
    }

    public void setPinpoin_adress(String pinpoin_adress) {
        this.pinpoin_adress = pinpoin_adress;
    }

    public String getApm_adress() {
        return apm_adress;
    }

    public void setApm_adress(String apm_adress) {
        this.apm_adress = apm_adress;
    }

    public String getLog_adress() {
        return log_adress;
    }

    public void setLog_adress(String log_adress) {
        this.log_adress = log_adress;
    }

    public String getData_adress() {
        return data_adress;
    }

    public void setData_adress(String data_adress) {
        this.data_adress = data_adress;
    }

    public String getYouhuo_adress() {
        return youhuo_adress;
    }

    public void setYouhuo_adress(String youhuo_adress) {
        this.youhuo_adress = youhuo_adress;
    }

    public Date getCreate_time() {
        return create_time;
    }

    public void setCreate_time(Date create_time) {
        this.create_time = create_time;
    }

    @Override
    public String toString() {
        return "Environment{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", api_adress='" + api_adress + '\'' +
                ", kefu_adress='" + kefu_adress + '\'' +
                ", aieoms_adress='" + aieoms_adress + '\'' +
                ", aiossmweb_adress='" + aiossmweb_adress + '\'' +
                ", esitms_adress='" + esitms_adress + '\'' +
                ", esom_adress='" + esom_adress + '\'' +
                ", esomitms_adress='" + esomitms_adress + '\'' +
                ", tcloud_adress='" + tcloud_adress + '\'' +
                ", scpweb_adress='" + scpweb_adress + '\'' +
                ", fanruan_adress='" + fanruan_adress + '\'' +
                ", a1webgz_adress='" + a1webgz_adress + '\'' +
                ", desktop_adress='" + desktop_adress + '\'' +
                ", openfire_adress='" + openfire_adress + '\'' +
                ", a1openfire_adress='" + a1openfire_adress + '\'' +
                ", mgo_adress='" + mgo_adress + '\'' +
                ", rmq_adress='" + rmq_adress + '\'' +
                ", reds_adress='" + reds_adress + '\'' +
                ", pinpoin_adress='" + pinpoin_adress + '\'' +
                ", apm_adress='" + apm_adress + '\'' +
                ", log_adress='" + log_adress + '\'' +
                ", data_adress='" + data_adress + '\'' +
                ", youhuo_adress='" + youhuo_adress + '\'' +
                ", create_time=" + create_time +
                '}';
    }
}
