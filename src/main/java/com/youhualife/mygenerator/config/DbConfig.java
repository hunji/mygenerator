package com.youhualife.mygenerator.config;

import com.youhualife.mygenerator.dao.*;
import com.youhualife.mygenerator.utils.MyException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

/**
 * @author hunji
 * @version 1.0
 * @date 2020-11-17 15:07
 */
@Configuration
public class DbConfig {
    @Value("${mygenerator.database: mysql}")
    private String database;

    @Autowired
    private MySQLGeneratorDao mySQLGeneratorDao;
    @Autowired
    private OracleGeneratorDao oracleGeneratorDao;
    @Autowired
    private SQLServerGeneratorDao sqlServerGeneratorDao;
    @Autowired
    private PostgreSQLGeneratorDao postgreSQLGeneratorDao;

    @Bean
    @Primary
    public GeneratorDao getGeneratorDao(){
        if("mysql".equalsIgnoreCase(database)){
            return mySQLGeneratorDao;
        }else if("oracle".equalsIgnoreCase(database)){
            return oracleGeneratorDao;
        }else if("sqlserver".equalsIgnoreCase(database)){
            return sqlServerGeneratorDao;
        }else if("postgresql".equalsIgnoreCase(database)){
            return postgreSQLGeneratorDao;
        }else {
            throw new MyException("不支持当前数据库：" + database);
        }
    }
}
