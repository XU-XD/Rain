package com.xxd.service.impl;

import com.xxd.dao.RainQualityDao;
import com.xxd.dao.impl.RainQualityDaoImpl;
import com.xxd.domain.RainQuality;
import com.xxd.service.RainQualityService;

import java.util.List;

/**
 * projectName:RainManage
 * author:xuxindong
 * time:2021/6/25 11:28
 * description:
 */
public class RainQualityServiceImpl implements RainQualityService {
    private RainQualityDao rainQualityDao=new RainQualityDaoImpl();
    @Override
    public List<RainQuality> findAll() {
        return rainQualityDao.selectAll();
    }

    @Override
    public void remove(String id) {
        rainQualityDao.delete(id);
    }

    @Override
    public void add(RainQuality rainQuality) {
        rainQualityDao.insert(rainQuality);
    }
}