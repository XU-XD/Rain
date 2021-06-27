package com.xxd.service;

import com.xxd.domain.RainQuality;

import java.util.List;

public interface RainQualityService {
    List<RainQuality> findAll();

    void remove(String id);

    void add(RainQuality rainQuality);
}
