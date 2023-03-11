package com.hbase_java;

import java.util.ArrayList;

import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;

import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Admin;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptor;
import org.apache.hadoop.hbase.client.ColumnFamilyDescriptorBuilder;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Get;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.client.TableDescriptor;
import org.apache.hadoop.hbase.client.TableDescriptorBuilder;
import org.apache.hadoop.hbase.util.Bytes;



public class CreateEmpTable {
    public static void main(String[] args) throws Exception {
        // 创建HBase配置对象
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "bigdata:2181");
        // 创建HBase连接对象
        Connection conn = ConnectionFactory.createConnection(conf);

        // 创建HBase管理对象
        Admin admin = conn.getAdmin();

        // 创建表描述符对象
        TableName tableName=TableName.valueOf("emp");
        byte[] empinfo = Bytes.toBytes("info");
     
        TableDescriptor tableDescriptor = TableDescriptorBuilder.newBuilder(tableName)
                .setColumnFamily((ColumnFamilyDescriptor) TableDescriptorBuilder.newBuilder(TableName.valueOf(empinfo)).build())
                .build();
        admin.createTable(tableDescriptor);

        // 关闭资源
        admin.close();
        conn.close();
    }
}