package com.xxd.domain;

/**
 * projectName:RainManage
 * author:xuxindong
 * time:2021/6/24 16:10
 * description:
 */

import java.util.Date;

/**
 * CREATE TABLE rainQuality(
 *     id INT PRIMARY KEY AUTO_INCREMENT,
 *     districtName VARCHAR(22) NOT NULL,
 *     monitorTime DATE NOT NULL,
 *     rain INT NOT NULL,
 *     monitoringStation VARCHAR(200) NOT NULL,
 *     monitoringAddress VARCHAR(200) NOT NULL
 * );
 */
public class RainQuality {
private Integer id;
private String districtName;
private Date monitorTime;
private Integer rain;
private String monitoringStation;
private String monitoringAddress;

    public RainQuality(Integer id, String districtName, Date monitorTime, Integer rain, String monitoringStation, String monitoringAddress) {
        this.id = id;
        this.districtName = districtName;
        this.monitorTime = monitorTime;
        this.rain = rain;
        this.monitoringStation = monitoringStation;
        this.monitoringAddress = monitoringAddress;
    }

    public RainQuality() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDistrictName() {
        return districtName;
    }

    public void setDistrictName(String districtName) {
        this.districtName = districtName;
    }

    public Date getMonitorTime() {
        return monitorTime;
    }

    public void setMonitorTime(Date monitorTime) {
        this.monitorTime = monitorTime;
    }

    public Integer getRain() {
        return rain;
    }

    public void setRain(Integer rain) {
        this.rain = rain;
    }

    public String getMonitoringStation() {
        return monitoringStation;
    }

    public void setMonitoringStation(String monitoringStation) {
        this.monitoringStation = monitoringStation;
    }

    public String getMonitoringAddress() {
        return monitoringAddress;
    }

    public void setMonitoringAddress(String monitoringAddress) {
        this.monitoringAddress = monitoringAddress;
    }

    @Override
    public String toString() {
        return "RainQuality{" +
                "id=" + id +
                ", districtName='" + districtName + '\'' +
                ", monitorTime=" + monitorTime +
                ", rain=" + rain +
                ", monitoringStation='" + monitoringStation + '\'' +
                ", monitoringAddress='" + monitoringAddress + '\'' +
                '}';
    }
}