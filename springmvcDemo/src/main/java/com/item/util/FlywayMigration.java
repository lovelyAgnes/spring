package com.item.util;

import javax.sql.DataSource;

import org.flywaydb.core.Flyway;

public class FlywayMigration {
	private DataSource dataSource;

    public void setDataSource(DataSource dataSource) {
        this.dataSource = dataSource;
    }


    public void migrate() {  
        //��ʼ��flyway��
        Flyway flyway = new Flyway();
        //������µ���Ŀ�����������ô���
        flyway.setBaselineOnMigrate(true);
        //���ü������ݿ�����������Ϣ
        flyway.setDataSource(dataSource);
        //���ô��flyway metadata���ݵı�����Ĭ��"schema_version"���ɲ�д
        flyway.setTable("SCHMA_VERSION");
        //����flywayɨ��sql�����ű���java�����ű���Ŀ¼·�����·����Ĭ��"db/migration"���ɲ�д
        flyway.setLocations("db/migration");
        //����sql�ű��ļ��ı��룬Ĭ��"UTF-8"���ɲ�д
        flyway.setEncoding("UTF-8");
        //sql�ļ���ǰ׺
        flyway.setSqlMigrationPrefix("V-");
        //�������ִ�й�����Ŀ������ִ��sql�ļ��Ļ����汾
        flyway.setBaselineVersionAsString("1.0.0.0");
        flyway.setSqlMigrationSuffix(".sql");
        flyway.migrate();
    }
}
