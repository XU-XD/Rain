package com.xxd.dao;

import com.xxd.domain.RainQuality;

import java.util.List;

public interface RainQualityDao {
    List<RainQuality> selectAll();

    void delete(String id);

    void insert(RainQuality rainQuality);
}
