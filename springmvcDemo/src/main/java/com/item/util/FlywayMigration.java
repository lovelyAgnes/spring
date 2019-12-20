package com.item.util;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

public class FlywayMigration {
	private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void migrate() {  
        //初始化flyway类
        Flyway flyway = new Flyway();
        //如果是新的项目，则无需配置此项
        flyway.setBaselineOnMigrate(true);
        //设置加载数据库的相关配置信息
        flyway.setDataSource(dataSource);
        //设置存放flyway metadata数据的表名，默认"schema_version"，可不写
        flyway.setTable("SCHMA_VERSION");
        //设置flyway扫描sql升级脚本、java升级脚本的目录路径或包路径，默认"db/migration"，可不写
        flyway.setLocations("db/migration");
        //设置sql脚本文件的编码，默认"UTF-8"，可不写
        flyway.setEncoding("UTF-8");
        //sql文件的前缀
        flyway.setSqlMigrationPrefix("V-");
        //如果是已执行过的项目，则需执行sql文件的基本版本
        flyway.setBaselineVersionAsString("1.0.0.0");
        flyway.setSqlMigrationSuffix(".sql");
        flyway.migrate();
    }
}
