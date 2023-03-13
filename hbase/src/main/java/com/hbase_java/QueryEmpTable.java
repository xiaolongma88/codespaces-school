package com.hbase_java;
import org.apache.hadoop.conf.Configuration;
import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.TableName;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.apache.hadoop.hbase.client.Result;
import org.apache.hadoop.hbase.client.ResultScanner;
import org.apache.hadoop.hbase.client.Scan;
import org.apache.hadoop.hbase.client.Table;
import org.apache.hadoop.hbase.filter.CompareFilter;
import org.apache.hadoop.hbase.filter.FilterList;
import org.apache.hadoop.hbase.filter.SingleColumnValueFilter;
import org.apache.hadoop.hbase.filter.SubstringComparator;

public class QueryEmpTable {
    public static void main(String[] args) throws Exception {
        // 创建HBase配置对象
        Configuration conf = HBaseConfiguration.create();
        conf.set("hbase.zookeeper.quorum", "bigdata:2181");
        // 创建HBase连接对象
        Connection conn = ConnectionFactory.createConnection(conf);

        // 创建表对象
        Table table = conn.getTable(TableName.valueOf("emp"));

        // 创建查询对象
        Scan scan = new Scan();

        // 创建过滤器列表对象
        FilterList filterList = new FilterList(FilterList.Operator.MUST_PASS_ALL);

        // 创建过滤器对象
        SingleColumnValueFilter filter = new SingleColumnValueFilter("info".getBytes(), "empno".getBytes(), CompareFilter.CompareOp.GREATER_OR_EQUAL, new SubstringComparator("7500"));

        // 将过滤器添加到过滤器列表中
        filterList.addFilter(filter);

        // 将过滤器列表添加到查询对象中
        scan.setFilter(filterList);

        // 执行查询
        ResultScanner scanner = table.getScanner(scan);

        // 遍历结果集
        for (Result result : scanner) {
            System.out.println("empno: " + new String(result.getValue("info".getBytes(), "empno".getBytes())));
            System.out.println("ename: " + new String(result.getValue("info".getBytes(), "ename".getBytes())));
            System.out.println("job: " + new String(result.getValue("info".getBytes(), "job".getBytes())));
            System.out.println("mgr: " + new String(result.getValue("info".getBytes(), "mgr".getBytes())));
            System.out.println("hiredate: " + new String(result.getValue("info".getBytes(), "hiredate".getBytes())));
            System.out.println("sal: " + new String(result.getValue("info".getBytes(), "sal".getBytes())));
            System.out.println("credit: " + new String(result.getValue("info".getBytes(), "credit".getBytes())));
            System.out.println("deptno: " + new String(result.getValue("info".getBytes(), "deptno".getBytes())));
            System.out.println("-----------------------------");
        }

        // 关闭资源
        scanner.close();
        table.close();
        conn.close();
    }
}
