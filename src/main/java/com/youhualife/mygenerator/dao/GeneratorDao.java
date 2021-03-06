package com.youhualife.mygenerator.dao;

import java.util.List;
import java.util.Map;

/**
 * 数据库接口
 *
 * @author hunji
 * @version 1.0
 * @date 2020-11-17 15:09
 */
public interface GeneratorDao {
    List<Map<String, Object>> queryList(Map<String, Object> map);

    Map<String, String> queryTable(String tableName);

    List<Map<String, String>> queryColumns(String tableName);
}
