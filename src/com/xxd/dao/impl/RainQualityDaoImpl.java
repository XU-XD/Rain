package com.xxd.dao.impl;

import com.xxd.dao.RainQualityDao;
import com.xxd.domain.RainQuality;
import com.xxd.util.DataSourceUtil;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanListHandler;

import java.sql.SQLException;
import java.util.List;

/**
 * projectName:RainManage
 * author:xuxindong
 * time:2021/6/25 11:45
 * description:
 */
public class RainQualityDaoImpl implements RainQualityDao {
    private QueryRunner queryRunner = new QueryRunner(DataSourceUtil.getDataSource());
    @Override
    public List<RainQuality> selectAll() {
        String sql = "SELECT * FROM rainQuality";
        try {
            return queryRunner.query(sql,new BeanListHandler<>(RainQuality.class));
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void delete(String id) {
        String sql = "DELETE FROM rainQuality WHERE id=?";
        try {
            queryRunner.update(sql,id);
        } catch (SQLException e) {
            e.printStackTrace();
            throw new RuntimeException(e);
        }
    }

    @Override
    public void insert(RainQuality rainQuality) {
        String sql=" insert into rainQuality values (null,?,?,?,?,?) ";
        Object[] params={rainQuality.getDistrictName(),rainQuality.getMonitorTime(),
                rainQuality.getRain(),rainQuality.getMonitoringStation(),
                rainQuality.getMonitoringAddress()};
        try {
            queryRunner.update(sql,params);
        } catch (SQLException e) {
            e.printStackTrace();
            throw  new RuntimeException(e);
        }

    }
}