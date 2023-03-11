package com.hbase_java;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Put;
import org.apache.hadoop.hbase.client.Table;

import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertDataToEmpTable {
    public static void main(String[] args) throws Exception {
        // 创建HBase配置对象
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "bigdata:2181");
        // 创建HBase连接对象
        Connection conn = ConnectionFactory.createConnection(conf);

        // 创建表对象
        Table table = conn.getTable(TableName.valueOf("emp"));

        // 创建数据行对象
        Put put1 = new Put("7369".getBytes());
        put1.addColumn("info".getBytes(), "empno".getBytes(), "7369".getBytes());
        put1.addColumn("info".getBytes(), "ename".getBytes(), "SMITH".getBytes());
        put1.addColumn("info".getBytes(), "job".getBytes(), "CLERK".getBytes());
        put1.addColumn("info".getBytes(), "mgr".getBytes(), "7902".getBytes());
        put1.addColumn("info".getBytes(), "hiredate".getBytes(), new SimpleDateFormat("yyyy-MM-dd").parse("1980-12-17").getTime(), "1980-12-17".getBytes());
        put1.addColumn("info".getBytes(), "sal".getBytes(), "800.00".getBytes());
        put1.addColumn("info".getBytes(), "credit".getBytes(), "".getBytes());
        put1.addColumn("info".getBytes(), "deptno".getBytes(), "20".getBytes());

        Put put2 = new Put("7499".getBytes());
        put2.addColumn("info".getBytes(), "empno".getBytes(), "7499".getBytes());
        put2.addColumn("info".getBytes(), "ename".getBytes(), "ALLEN".getBytes());
        put2.addColumn("info".getBytes(), "job".getBytes(), "SALESMAN".getBytes());
        put2.addColumn("info".getBytes(), "mgr".getBytes(), "7698".getBytes());
        put2.addColumn("info".getBytes(), "hiredate".getBytes(), new SimpleDateFormat("yyyy-MM-dd").parse("1981-2-20").getTime(), "1981-2-20".getBytes());
        put2.addColumn("info".getBytes(), "sal".getBytes(), "1600.00".getBytes());
        put2.addColumn("info".getBytes(), "credit".getBytes(), "300.00".getBytes());
        put2.addColumn("info".getBytes(), "deptno".getBytes(), "30".getBytes());

        Put put3 = new Put("7521".getBytes());
        put3.addColumn("info".getBytes(), "empno".getBytes(), "7521".getBytes());
        put3.addColumn("info".getBytes(), "ename".getBytes(), "WARD".getBytes());
        put3.addColumn("info".getBytes(), "job".getBytes(), "SALESMAN".getBytes());
        put3.addColumn("info".getBytes(), "mgr".getBytes(), "7698".getBytes());
        put3.addColumn("info".getBytes(), "hiredate".getBytes(), new SimpleDateFormat("yyyy-MM-dd").parse("1981-2-22").getTime(), "1981-2-22".getBytes());
        put3.addColumn("info".getBytes(), "sal".getBytes(), "1250.00".getBytes());
        put3.addColumn("info".getBytes(), "credit".getBytes(), "500.00".getBytes());
        put3.addColumn("info".getBytes(), "deptno".getBytes(), "30".getBytes());

        Put put4 = new Put("7566".getBytes());
        put4.addColumn("info".getBytes(), "empno".getBytes(), "7566".getBytes());
        put4.addColumn("info".getBytes(), "ename".getBytes(), "JONES".getBytes());
        put4.addColumn("info".getBytes(), "job".getBytes(), "MANAGER".getBytes());
        put4.addColumn("info".getBytes(), "mgr".getBytes(), "7839".getBytes());
        put4.addColumn("info".getBytes(), "hiredate".getBytes(), new SimpleDateFormat("yyyy-MM-dd").parse("1981-4-2").getTime(), "1981-4-2".getBytes());
        put4.addColumn("info".getBytes(), "sal".getBytes(), "2975.00".getBytes());
        put4.addColumn("info".getBytes(), "credit".getBytes(), "".getBytes());
        put4.addColumn("info".getBytes(), "deptno".getBytes(), "20".getBytes());

        Put put5 = new Put("7654".getBytes());
        put5.addColumn("info".getBytes(), "empno".getBytes(), "7654".getBytes());
        put5.addColumn("info".getBytes(), "ename".getBytes(), "MARTIN".getBytes());
        put5.addColumn("info".getBytes(), "job".getBytes(), "SALESMAN".getBytes());
        put5.addColumn("info".getBytes(), "mgr".getBytes(), "7698".getBytes());
        put5.addColumn("info".getBytes(), "hiredate".getBytes(), new SimpleDateFormat("yyyy-MM-dd").parse("1981-9-28").getTime(), "1981-9-28".getBytes());
        put5.addColumn("info".getBytes(), "sal".getBytes(), "1250.00".getBytes());
        put5.addColumn("info".getBytes(), "credit".getBytes(), "1400.00".getBytes());
        put5.addColumn("info".getBytes(), "deptno".getBytes(), "30".getBytes());

        Put put6 = new Put("7698".getBytes());
        put6.addColumn("info".getBytes(), "empno".getBytes(), "7698".getBytes());
        put6.addColumn("info".getBytes(), "ename".getBytes(), "BLAKE".getBytes());
        put6.addColumn("info".getBytes(), "job".getBytes(), "MANAGER".getBytes());
        put6.addColumn("info".getBytes(), "mgr".getBytes(), "7839".getBytes());
        put6.addColumn("info".getBytes(), "hiredate".getBytes(), new SimpleDateFormat("yyyy-MM-dd").parse("1981-5-1").getTime(), "1981-5-1".getBytes());
        put6.addColumn("info".getBytes(), "sal".getBytes(), "2850.00".getBytes());
        put6.addColumn("info".getBytes(), "credit".getBytes(), "".getBytes());
        put6.addColumn("info".getBytes(), "deptno".getBytes(), "30".getBytes());

        Put put7 = new Put("7782".getBytes());
        put7.addColumn("info".getBytes(), "empno".getBytes(), "7782".getBytes());
        put7.addColumn("info".getBytes(), "ename".getBytes(), "CLARK".getBytes());
        put7.addColumn("info".getBytes(), "job".getBytes(), "MANAGER".getBytes());
        put7.addColumn("info".getBytes(), "mgr".getBytes(), "7839".getBytes());
        put7.addColumn("info".getBytes(), "hiredate".getBytes(), new SimpleDateFormat("yyyy-MM-dd").parse("1981-6-9").getTime(), "1981-6-9".getBytes());
        put7.addColumn("info".getBytes(), "sal".getBytes(), "2450.00".getBytes());
        put7.addColumn("info".getBytes(), "credit".getBytes(), "".getBytes());
        put7.addColumn("info".getBytes(), "deptno".getBytes(), "10".getBytes());

        // 插入数据行
        table.put(put1);
        table.put(put2);
        table.put(put3);
        table.put(put4);
        table.put(put5);
        table.put(put6);
        table.put(put7);

        // 关闭资源
        table.close();
        conn.close();
    }
}